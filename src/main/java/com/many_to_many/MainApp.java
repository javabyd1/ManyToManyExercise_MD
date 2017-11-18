package com.many_to_many;

import com.many_to_many.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Time;

public class MainApp {

    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();

        order1.setDateTime(Time.valueOf("15:32:00"));
        order2.setDateTime(Time.valueOf("20:00:00"));

        Product product1 = new Product();
        Product product2 = new Product();

        product1.setProductName("Frugo");
        product2.setProductName("Haribo");

        order1.getProducts().add(product1);
        order1.getProducts().add(product2);

        order2.getProducts().add(product2);

        Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();

        session.save(order1);
        session.save(order2);

        session.close();
    }


}
