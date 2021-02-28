import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidLicense {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, ParseException, TransformerException {
        File inputFile = new File("merged.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        DocumentBuilder validBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document valid = validBuilder.newDocument();

        DocumentBuilder invalidBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document invalid = invalidBuilder.newDocument();

        Element validrootElement = valid.createElement("CSR_Report");
        valid.appendChild(validrootElement);

        Element invalidrootElement = invalid.createElement("CSR_Report");
        invalid.appendChild(invalidrootElement);

        Element valid_body = valid.createElement("CSR_Report_Body");
        validrootElement.appendChild(valid_body);

        Element invalid_body = invalid.createElement("CSR_Report_Body");
        invalidrootElement.appendChild(invalid_body);

        NodeList csrProducer = doc.getElementsByTagName("CSR_Producer");
        for(int i=0;i<csrProducer.getLength();i++) {
            Element currCSRProducer = (Element) csrProducer.item(i);
            String nipr_number = currCSRProducer.getAttribute("NIPR_Number");
            System.out.println("NIPR Number: " + nipr_number);

            Element valid_producer = valid.createElement("CSR_Producer");
            valid_body.appendChild(valid_producer);

            Element invalid_producer = invalid.createElement("CSR_Producer");
            invalid_body.appendChild(invalid_producer);

            NodeList licenseNodes = currCSRProducer.getElementsByTagName("License");
            for(int j=0;j<licenseNodes.getLength();j++) {
                Element license = (Element) licenseNodes.item(j);
                String str_expiration_date = license.getAttribute("License_Expiration_Date");
                Date expiration_date = new SimpleDateFormat("dd/MM/yyyy").parse(str_expiration_date);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date todayDate = dateFormat.parse(dateFormat.format(new Date()));
//                System.out.println("Expiration Date" + expiration_date);
//                System.out.println("Today Date" + todayDate);
//                System.out.println(todayDate.compareTo(expiration_date));
//                System.out.println();
                if (todayDate.compareTo(expiration_date) > 0) {
                    // expired
                    // write to InvalidLicense File
                    System.out.println("Invalid");
                    System.out.println("Expiration Date " + expiration_date);
                    System.out.println("Today Date " + todayDate);
                    System.out.println(todayDate.compareTo(expiration_date));
                    System.out.println();
                    Element licenseNode = invalid.createElement("License");
                    NamedNodeMap np = license.getAttributes();
                    for(int k=0;k<np.getLength();k++) {
                        Attr attr = invalid.createAttribute(((Attr) np.item(k)).getName());
                        attr.setValue(((Attr) np.item(k)).getValue());
                        licenseNode.setAttributeNode(attr);
                    }

                    // LOA's

                    NodeList LOAs = license.getElementsByTagName("LOA");
                    for(int x=0;x<LOAs.getLength();x++) {
                        Element loa = (Element) LOAs.item(x);

                        Element loaNode = invalid.createElement("LOA");

                        NamedNodeMap loaNodeAttributes = loa.getAttributes();
                        for (int y = 0; y < loaNodeAttributes.getLength(); y++) {
                            Attr loaNodeAttribute = invalid.createAttribute(((Attr) loaNodeAttributes.item(y)).getName());
                            loaNodeAttribute.setValue(((Attr) loaNodeAttributes.item(y)).getValue());
                            loaNode.setAttributeNode(loaNodeAttribute);
                        }
                        licenseNode.appendChild(loaNode);
                    }
                    invalid_producer.appendChild(licenseNode);
                } else {
                    // write to ValidLicense File
                    System.out.println("Valid");
                    System.out.println("Expiration Date " + expiration_date);
                    System.out.println("Today Date " + todayDate);
                    System.out.println(todayDate.compareTo(expiration_date));
                    System.out.println();
                    Element licenseNode = valid.createElement("License");
                    NamedNodeMap np = license.getAttributes();
                    for(int k=0;k<np.getLength();k++) {
                        Attr attr = valid.createAttribute(((Attr) np.item(k)).getName());
                        attr.setValue(((Attr) np.item(k)).getValue());
                        licenseNode.setAttributeNode(attr);
                    }
                    // LOA's

                    NodeList LOAs = license.getElementsByTagName("LOA");
                    for(int x=0;x<LOAs.getLength();x++) {
                        Element loa = (Element) LOAs.item(x);

                        Element loaNode = valid.createElement("LOA");

                        NamedNodeMap loaNodeAttributes = loa.getAttributes();
                        for (int y = 0; y < loaNodeAttributes.getLength(); y++) {
                            Attr loaNodeAttribute = valid.createAttribute(((Attr) loaNodeAttributes.item(y)).getName());
                            loaNodeAttribute.setValue(((Attr) loaNodeAttributes.item(y)).getValue());
                            loaNode.setAttributeNode(loaNodeAttribute);
                        }
                        licenseNode.appendChild(loaNode);
                    }

                    valid_producer.appendChild(licenseNode);
                }
            }
        }

        Transformer validTransformer = TransformerFactory.newInstance().newTransformer();
        validTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
        validTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
        validTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(valid);
        StreamResult result = new StreamResult("valid.xml");
        validTransformer.transform(source, result);

        Transformer invalidTransformer = TransformerFactory.newInstance().newTransformer();
        invalidTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
        invalidTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
        invalidTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        source = new DOMSource(invalid);
        result = new StreamResult("invalid.xml");
        validTransformer.transform(source, result);
    }
}
