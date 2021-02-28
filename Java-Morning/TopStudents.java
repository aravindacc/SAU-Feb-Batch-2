import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopStudents {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Reading data from students.txt");
        System.out.println();
        File file = new File("students.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream obj1 = new ObjectInputStream(fis);
        boolean flag = true;

        System.out.println("Getting Top 5 students using Priority Queue");
        System.out.println();
        PriorityQueue<Student> pq = new PriorityQueue<>(5, new StudentComparator());
        while (flag) {
            try {
                Student stud = (Student) obj1.readObject();
                // System.out.println(stud.rollNo + " " + stud.marks);
                pq.add(stud);
                if (pq.size() > 5) {
                    // System.out.println("Removing Element: " + pq.peek().rollNo + ' ' + pq.peek().marks);
                    pq.poll();
                }
            } catch (EOFException exc) {
                // System.out.println(exc);
                flag = false;
            }
        }

        System.out.println("Writing Top 5 Students to topPerformingStudents.csv");
        System.out.println();
        FileWriter myWriter = new FileWriter("topPerformingStudents.csv");
        myWriter.write("S No, Roll No, Marks\n");
        int i = 1;
        while(!pq.isEmpty()) {
            // System.out.println(pq.peek().rollNo + " " + pq.peek().marks);
            myWriter.write(String.valueOf(i) + "," + String.valueOf(pq.peek().rollNo) + "," + String.valueOf(pq.peek().marks) + "\n");
            pq.poll();
        }
        myWriter.close();
        System.out.println("Succesfully written Top 5 Students Data to topPerformingStudents.csv");
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.marks, s2.marks);
    }
}
