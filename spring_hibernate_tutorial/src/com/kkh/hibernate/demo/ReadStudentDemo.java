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
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent); // 새로운 id를 할당

            // commit transaction 거래 성사
            session.getTransaction().commit();

            /* MY NEW CODE */

            // find out the student's id : primary key
            System.out.println("Saved student, Generated id : " + tempStudent.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession(); // 새로운 색션 접목 앞의 session 모두 무시
            session.beginTransaction();

            // retrieve student based on the id : primary key
            System.out.println("\nGetting student with id : " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId()); // db 접근해서 데이터 가져오기
            System.out.println("Get complete : " + myStudent); // 없을 경우 null 있을 경우 student obj를 반환

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");
        } finally {
            factory.close();
        }
    }
}
