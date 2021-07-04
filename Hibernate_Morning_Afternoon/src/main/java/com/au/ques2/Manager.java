package com.au.ques2;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Manager {
    public static void main(String[] args) {
        Category category1 = new Category();
        category1.setCategoryId(1);
        category1.setCategoryName("Mobiles");

        Category category2 = new Category();
        category2.setCategoryId(2);
        category2.setCategoryName("Books");

        Category category3 = new Category();
        category3.setCategoryId(3);
        category3.setCategoryName("Laptops");

        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("Iphone X");

        Product product2 = new Product();
        product2.setProductId(2);
        product2.setProductName("One Plus 7");

        Product product3 = new Product();
        product3.setProductId(3);
        product3.setProductName("Macbook");

        Product product4 = new Product();
        product4.setProductId(4);
        product4.setProductName("Psychology of Money");

        Supplier supplier1 = new Supplier();
        supplier1.setSupplierId(1);
        supplier1.setSupplierName("KK");

        Supplier supplier2 = new Supplier();
        supplier2.setSupplierId(2);
        supplier2.setSupplierName("Khan Traders");

        Supplier supplier3 = new Supplier();
        supplier3.setSupplierId(3);
        supplier3.setSupplierName("Bharat Traders");

        category1.getSupplierList().add(supplier1);
        category1.getSupplierList().add(supplier2);
        category1.getSupplierList().add(supplier3);
        category2.getSupplierList().add(supplier1);
        category2.getSupplierList().add(supplier2);
        category2.getSupplierList().add(supplier3);
        category3.getSupplierList().add(supplier1);
        category3.getSupplierList().add(supplier2);
        category3.getSupplierList().add(supplier3);

        category1.setProductObj(product1);
        category1.setProductObj(product1);
        category1.setProductObj(product3);

        product1.getCategoryList().add(category1);
        product1.getCategoryList().add(category2);
        product3.getCategoryList().add(category3);
        product4.getCategoryList().add(category3);

        supplier1.getCategoryList().add(category1);
        supplier1.getCategoryList().add(category2);
        supplier1.getCategoryList().add(category3);
        supplier2.getCategoryList().add(category1);
        supplier2.getCategoryList().add(category2);
        supplier2.getCategoryList().add(category3);
        supplier3.getCategoryList().add(category1);
        supplier3.getCategoryList().add(category2);
        supplier3.getCategoryList().add(category3);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(category1);
        session.save(category2);
        session.save(category3);

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);

        session.save(supplier1);
        session.save(supplier2);
        session.save(supplier3);

        tx.commit();
    }
}
