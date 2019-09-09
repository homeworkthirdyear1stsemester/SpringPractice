package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Instructor;
import com.kkh.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {
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
            // start a transaction 거래 시작
            session.beginTransaction();

            // get the instructor detail object
            int theId = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            // print the instructor detail
            System.out.println("instructorDetail : " + instructorDetail);

            // print the associated instructor
            System.out.println("the associated instructor : " + instructorDetail.getInstructor());

            // now let's delete the instruction detail
            System.out.println("Deleting instructionDetail : " + instructorDetail);
            session.delete(instructorDetail);

            // commit transaction 거래 성사
            session.getTransaction().commit();

            System.out.println("Done!!!");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            // handle connect leak issue
            session.close();
            factory.close();
        }
    }
}
