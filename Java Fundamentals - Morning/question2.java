package assignments;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Comparator;
import java.util.PriorityQueue;

class student_desearlized implements Serializable{
    
	public int rollNumber;
    public int student_marks;
    
    student_desearlized (int rollNumber,int student_marks){
    	this.rollNumber=rollNumber;
    	this.student_marks=student_marks;
    }
}

class StudentComparator implements Comparator<student_desearlized>{ 
    
    public int compare(student_desearlized student1, student_desearlized student2) { 
    	 if(student1.student_marks < student2.student_marks) {
      	   return 1;
         }
         else if (student1.student_marks > student2.student_marks) {
      	   return -1;
         }
         
         return 0;
    }
}

public class question2 { 
    
	public static void main(String[] args) {
	    try
	    {
	   
	    	// Using priority queue for storing the records of students in sorted order
		    PriorityQueue<student_desearlized> pq = new PriorityQueue<student_desearlized>(new StudentComparator());     
		    
		    FileInputStream fin = new FileInputStream("assignments\\\\student_final.txt");
		    ObjectInputStream in = new ObjectInputStream(fin);
		
		    for(int i=0 ; i < 3 ; i++) {
		    	pq.add((student_desearlized) in.readObject());
		    }
	    
		    in.close();
		    fin.close();
		   
		    
		   	// For converting the serialized text file to deserialized csv
		   	StringBuffer strbuf = new StringBuffer();
		   	
		   	// Add the csv table headers for rank, rollnumber and total marks of each student
		    strbuf.append("Rank, Roll Number, Total Marks");
		    FileOutputStream outputfile = new FileOutputStream("assignments\\sorted_student_records.csv");
		    BufferedWriter outputcsv = new BufferedWriter(new OutputStreamWriter(outputfile, "UTF-8"));
		    
		    outputcsv.write(strbuf.toString());
		    outputcsv.newLine();
		    for(int i = 0; i < 3; i++) {
		    	
			   student_desearlized student = pq.poll();
		       strbuf = new StringBuffer();
		       
		       // using i+1 for storing the rank
		       strbuf.append(i+1);
		       
		       // appends comma for the entry in new column
		       strbuf.append(",");
		       
		       strbuf.append(student.rollNumber);
		       
		       
		       strbuf.append(",");
		       strbuf.append(student.student_marks);
		       
		       outputcsv.write(strbuf.toString());
		       
		       // we insert details row by row in each iteration, in the csv file
		       // after inserting the records in the first iteration, we insert a new line, for the records
		       // in next iteration 
		       outputcsv.newLine();
		    }
		    
		    // closing the output csv file
		    outputcsv.flush();
		    outputcsv.close();
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	} 
}