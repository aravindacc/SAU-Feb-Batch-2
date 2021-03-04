package Q2;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Resolver {
    public static void main(String args[]) 
    {
    	
    	Configuration cfg=new Configuration().configure().addAnnotatedClass(employee.class).addAnnotatedClass(empid.class);
	    SessionFactory factory=cfg.buildSessionFactory();
	    Session s=factory.openSession();

        employee e1 = new employee();
        e1.setEmployeeId(1);
        e1.setEmployeeName("ramya");

        employee e2 = new employee();
        e2.setEmployeeId(2);
        e2.setEmployeeName("suresh");


        empid i1 = new empid();
        empid i2 = new empid();

        i1.setEmpId(1);
        i1.setEmpName("id1");

        i2.setEmpId(2);
        i2.setEmpName("id2");

        Set set = new HashSet();
        set.add(i1);
        set.add(i2);

        e1.setIds(set);
        e2.setIds(set);

        Transaction tx = s.beginTransaction();
        s.save(e1);
        s.save(e2);
        tx.commit();
        System.out.println("Many to Many problem has been resolved now...");
        s.close();
    }
}