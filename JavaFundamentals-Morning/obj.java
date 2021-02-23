import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.HashMap;
import java.util.*;
import java.io.Serializable;
import java.io.FileWriter;
import java.io.IOException;

class student {
    int roll_number;
    int total_marks;
    String subj;

    student(int roll_number, int total_marks, String subj) {
        this.roll_number = roll_number;
        this.total_marks = total_marks;
        this.subj = subj;
    }
}

public class obj implements Serializable {

    static class check implements Serializable {
        int roll_number, total_marks;

        check(int roll_number, int total_marks) {
            this.roll_number = roll_number;
            this.total_marks = total_marks;
        }
    }

    public static void main(String args[]) {
        try {

            File file = new File("/Users/sai14/OneDrive/Desktop/java1/info.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();

            ArrayList<student> al = new ArrayList<>();
            obj o = new obj();

            NodeList nodeList = doc.getElementsByTagName("student");
            student[] list = new student[nodeList.getLength()];

            for (int itr = 0; itr < nodeList.getLength(); itr++) {

                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) node;

                    int roll = Integer.parseInt(eElement.getElementsByTagName("roll").item(0).getTextContent());
                    int marks = Integer.parseInt(eElement.getElementsByTagName("marks").item(0).getTextContent());
                    String subj = eElement.getElementsByTagName("subject").item(0).getTextContent();
                    list[itr] = new student(roll, marks, subj);

                }
            }

            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                if (hm.containsKey(list[itr].roll_number)) {
                    hm.put(list[itr].roll_number, hm.get(list[itr].roll_number) + list[itr].total_marks);
                } else {
                    hm.put(list[itr].roll_number, list[itr].total_marks);
                }

            }

            FileWriter myWriter = new FileWriter("student.txt");
            for (int i = 0; i < hm.size(); i++) {
                myWriter.write("Roll_Number: ");
                myWriter.write(Integer.toString(list[i].roll_number) + "\t");
                myWriter.write("Total_Marks: ");
                myWriter.write(Integer.toString(hm.get(list[i].roll_number)) + "\n");

            }

            myWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
