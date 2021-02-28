## Java Morning Assignment

**Name:** Kunal Sharma

**Email:** kunalsharma6914@gmail.com

#### Read an XML file “”student.xml” containing list of student data in the following format, deserialize them into java objects, then serialize the unique <rollnumber, total marks(Phy+chem+math)> to a text file “student.txt” with appropriate exception handling.

##### Solution - Parser.java

##### Output

```
Reading XML File

Student 1 details:
Roll No: 12
Marks: 85

Student 2 details:
Roll No: 13
Marks: 60

Student 3 details:
Roll No: 15
Marks: 79

Student 4 details:
Roll No: 13
Marks: 85

Student 5 details:
Roll No: 15
Marks: 60

Student 6 details:
Roll No: 12
Marks: 79

Student 7 details:
Roll No: 13
Marks: 85

Student 8 details:
Roll No: 15
Marks: 60

Student 9 details:
Roll No: 12
Marks: 79

Serializing Student<rollNo, marks> to File students.txt

Successfully Serialized Data to students.txt

Process finished with exit code 0
```

### 2. Secondly, deserialize the previously stored student.txt file with roll num and total marks. Then, serialize the top 5 students' roll numbers and total marks into excel or csv file in the following format.

#### Solution - TopStudents.java

#### OUTPUT

```
Reading data from students.txt

Getting Top 5 students using Priority Queue

Writing Top 5 Students to topPerformingStudents.csv

Succesfully written Top 5 Students Data to topPerformingStudents.csv
```

#### CSV File

```
topPerformingStudents.csv
```

![Top Students](https://github.com/sharma-kunal/SAU-Feb-Batch-2/blob/main/Java-Morning/img/topStudents.png)

### 3. Implementation for Singleton Class

#### Solution - Singleton.java
