import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

import org.w3c.dom.Node;

import org.w3c.dom.Element;

import java.util.*;

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

public class CSV {

    private static final String CSV_SEPARATOR = ",";

    static class check implements Serializable {
        int roll_number, total_marks;

        check(int roll_number, int total_marks) {
            this.roll_number = roll_number;
            this.total_marks = total_marks;
        }
    }

    public static void main(String args[]) {

        ArrayList<student> a = new ArrayList<>();
        try {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream("toppers.csv"), "UTF-8"));
            File inputFile = new File("info.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            CSV o = new CSV();

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

            check[] arr = new check[nodeList.getLength() / 3];
            int i = 0;
            for (int key : hm.keySet()) {
                arr[i++] = new check(key, hm.get(key));
            }

            FileOutputStream fout = new FileOutputStream("student.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (i = 0; i < nodeList.getLength() / 3; i++) {
                out.writeObject(arr[i]);

            }

            out.flush();
            out.close();

            FileInputStream fin = new FileInputStream("student.txt");
            ObjectInputStream in = new ObjectInputStream(fin);

            for (i = 0; i < nodeList.getLength() / 3; i++) {
                arr[i] = (check) in.readObject();

            }
            in.close();
            in.close();

            Arrays.sort(arr, new Comparator<check>() {
                @Override
                public int compare(check o1, check o2) {
                    if (o1.total_marks > o2.total_marks)
                        return 1;
                    else if (o1.total_marks < o2.total_marks)
                        return -1;
                    return 0;
                }
            });

            StringBuffer oneLine = new StringBuffer();
            oneLine.append("Rank,Roll Number,Total Marks(out of 300)");
            bw.write(oneLine.toString());
            bw.newLine();
            for (int j = 0; j < nodeList.getLength() / 3; j++) {
                oneLine = new StringBuffer();
                oneLine.append(j + 1);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(arr[j].roll_number);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(arr[j].total_marks);
                System.out.println(oneLine.toString());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}