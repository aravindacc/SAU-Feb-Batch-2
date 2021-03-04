package Q3;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main 
{
public static void main(String[] args) 
{
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Address.class);
    SessionFactory factory=cfg.buildSessionFactory();
    Session session=factory.openSession();
    Transaction transaction = null;
    
try 
{
	transaction = session.beginTransaction();
	Address address = new Address("ORR Road", "Hyderabad", "TS", "500079");
	Student student1 = new Student("sushrutha", address);	
	Student student2 = new Student("vineeth", address);
	session.save(student1);
	session.save(student2);
	transaction.commit();
} 
catch (HibernateException e) 
{
	transaction.rollback();
	e.printStackTrace();
} 
finally 
{
	session.close();
}

}
}