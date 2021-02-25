import java.io.*;
import java.util.*;
class SingleThread
{
    public static void main(String[] args) 
       {  
            String s1 ="Accolite is an innovative, design thinking software company that guarantees seamless digital experiences with maximum results. Backed by the best technical minds in the industry, and only the best cutting edge technology, we strive to help our clients overcome their digital challenges and achieve their goals." +
            "Accolite employees hail from top schools globally and/or have worked at world class organizations. Every Accolite employee has cleared through a very tough interviewing and recruiting process." +
            "Typically 3 in every 100 applicants clear our interview bar and we take pride in hiring Only the Best." + 
            "An opportunity to work with some of the best minds is the biggest perk at Accolite in addition to some of the most challenging and exciting projects." +
            "In addition, Accolite provides you ample opportunities to learn new technologies across various domains." +
            "We not only identify and harnesses your potential, but also rewards and recognize your talent and performance with industry leading pay scales, benefits, learning opportunities and above all a lot of fun."+
            "Accolite offers a wide range of benefits well beyond the competitive salaries we offer."+
            "Benefits vary from office to office."+
            "Accolite offers a wide range of benefits well beyond the competitive salaries we offer."+
            "Benefits vary from office to office."+
            " No matter where they’re based or what their role is, everyone at Accolite is a valued member of a global team that works together to provide best IT services."+
            "Our US office benefits include health care plans that include an option to opt for Medical, Dental, Vision coverages as well as an employee assistance program."+
            "Associates also have an option to a health savings account which requires enrollment into a high deductible health plan."+
            "In addition, associates can also utilize 401K pre-tax plan or 401K Roth post-tax plan and free financial investment assistance services administered through a third party."+
            "Our India office benefits include an employee bonus scheme based on performance, health care assistance and ample opportunities for professional development.";  
            
            //create a thread and pass the string
            Thread thread1 = new Thread(new WordCountSingleThread(s1));
            thread1.start();
        }
}  
class WordCountSingleThread implements Runnable 
{  
    String string1;
    //constructor
    public WordCountSingleThread(String s1)
    {
        this.string1=s1;
    }
    public void run()
	{
		int count=0;  
        char ch[]= new char[string1.length()];     
        for(int i=0;i<string1.length();i++)  
        {
            ch[i]= string1.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                count++; 
        }
        System.out.println(count +"words."); 
    } 
}  