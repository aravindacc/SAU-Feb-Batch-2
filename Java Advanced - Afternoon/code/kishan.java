package assignments;
 
import java.util.* ; 
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

public class kishan {
	
	
	public static final void prettyPrint(Document xml , String filename) throws Exception {
        Transformer tfactory = TransformerFactory.newInstance().newTransformer();
        tfactory.transform(new DOMSource(xml), new StreamResult(new File(filename)));
    }

	
	public static void main(String[] args) {
		try {
			
	         File license1_doc1 = new File("assignments/license1.xml");
	         File license2_doc2 = new File("assignments/license2.xml");
	         
	         
	         // Using Document Builder Factory which helps us to parse our xml files 
	         // after parsing it returns a new DOM document object
	         DocumentBuilderFactory doc_factory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder doc_builder = doc_factory.newDocumentBuilder();
	         
	         Document doc1 = doc_builder.parse(license1_doc1);
	         Document doc2 = doc_builder.parse(license2_doc2);
	         
	         Document merged_doc = doc_builder.newDocument() ;
	         
	         doc1.getDocumentElement().normalize();
	         doc2.getDocumentElement().normalize();
	         
	         NodeList doc1_CSR = doc1.getElementsByTagName("CSR_Producer");
	         NodeList doc2_CSR = doc2.getElementsByTagName("CSR_Producer");
	         
	         // In merged doc we first create the root CSR producer, then we can append it's child based on the
	         // matching keys in the two documents
	         Element root = merged_doc.createElement("CSR_Producer");
	         merged_doc.appendChild(root);
	         
	         System.out.println("Added root to merged doc"); 
	         
	         // Iterating over all csr's in xml 1
	         for(int i = 0; i < doc1_CSR.getLength(); i++) {
	        	 
	        	 // Node curr_CSR1 denotes the current csr node in xml 1
	             Node curr_CSR1 = doc1_CSR.item(i);
	             
	             for(int j = 0 ; j < doc2_CSR.getLength() ; j++) {
	            	 
	            	 // Node curr_CSR2 denotes the current csr node in xml 2
	            	 Node curr_CSR2 = doc2_CSR.item(j) ; 
	            	
	            	 Element curr_Ele1 = (Element) curr_CSR1 ; 
	            	 Element curr_Ele2 = (Element) curr_CSR2 ;
	            	 
	            	 // If NIPR of current elements of csr1 and csr2 matches, then we check for License
	            	 if( curr_Ele1.getAttribute("NIPR_Number").equals(curr_Ele2.getAttribute("NIPR_Number")) ) {
	            		 NodeList license_list1 = curr_Ele1.getElementsByTagName("License");		 
	            		 
	            		 for(int k = 0 ; k < license_list1.getLength(); k++) {
	            			 
	            			 Element license_element1 = (Element)license_list1.item(k);
	            			 NodeList license_list2 = curr_Ele2.getElementsByTagName("License");
	            			 
	            			 for(int l = 0 ; l < license_list2.getLength() ; l++) {
	            				 Element license_element2 = (Element)license_list2.item(l) ; 
	            				 
	            				 // If in the license list 1 and 2, State Codes, License Number, and Effective License Date matches
	            				 // We put any of the license element as a child node in the merged doc
	            				 if(license_element1.getAttribute("State_Code").equals(license_element2.getAttribute("State_Code")) 
	            						 && license_element1.getAttribute("License_Number").equals(license_element2.getAttribute("License_Number"))
	            						 && license_element1.getAttribute("Date_Status_Effective").equals(license_element2.getAttribute("Date_Status_Effective"))) {

	            					 // if all of the above conditions are true, append license2 or license1's element in the merged doc
	            					 Node mergedElem = merged_doc.importNode(license_element2, true) ;  
	            					 root.appendChild(mergedElem);
	            					 prettyPrint(merged_doc, "assignments/merged_xmls.txt");
	            			         
	            				 }
	            			 }
	            		 }
	            	 }     	 
	             }
	         }
	         
	         
	         // Creating 2 docs for valid and invalid licenses
	         Document valid_docs = doc_builder.newDocument() ;
	         Document invalid_doc = doc_builder.newDocument() ;
	         
	         // For creating the valid_license doc
	         // Before appending any element, we need to add a root
	         Element validRoot = valid_docs.createElement("CSR_Producer");
	         valid_docs.appendChild(validRoot);
	         System.out.println("Added a root node to valid_docs");
	         
	         // same for invalid license doc
	         Element invalidRoot = invalid_doc.createElement("CSR_Producer");
	         invalid_doc.appendChild(invalidRoot);
	         System.out.println("Added a root node to invalid docs");

	         // Getting the list of all CSR's producer in merged doc
	         NodeList mergedDoc_CSR = merged_doc.getElementsByTagName("CSR_Producer");	         
	         for(int i = 0 ; i < mergedDoc_CSR.getLength(); i++) {
	        	 Element curr_ele = (Element) mergedDoc_CSR.item(i); 
	        	 NodeList license_list = curr_ele.getElementsByTagName("License"); 
	        	 
	        	 // After getting the license_list from merged Docs, we iterate on each entry
	        	 // in the list to check whether the license is valid or invalid
	        	 for(int j = 0 ; j < license_list.getLength() ; j++) {
	        		 Element curr_license =  (Element) license_list.item(j);
	        		 
	        		 // Getting the expiry date of the license.
	        		 String date = curr_license.getAttribute("License_Expiration_Date");
	        		 Date expiry_date = new SimpleDateFormat("dd/MM/yyyy").parse(date);  
	        		 
	        		 // Current date. (For comparison)
	        		 Date curr_date = new Date() ; 
	        		 
	        		 if(expiry_date.compareTo(curr_date) > 0) {
	        			 Node valid_license = valid_docs.importNode(curr_license, true) ;  
    					 validRoot.appendChild(valid_license) ;
    					 prettyPrint(valid_docs,"assignments/valid_licenses.txt");
	        		 }
	        		 else {
	        			 Node invalid_license = invalid_doc.importNode(curr_license, true) ;  
    					 invalidRoot.appendChild(invalid_license) ;
    					 prettyPrint(invalid_doc,"assignments/invalid_licenses.txt");
	        		 }
	        	 }
	         }	         
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println() ; 
		}
	}
	
	
}



