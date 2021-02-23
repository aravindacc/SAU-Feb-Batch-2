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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XMLParser {
    static HashMap<String, ArrayList<Element>> data = new HashMap<>();

    public static void fetch_same_nipr_number(String file_path) throws ParserConfigurationException, IOException, SAXException {
        System.out.println("Parsing File" + "\n\n");
        File inputFile = new File(file_path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // write this level1 element to merged file
        // data.add(new XMLNode(doc.getDocumentElement().getNodeName(), new ArrayList<>()));

        NodeList csrProducer = doc.getElementsByTagName("CSR_Producer");
        System.out.println(csrProducer.getLength());
        for(int i=0;i<csrProducer.getLength();i++) {
            Element currCSRProducer = (Element) csrProducer.item(i);
            String nipr_number = currCSRProducer.getAttribute("NIPR_Number");
            System.out.println("NIPR Number: " + nipr_number);
            ArrayList<Element> arr = data.get(nipr_number);
            if (arr != null) {
                data.get(nipr_number).add(currCSRProducer);
            } else {
                arr = new ArrayList<>();
                arr.add(currCSRProducer);
                data.put(nipr_number, arr);
            }
//            if (data.get(nipr_number) != null) {
//                ArrayList<Element> arr = data.get(nipr_number);
//                arr.add(currCSRProducer);
//            } else {
//
//            }

//            NodeList license = currCSRProducer.getElementsByTagName("License");
//            System.out.println(license.getLength());
//            for(int j=0;j<license.getLength();j++) {
//                Element currLicense = (Element) license.item(j);
//                String state_code = currLicense.getAttribute("State_Code");
//                String license_number = currLicense.getAttribute("License_Number");
//                String effective_date = currLicense.getAttribute("Date_Status_Effective");
//                System.out.println(state_code + " " + license_number + " " + effective_date);
//                System.out.println(currLicense);
//            }
        }
    }

    public static HashMap<String, ArrayList<Element>> fetch_same_other_keys() {
        HashMap<String, ArrayList<Element>> sameLicences = new HashMap<>();
        for(Map.Entry mapEntry: data.entrySet()) {
            String nipr_number = (String) mapEntry.getKey();
            ArrayList<Element> mergedCSRProducer = (ArrayList<Element>) mapEntry.getValue();
            for(Element CSRProducer: mergedCSRProducer) {
                NodeList licenseNodes = CSRProducer.getElementsByTagName("License");
                for(int i=0;i<licenseNodes.getLength();i++) {
                    Element license = (Element) licenseNodes.item(i);
                    String state_code = license.getAttribute("State_Code");
                    String license_number = license.getAttribute("License_Number");
                    String effective_date = license.getAttribute("Date_Status_Effective");
                    String key = nipr_number + ":" + state_code + license_number + effective_date;

                    ArrayList<Element> arr = sameLicences.get(key);
                    if (arr != null) {
                        sameLicences.get(key).add(license);
                    } else {
                        arr = new ArrayList<>();
                        arr.add(license);
                        sameLicences.put(key, arr);
                    }
                }
            }
        }
        return sameLicences;
    }

    public static void printHashmapElements(HashMap<String, ArrayList<Element>> hm) {
            for(Map.Entry mapEntry: hm.entrySet()) {
            String key = (String) mapEntry.getKey();
            ArrayList<Element> curr = (ArrayList<Element>) mapEntry.getValue();
            System.out.println(key + " " + curr.size());
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        fetch_same_nipr_number("License1.xml");
        fetch_same_nipr_number("License2.xml");
//        HashMap<Integer, Integer> mp = new HashMap<>();
//        mp.put(1, 2);
//        System.out.println(mp.get(2));

//        for(Map.Entry mapEntry: data.entrySet()) {
//            String key = (String) mapEntry.getKey();
//            ArrayList<Element> curr = (ArrayList<Element>) mapEntry.getValue();
//            for(Element e: curr) {
//                System.out.println(e);
//            }
//            System.out.println();
//        }

        HashMap<String, ArrayList<Element>> licenses = fetch_same_other_keys();
        printHashmapElements(licenses);

        // Write to XML file

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element rootElement = doc.createElement("CSR_Report");
        doc.appendChild(rootElement);

        Element body = doc.createElement("CSR_Report_Body");
        rootElement.appendChild(body);

        for(Map.Entry dataMapEntry: data.entrySet()) {
            String key = (String) dataMapEntry.getKey();
            Element producer = doc.createElement("CSR_Producer");
            Attr nipr_number = doc.createAttribute("NIPR_Number");
            nipr_number.setValue(key);
            producer.setAttributeNode(nipr_number);
            body.appendChild(producer);
            for(Map.Entry licenseMapEntry: licenses.entrySet()) {
                String license_key = (String) licenseMapEntry.getKey();
                String[] splitted_key = license_key.split(":", 2);
                String nipr = splitted_key[0];
                if (nipr.equals(key)) {
                    ArrayList<Element> license = (ArrayList<Element>) licenseMapEntry.getValue();
                    Element licenseNode = doc.createElement("License");
                    for (Element l: license) {

                        NamedNodeMap np = l.getAttributes();
                        for(int i=0;i< np.getLength();i++) {
                            // System.out.println(((Attr) np.item(i)).getName() + " - " + ((Attr) np.item(i)).getValue());
                            Attr attr = doc.createAttribute(((Attr) np.item(i)).getName());
                            attr.setValue(((Attr) np.item(i)).getValue());
                            licenseNode.setAttributeNode(attr);
                        }

                        // All the LOA of this Element l will be added to this license node

                        NodeList LOAs = l.getElementsByTagName("LOA");
                        for(int i=0;i<LOAs.getLength();i++) {
                            Element loa = (Element) LOAs.item(i);

                            Element loaNode = doc.createElement("LOA");

                            NamedNodeMap loaNodeAttributes = loa.getAttributes();
                            for(int j=0;j<loaNodeAttributes.getLength();j++) {
                                Attr loaNodeAttribute = doc.createAttribute(((Attr) loaNodeAttributes.item(j)).getName());
                                loaNodeAttribute.setValue(((Attr) loaNodeAttributes.item(j)).getValue());
                                loaNode.setAttributeNode(loaNodeAttribute);
                            }

                            licenseNode.appendChild(loaNode);
                        }

                        producer.appendChild(licenseNode);
                    }
                }
//                System.out.println(license_key);
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult("merged.xml");
        transformer.transform(source, result);

        System.out.println("Checking");
        printHashmapElements(licenses);

    }
}
