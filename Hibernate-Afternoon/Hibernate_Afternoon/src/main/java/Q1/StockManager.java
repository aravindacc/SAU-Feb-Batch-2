package Q1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class StockManager {
 
    public static void main(String[] args) 
    {
		Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class).addAnnotatedClass(Supplier.class);
	    SessionFactory sf=con.buildSessionFactory();
	    Session ps=sf.openSession();
		Transaction tx1=ps.beginTransaction();
		
		Product pro1=new Product();
		pro1.setPname("One Plus 7 pro");
		pro1.setPrice(45000);
		ps.save(pro1);
		
		Product pro2=new Product();
		pro2.setPname("Refrigerator");
		pro2.setPrice(20000);
		ps.save(pro2);
		
		Product pro3=new Product();
		pro3.setPname("laptop");
		pro3.setPrice(70000);
		ps.save(pro3);
		
		Product pro4=new Product();
		pro4.setPname("clock");
		pro4.setPrice(1000);
		ps.save(pro4);
		
		Product pro5=new Product();
		pro5.setPname("hair dryer");
		pro5.setPrice(2000);
		ps.save(pro5);
		
		Product pro6=new Product();
		pro6.setPname("Table");
		pro6.setPrice(3589);
		ps.save(pro6);
		
		tx1.commit();
		ps.close();
		
		Configuration con1=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class).addAnnotatedClass(Supplier.class);
	    SessionFactory sf1=con1.buildSessionFactory();
	    Session cs=sf1.openSession();
		Transaction tx;
		tx=cs.beginTransaction();
		
		Category c=new Category();
		c.setCname("Item1");
		c.getProducts().add(pro1);
		c.getProducts().add(pro2);
		c.getProducts().add(pro5);
		c.getProducts().add(pro6);
		cs.save(c);
		
		
		Category cat2=new Category();
		cat2.setCname("Item2");
		cs.save(cat2);
		cat2.getProducts().add(pro3);
		cat2.getProducts().add(pro4);
		tx.commit();
		
		cs.close();
		
		Configuration con2=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class).addAnnotatedClass(Supplier.class);
	    SessionFactory sf2=con2.buildSessionFactory();
	    Session ss=sf2.openSession();
		Transaction tx2;
		tx2=ss.beginTransaction();
		Supplier sup1=new Supplier();
		sup1.setSname("ItemList1");
		sup1.getCategories().add(c);
		ss.save(sup1);
		Supplier sup2=new Supplier();
		sup2.setSname("ItemList2");
		sup2.getCategories().add(cat2);
		ss.save(sup2);
		Supplier sup3=new Supplier();
		sup3.setSname("ItemList3");
		sup3.getCategories().add(c);
		ss.save(sup3);
		
		
		
		tx2.commit();
    }
}