package com.many_to_many.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory sessionFactory;

    private final static SessionFactory sf = new Configuration()
            .configure()
            .buildSessionFactory();

    private static Session session = sf.openSession();

    private HibernateUtil() {
    }

    public static Session getHibernateSession() {
        if(session == null) {
            session = (Session) new HibernateUtil();
        }
        return session;
    }
}
