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

public class FileMerger {

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

    private static void writeToFile(Document outputDoc, Element rootElement, Element curr_license) {
        try {
            // append first child element to root element
            Node valid_license = outputDoc.importNode(curr_license, true);
            rootElement.appendChild(valid_license);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkForEquality(Element licensesForElement1, Element licensesForElement2) {

        if (licensesForElement1.getAttribute("State_Code").equals(licensesForElement2.getAttribute("State_Code"))
                && licensesForElement1.getAttribute("License_Number")
                        .equals(licensesForElement2.getAttribute("License_Number"))
                && licensesForElement1.getAttribute("Date_Status_Effective")
                        .equals(licensesForElement2.getAttribute("Date_Status_Effective"))) {
            return true;
        }
        return false;
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

            doc1.getDocumentElement().normalize();
            NodeList allCSRProducerNodes1 = doc1.getElementsByTagName("CSR_Producer");
            doc2.getDocumentElement().normalize();
            NodeList allCSRProducerNodes2 = doc1.getElementsByTagName("CSR_Producer");

            // Iterating over all csr's in xml 1
            for (int i = 0; i < allCSRProducerNodes1.getLength(); i++) {

                // Nth Node in License1.xml
                Node currNode1 = allCSRProducerNodes1.item(i);
                Element currElement1 = (Element) currNode1;

                for (int j = 0; j < allCSRProducerNodes2.getLength(); j++) {

                    // Nth Node in License2.xml
                    Node currNode2 = allCSRProducerNodes2.item(j);
                    Element currElement2 = (Element) currNode2;

                    /**
                     * 
                     * Conditions For Checking Equality: If NIPR of current elements of currNode1
                     * matches currNode2, then check further with license Check All License
                     * Attributes then If All the things match, then equality is established
                     * 
                     */

                    if (currElement1.getAttribute("NIPR_Number").equals(currElement2.getAttribute("NIPR_Number"))) {
                        NodeList licensesForElement1 = currElement1.getElementsByTagName("License");

                        for (int k = 0; k < licensesForElement1.getLength(); k++) {
                            Element currLicenseElement1 = (Element) licensesForElement1.item(k);

                            NodeList licensesForElement2 = currElement2.getElementsByTagName("License");

                            for (int l = 0; l < licensesForElement2.getLength(); l++) {
                                Element currLicenseElement2 = (Element) licensesForElement2.item(l);

                                if (checkForEquality(currLicenseElement1, currLicenseElement2)) {
                                    writeToFile(outputDoc, rootElement, currLicenseElement2);
                                }
                            }
                        }
                    }
                }
            }

            // for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(outputDoc);

            // write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("MergedLicenses.xml"));

            // write data
            transformer.transform(source, console);
            transformer.transform(source, file);

            System.out.println("Successfully Merged Licenses File as MergedLicenses.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
