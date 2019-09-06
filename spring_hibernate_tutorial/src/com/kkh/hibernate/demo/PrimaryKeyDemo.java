package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create 3 student objects
            System.out.println("Creating 3 student objects...");
            Student tempStudent1 = new Student("kh", "Kim", "hello@kkh.com");
            Student tempStudent2 = new Student("John", "Doe", "john@kkh.com");
            Student tempStudent3 = new Student("Marry", "Public", "marry@kkh.com");

            // start a transaction 거래 시작
            session.beginTransaction();

            // save the student object
            System.out.println("Saving te students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction 거래 성사
            session.getTransaction().commit();

            System.out.println("Done!!!");
        } finally {
            factory.close();
        }
    }
}
