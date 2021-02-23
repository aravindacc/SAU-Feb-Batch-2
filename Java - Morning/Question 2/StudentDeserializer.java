import java.util.*;
import java.io.*;

class FinalScoreCard implements Serializable {
    int rollNumber;
    long totalMarks;

    FinalScoreCard(int rollNumber, long totalMarks) {
        this.rollNumber = rollNumber;
        this.totalMarks = totalMarks;
    }
}

public class StudentDeserializer {

    private static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        try {
            List<FinalScoreCard> studentArr = new ArrayList<>();

            // DESERIALIZATION
            FileInputStream inputFile = new FileInputStream("student.txt");
            ObjectInputStream studentsInput = new ObjectInputStream(inputFile);

            try {
                while (true) {
                    studentArr.add((FinalScoreCard) studentsInput.readObject());
                    // System.out.println(studentArr.get(studentArr.size() - 1).totalMarks);
                }
            } catch (EOFException e) {
                //
            }

            // Closing File and Input Stream
            studentsInput.close();
            inputFile.close();

            // Sorting In Descending Order
            Collections.sort(studentArr, new Comparator<FinalScoreCard>() {
                @Override
                public int compare(FinalScoreCard obj1, FinalScoreCard obj2) {
                    return obj1.totalMarks > obj2.totalMarks ? -1 : obj1.totalMarks > obj2.totalMarks ? 1 : 0;
                }
            });

            // TOP STUDENTS OUTPUT FILE
            BufferedWriter br = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream("students_ranking.csv"), "UTF-8"));
            StringBuffer oneLine = new StringBuffer();
            oneLine.append("Rank, Roll Number, Total Marks(out of 300)");
            br.write(oneLine.toString());
            br.newLine();

            for (int i = 0; i < studentArr.size(); i++) {
                oneLine = new StringBuffer();
                oneLine.append(i + 1);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(studentArr.get(i).rollNumber);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(studentArr.get(i).totalMarks);
                br.write(oneLine.toString());
                br.newLine();
            }
            br.flush();
            System.out.println("Successfully Created Top Students Ranking CSV");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}