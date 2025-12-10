package org;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SessionFactory factory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student obj = session.get(Student.class,scan.nextInt());
        if (obj != null) {
            session.remove(obj);
            System.out.println("student deleted successfully !");
        } else {
            System.out.println("student not found !");
        }
        transaction.commit();
        session.close();
        factory.close();
    }
}
