// --------------- IMPORTS ---------------------------------

import java.util.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


// ---------------------- CODE -----------------------------------


class Student {
    private int rollNumber;
    private long marks;
    private String subject;

    Student(int rollNumber, long marks, String subject) {
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.subject = subject;
    }
}


class FinalScoreCard implements Serializable{
    int rollNumber;
    long totalMarks;
    FinalScoreCard(int rollNumber, long totalMarks){
        this.rollNumber = rollNumber;
        this.totalMarks = totalMarks;
    }
}


public class StudentSerializer {

    public static void main(String[] args) {
        
        try {

            // INPUT FILE
            File inputXML = new File("student.xml");

            // READING INPUT FILE
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputXML);
            doc.getDocumentElement().normalize();

            System.out.println("Root element is: " + doc.getDocumentElement().getNodeName());

            NodeList allStudentNodes = doc.getElementsByTagName("student");
            
            // For Storing Student Object if needed
            Student studentsArr[] = new Student[allStudentNodes.getLength()];
            
            // For Storing Final Report Card Marks
            HashMap<Integer, Long> studentHmap = new HashMap<>();
            
            
            for (int i = 0; i < allStudentNodes.getLength(); i++) {

                Node nNode = allStudentNodes.item(i);
                Element eElement = (Element) nNode;

                int rollNumber = Integer.parseInt(eElement.getElementsByTagName("roll").item(0).getTextContent());
                long marks = Integer.parseInt(eElement.getElementsByTagName("marks").item(0).getTextContent());
                String subject = (eElement.getElementsByTagName("subject").item(0).getTextContent());

                studentsArr[i] = new Student(rollNumber, marks, subject);

                if(studentHmap.containsKey(rollNumber)){
                    studentHmap.put(rollNumber, studentHmap.get(rollNumber) + marks);
                }
                else{
                    studentHmap.put(rollNumber, marks);
                }
            }

            //  OUTPUT FILE
            FileOutputStream outputFile=new FileOutputStream("student.txt");
            ObjectOutputStream output = new ObjectOutputStream(outputFile);
            
            for (Map.Entry<Integer, Long> entry : studentHmap.entrySet()) {
                output.writeObject(new FinalScoreCard(entry.getKey(), entry.getValue()));
            }
            output.flush();
            output.close();
            System.out.println("Successfully Created Final Report Card as student.txt");
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
