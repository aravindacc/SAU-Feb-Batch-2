import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class check {

    public static final void upload(Document xml, String filename) throws Exception {
        Transformer tfactory = TransformerFactory.newInstance().newTransformer();
        tfactory.transform(new DOMSource(xml), new StreamResult(new File(filename)));
    }

    public static void main(String argv[]) {
        try {

            File file = new File("merge.xml");

            DocumentBuilderFactory doc_factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder doc_builder = doc_factory.newDocumentBuilder();

            Document valid_docs = doc_builder.newDocument();
            Document invalid_doc = doc_builder.newDocument();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();
            ArrayList<String> expiry = new ArrayList<>();

            NodeList nodeList = doc.getElementsByTagName("License");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element tElement = (Element) node;

                    expiry.add(tElement.getAttribute("License_Expiration_Date"));

                }
            }

            Element validRoot = valid_docs.createElement("CSR_Producer");
            valid_docs.appendChild(validRoot);
            Element invalidRoot = invalid_doc.createElement("CSR_Producer");
            invalid_doc.appendChild(invalidRoot);

            for (int i = 0, j = 0; i < nodeList.getLength() && j < expiry.size(); i++, j++) {

                String d1 = expiry.get(j);
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(d1);

                long millis = System.currentTimeMillis();
                java.sql.Date date2 = new java.sql.Date(millis);
                Element curr_license = (Element) nodeList.item(i);

                if (date1.before(date2)) {

                    Node invalid_license = invalid_doc.importNode(curr_license, true);

                    invalidRoot.appendChild(invalid_license);
                    upload(invalid_doc, "invalid_licenses.xml");
                }

                else {

                    Node valid_license = valid_docs.importNode(curr_license, true);

                    validRoot.appendChild(valid_license);
                    upload(valid_docs, "valid_licenses.xml");
                }

            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}
