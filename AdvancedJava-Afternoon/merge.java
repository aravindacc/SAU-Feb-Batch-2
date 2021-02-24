
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class merge {

    public static final void upload(Document xml, String filename) throws Exception {
        Transformer tfactory = TransformerFactory.newInstance().newTransformer();
        tfactory.transform(new DOMSource(xml), new StreamResult(new File(filename)));
    }

    public static void main(String[] args) {
        try {

            File license1_doc1 = new File("license1.xml");
            File license2_doc2 = new File("license2.xml");

            DocumentBuilderFactory doc_factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder doc_builder = doc_factory.newDocumentBuilder();

            Document doc1 = doc_builder.parse(license1_doc1);
            Document doc2 = doc_builder.parse(license2_doc2);

            Document merged_doc = doc_builder.newDocument();

            doc1.getDocumentElement().normalize();
            doc2.getDocumentElement().normalize();

            NodeList doc1_CSR = doc1.getElementsByTagName("CSR_Producer");
            NodeList doc2_CSR = doc2.getElementsByTagName("CSR_Producer");

            Element root = merged_doc.createElement("CSR_Producer");
            merged_doc.appendChild(root);

            System.out.println("The files have been merged");

            for (int i = 0; i < doc1_CSR.getLength(); i++) {

                Node curr_CSR1 = doc1_CSR.item(i);

                for (int j = 0; j < doc2_CSR.getLength(); j++) {

                    Node curr_CSR2 = doc2_CSR.item(j);

                    Element curr_Ele1 = (Element) curr_CSR1;
                    Element curr_Ele2 = (Element) curr_CSR2;

                    if (curr_Ele1.getAttribute("NIPR_Number").equals(curr_Ele2.getAttribute("NIPR_Number"))) {
                        NodeList license_list1 = curr_Ele1.getElementsByTagName("License");

                        for (int k = 0; k < license_list1.getLength(); k++) {

                            Element license_element1 = (Element) license_list1.item(k);
                            NodeList license_list2 = curr_Ele2.getElementsByTagName("License");

                            for (int l = 0; l < license_list2.getLength(); l++) {
                                Element license_element2 = (Element) license_list2.item(l);

                                if (license_element1.getAttribute("State_Code")
                                        .equals(license_element2.getAttribute("State_Code"))
                                        && license_element1.getAttribute("License_Number")
                                                .equals(license_element2.getAttribute("License_Number"))
                                        && license_element1.getAttribute("Date_Status_Effective")
                                                .equals(license_element2.getAttribute("Date_Status_Effective"))) {

                                    Node mergedElem = merged_doc.importNode(license_element2, true);
                                    root.appendChild(mergedElem);
                                    upload(merged_doc, "merge.xml");

                                }
                            }
                        }
                    }
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }

}
