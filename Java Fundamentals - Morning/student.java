package assignments;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.*;


class student_desearlized implements Serializable{
    
    public int rollNumber;
    public int student_marks;
    
    student_desearlized (int rollNumber,int student_marks){
    	this.rollNumber=rollNumber;
    	this.student_marks=student_marks;
    }
}


class student_details {
	
    int marks;
    int rollNumber;
    String subject;
    
    student_details(int rollNumber, int marks, String subject)
    {
        this.rollNumber=rollNumber;
        this.marks=marks;
        this.subject=subject;
    }
}


public class student implements Serializable  {
    
    public static void main(String args[])throws Exception
    {
        
        try{

        	// reading the students.xml
            File inputFile = new File("assignments\\students.xml");
            
            // Using Document Builder Factory which helps us to parse our students.xml 
            // after parsing it returns a new DOM document object
            DocumentBuilderFactory documentfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docbuilder = documentfactory.newDocumentBuilder();
            Document nodeObject = docbuilder.parse(inputFile);
            
            // normalizing to put all the text nodes under a student node.
            // basically normalizing each nodes
            nodeObject.getDocumentElement().normalize();
            
            
            // Using the NodeList for abstracting the nodes from student.xml in an order
            // and iterating through the list of nodes
            NodeList nodes = nodeObject.getElementsByTagName("student");
            
            
            // students_arr is the array of student_details object
            int no_of_entries = nodes.getLength(); 
            student_details[] students_arr = new student_details[no_of_entries];
            
            for (int i = 0; i < no_of_entries; i++) {
                Node xmlnode = nodes.item(i);
                Element xmlElement = (Element) xmlnode;
                
                // Parsing the integer form of rollnumber and marks
                int student_roll = Integer.parseInt(xmlElement.getElementsByTagName("roll").item(0).getTextContent());
                int student_marks= Integer.parseInt(xmlElement.getElementsByTagName("marks").item(0).getTextContent());
                String subject = xmlElement.getElementsByTagName("subject").item(0).getTextContent();
                
                // each student_arr entry will contain a student_details object, 
                // constructor is used to initialize and return a student_details object
                students_arr[i] = new student_details(student_roll, student_marks, subject);
                
                
                // First part of question 1. Deserializing the students.xml to java objects
                // Here we have the array of student objects. 
                System.out.println(students_arr[i].marks + " " + students_arr[i].rollNumber + " " + students_arr[i].subject);
            }
            
            
            
            
            // Second part of question 1
            // Creating a hashmap for storing the student roll number as a key and total marks as it's value
            HashMap <Integer, Integer> students_hash = new HashMap<>();
            for (int i = 0; i < no_of_entries; i++) {
            	int key_roll = students_arr[i].rollNumber;
            	if (students_hash.containsKey(key_roll)) {
            		int total_so_far = students_hash.get(key_roll);
            		System.out.println("Student's roll number is " + key_roll);
            		students_hash.put(key_roll, total_so_far + students_arr[i].marks);
            		
            	}
            	else {
            		students_hash.put(key_roll, students_arr[i].marks);
            	}
            }

            // checking if we have each rollnumber with its total marks
            int no_of_students = no_of_entries/3;
            student_desearlized[] output = new student_desearlized[no_of_students];
            
            
            // Creating the array of objects to store each student's roll number and marks
            // as an object of student_desearlized class, in the output array
            int k = 0;
            for (int entries: students_hash.keySet()) {
            	student_desearlized obj = new student_desearlized(entries, students_hash.get(entries));
            	output[k++] = obj;
            }
            

            // Using the output array created above, to finally serialize it again in a 
            // student_final.txt file, which will contain student's roll numbers and marks 
            FileOutputStream outputfile = new FileOutputStream("assignments\\student_final.txt");
            ObjectOutputStream out_stream = new ObjectOutputStream(outputfile);
            
            for(int i= 0 ; i < no_of_students; i++) {
                out_stream.writeObject(output[i]);
            }
            
            out_stream.flush();
            out_stream.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
  }
