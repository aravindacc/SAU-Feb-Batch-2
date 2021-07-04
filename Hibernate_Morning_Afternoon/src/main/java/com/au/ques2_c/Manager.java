package com.au.ques2_c;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Manager {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");

        Laptop laptop2 = new Laptop();
        laptop2.setLid(100);
        laptop2.setLname("HP");

        Student st = new Student();
        st.setMarks(95);
        st.setName("Kishan");
        st.setRollno(3195);
        laptop.setStudent(st);
        laptop2.setStudent(st);

        st.getLaptops().add(laptop);
        st.getLaptops().add(laptop2);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();

        session.beginTransaction();
        session.save(laptop);
        session.save(laptop2);
        session.save(st);
        session.getTransaction().commit();
    }
}
