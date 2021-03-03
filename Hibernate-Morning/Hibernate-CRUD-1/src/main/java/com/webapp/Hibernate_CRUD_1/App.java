package com.webapp.Hibernate_CRUD_1;

//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
///**
// * Hello world!
// *
// */
//public class App 
//{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//        
//        Configuration cfg = new Configuration();
//        cfg.configure();
//        SessionFactory factory = cfg.buildSessionFactory();
//        
////        System.out.println(factory);
////        System.out.println(factory.isClosed());
//        
//        Employee emp = new Employee();
//        
//        
//    }
//}

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webapp.Hibernate_CRUD_1.Employee;
/**
 * Hello world!
 *
 */
public class App 
{
	public static Scanner s=new Scanner(System.in);
	
	private static <Employee> List<Employee> getallemployees(Class<Employee> type, Session session) 
	{
        CriteriaBuilder criteriabuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = criteriabuilder.createQuery(type);
        criteria.from(type);
        List<Employee> allemployees = session.createQuery(criteria).getResultList();
        return allemployees;
    }
	
	public static void EmployeeDetails(Employee emp) 
	{
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Id: "+emp.getId());
		System.out.println("FullName: "+emp.getFname()+" "+emp.getLaname());
		System.out.println("Age: "+emp.getAge());
		System.out.println("Salary: "+emp.getSalary());
		System.out.println("Date of birth: "+emp.getDOB());
		System.out.println("Designation: "+emp.getDesignation());
		System.out.println("--------------------------------------------------------------------------------------");
	}
	public static void setEmployeeDetails(Employee emp) 
	{
		emp.setFname(s.next());
		emp.setLaname(s.next());
		emp.setAge(Integer.parseInt(s.next()));
		emp.setSalary(Integer.parseInt(s.next()));
		emp.setDOB(s.next());
		emp.setDesignation(s.next());
	}
    public static void main( String[] args )
    {
        System.out.println( "Employee Management System" );
        Session session=SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		int n = 1;
		while(n == 1) 
		{
			System.out.println("Select a choice");
			System.out.println("1. Create employee");
			System.out.println("2. Update all employee details");
			System.out.println("3. Update employee by id");
			System.out.println("4. Delete employee - warning: this cannot be recovered");
			System.out.println("5. Get all employee details");
			System.out.println("6. Get Employee by id");
			System.out.println("7. exit");
			
			System.out.println("Enter your choice: ");
			int ch=Integer.parseInt(s.next());
			switch(ch)
			{
			case 1:
				System.out.println("Enter employee all details in order firstname, lastname, age, salary, date of birth, designation");
				Employee emp = new Employee();
				setEmployeeDetails(emp);
				session.save(emp);
				tx.commit();
				break;
				
			case 2:
				System.out.println("Enter the id");
				int idd = s.nextInt();

				System.out.println("Enter new name");
				String fname1 = s.next();
				String str = String.format("Update Employee SET fname ='%s' where id ='%d';", fname1, idd);
				try {
					session.createSQLQuery(str).executeUpdate();
					System.out.println("Employee ID successfully updated !");
					tx.commit();
				} 
				catch (Exception e) 
				{
					System.out.println("Enter the correct Employee ID");
				}
				System.out.println("Updation Done!");
				tx.commit();
				break;
				
			case 3:
				System.out.println("Enter employee id to update the record");
				int id=Integer.parseInt(s.next());
				Employee e = session.load(Employee.class, id);
				System.out.println("Enter employee details in the order firstname, lastname, age, salary, dob, designation");
				setEmployeeDetails(e);
				session.update(e);
				tx.commit();
				break;
		
			case 4:
				System.out.println("Enter employee id to delete a record permanently");
				int id1=s.nextInt();
				Employee e1 = session.load(Employee.class, id1);
				String temp="y";
				System.out.println("warning: this cannot be recovered..");
				System.out.println("Do you want to continue? y/n ");
				temp=s.next();
				if(temp.toLowerCase().equals("y"))
					{
					session.delete(e1);
					System.out.println("Employee details deleted successfully");
					}
				//tx.commit();
				break;
			
			case 5:
				 List<Employee> allemp = getallemployees(Employee.class, session);
                 System.out.println("All Records of Employee Table");
                 System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                 
                 System.out.println("\nEmployee ID           First Name             Last Name             Age             Salary             Date Of Birth             Designation");
                 System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                 for (int i = 0; i < allemp.size(); i++) 
                 {
                     Employee employee = (Employee) allemp.get(i);
                     System.out.println(employee.getId() + "                      " + employee.getFname() + "                " + employee.getLaname()  + "                " + employee.getAge() + "                " + employee.getSalary() + "                " + employee.getDOB() + "                " + employee.getDesignation());
                 }
                 System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                // tx.commit();
                 break;
                
			case 6:
				System.out.println("Enter employee id to display the record");
				int id2=s.nextInt();
				Employee e2=session.load(Employee.class, id2);
				EmployeeDetails(e2);
				//tx.commit();
				break;
				
			case 7:
				n=0;
				//System.exit(0);
				break;
				
			default:
				System.out.println("Enter correct choice");
				break;
		}
		
	}
		System.exit(0);
	
		//session.close();
    }
}
