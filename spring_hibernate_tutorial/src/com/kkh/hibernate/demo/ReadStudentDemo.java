package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new Student object...");
            Student tempStudent = new Student("Daffy", "Duck", "hello@kkh.com");

            // start a transaction 거래 시작
            session.beginTransaction();

            // save the student object
            System.out.println("Saving te student");
            System.out.println();
            session.save(tempStudent);

            // commit transaction 거래 성사
            session.getTransaction().commit();

            System.out.println("Done!!!");
        } finally {
            factory.close();
        }
    }
}
