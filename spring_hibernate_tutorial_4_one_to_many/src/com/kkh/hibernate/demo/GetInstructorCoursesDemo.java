package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Course;
import com.kkh.hibernate.demo.entity.Instructor;
import com.kkh.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction 거래 시작
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("Instructor : " + instructor);

            // get courses for the instructor
            System.out.println("Courses : " + instructor.getCourses());

            // commit transaction 거래 성사
            session.getTransaction().commit();

            System.out.println("Done!!!");
        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
