package com.au.ques2_b.correct_code;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Manager {
    public static void main(String args[]) {
        Session ses = Util.getSession();
        Categories c1 = new Categories();
        c1.setCategoryId(1);
        c1.setCategoryName("cat 1");
        Categories c2 = new Categories();
        c2.setCategoryId(2);
        c2.setCategoryName("cat 2");

        Item i1 = new Item();
        Item i2 = new Item();

        i1.setItemId(101);
        i1.setItemName("item1");

        i2.setItemId(102);
        i2.setItemName("item2");
        Set s = new HashSet();
        s.add(i1);
        s.add(i2);
        c1.setItems(s);
        c2.setItems(s);
        Set itemset = new HashSet();
        itemset.add(c1);
        itemset.add(c2);

        i1.setCategories(itemset);
        i2.setCategories(itemset);

        Transaction tx = ses.beginTransaction();
        ses.save(c1);
        ses.save(c2);
        ses.save(i1);
        ses.save(i2);
        tx.commit();
        System.out.println("Man to Many using annotations been done...!!!!!");
        ses.close();
    }
}
