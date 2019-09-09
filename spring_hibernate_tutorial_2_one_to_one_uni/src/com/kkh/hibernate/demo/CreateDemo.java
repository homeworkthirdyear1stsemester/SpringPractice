package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Instructor;
import com.kkh.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // create the objects
            Instructor instructor = new Instructor("kh", "kim", "hello@kkh.com");

            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.kkh.com/youtube",
                    "hello for code"
            );

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction 거래 시작
            session.beginTransaction();

            /*
             save the instructor
             Note : this will ALSO save the details object
             because CascadeType.ALL
             */
            System.out.println("Saving instructor : " + instructor);
            session.save(instructor);

            // commit transaction 거래 성사
            session.getTransaction().commit();

            System.out.println("Done!!!");
        } finally {
            factory.close();
        }
    }
}
