package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Course;
import com.kkh.hibernate.demo.entity.Instructor;
import com.kkh.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {
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
            // fetch가 Eager이기 때문에 모든 것을 이때 가져온다

            System.out.println("Instructor : " + instructor);

            System.out.println("Courses : " + instructor.getCourses());

            // commit transaction 거래 성사
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("\nThe session is now closed!\n");
            // option 1 : call getter method while session is open

            // get courses for the instructor
            System.out.println("Courses : " + instructor.getCourses());

            System.out.println("Done!!!");
        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
