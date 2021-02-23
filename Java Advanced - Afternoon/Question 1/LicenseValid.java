// --------------- IMPORTS ---------------------------------

import java.util.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

// ---------------------- CODE -----------------------------------

public class LicenseValid {

    private static void printLicenseDetails(Element currSubElement) {
        NamedNodeMap attributes = currSubElement.getAttributes();
        int numAttrs = attributes.getLength();

        for (int i = 0; i < numAttrs; i++) {
            Attr attr = (Attr) attributes.item(i);
            String attrName = attr.getNodeName();
            String attrValue = attr.getNodeValue();
            System.out.println(attrName + " : " + attrValue);
        }
        System.out.println("--------------------------\n");
    }

    private static String getTodaysDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).toString();
    }

    private static int compareDates(String expDate) throws ParseException {
        SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy");

        // Get the two dates to be compared
        Date d1 = sdfo.parse(expDate);
        Date d2 = sdfo.parse(getTodaysDate());

        // Compare the dates using compareTo()
        if (d1.compareTo(d2) > 0) {
            // When Date d1 > Date d2
            return 1;
        }

        else if (d1.compareTo(d2) < 0) {
            // When Date d1 < Date d2
            return -1;
        }

        // When Date d1 = Date d2
        return 0;

    }

    private static boolean isLicenseExpired(Element currSubElement) throws ParseException {
        String expDate = currSubElement.getAttribute("License_Expiration_Date");
        return compareDates(expDate) < 0 ? true : false;
    }

    private static void writeToFile(Document outputDoc, Element rootElement, Element curr_license) {
        try {
            // append first child element to root element
            Node valid_license = outputDoc.importNode(curr_license, true);
            rootElement.appendChild(valid_license);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            // INPUT FILE
            File inputXML1 = new File("License1.xml");
            File inputXML2 = new File("License2.xml");

            // READING INPUT FILE
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc1 = dBuilder.parse(inputXML1);
            Document doc2 = dBuilder.parse(inputXML2);

            Document outputDoc = dBuilder.newDocument();

            // add elements to Document
            Element rootElement = outputDoc.createElement("CSR_Producer");
            // append root element to document
            outputDoc.appendChild(rootElement);

            // License1.xml
            doc1.getDocumentElement().normalize();
            NodeList allCSRProducerNodes1 = doc1.getElementsByTagName("CSR_Producer");

            // System.out.println("Root element For License 1 is: " +
            // doc1.getDocumentElement().getNodeName());
            // System.out.println("Total CSR_PRODUCER Tags in License1.xml : " +
            // allCSRProducerNodes1.getLength());

            for (int i = 0; i < allCSRProducerNodes1.getLength(); i++) {
                Node nNode = allCSRProducerNodes1.item(i);
                Element currElement = (Element) nNode;
                NodeList currentLiscences = currElement.getElementsByTagName("License");
                // System.out.println("Got " + currentLiscences.getLength() + " Licenses Under
                // the current Tag");

                for (int j = 0; j < currentLiscences.getLength(); j++) {
                    Node nnNode = currentLiscences.item(j);
                    Element currSubElement = (Element) nnNode;

                    // printLicenseDetails(currSubElement);
                    boolean isExpiredLicense = isLicenseExpired(currSubElement);
                    if (isExpiredLicense == false) {
                        // System.out.println("License is Not Expired");
                        writeToFile(outputDoc, rootElement, currSubElement);
                    }
                }

                // System.out.println("-------------------------\nCompleted The Current Tag\n");
            }

            // ----------------------------------------------------------------------------------------------------

            // License2.xml
            doc2.getDocumentElement().normalize();
            NodeList allCSRProducerNodes2 = doc1.getElementsByTagName("CSR_Producer");
            // System.out.println("Root element License 2 is: " +
            // doc2.getDocumentElement().getNodeName());
            // System.out.println("Total CSR_PRODUCER Tags in License2.xml : " +
            // allCSRProducerNodes2.getLength());

            for (int i = 0; i < allCSRProducerNodes2.getLength(); i++) {
                Node nNode = allCSRProducerNodes2.item(i);
                Element currElement = (Element) nNode;
                NodeList currentLiscences = currElement.getElementsByTagName("License");
                // System.out.println("Got " + currentLiscences.getLength() + " Licenses Under
                // the current Tag");

                for (int j = 0; j < currentLiscences.getLength(); j++) {
                    Node nnNode = currentLiscences.item(j);
                    Element currSubElement = (Element) nnNode;

                    // printLicenseDetails(currSubElement);
                    boolean isExpiredLicense = isLicenseExpired(currSubElement);
                    if (isExpiredLicense == false) {
                        // System.out.println("License is Not Expired");
                        writeToFile(outputDoc, rootElement, currSubElement);
                    }
                }

                // System.out.println("-------------------------\nCompleted The Current Tag\n");
            }

            // for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(outputDoc);

            // write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("ValidLicenses.xml"));

            // write data
            transformer.transform(source, console);
            transformer.transform(source, file);

            System.out.println("Successfully Created Valid Licenses File as ValidLicenses.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}