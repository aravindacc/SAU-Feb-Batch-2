package com.au.ques1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    public static Session getSession() {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        SessionFactory factory = conf.buildSessionFactory();
        return factory.openSession();
    }
}