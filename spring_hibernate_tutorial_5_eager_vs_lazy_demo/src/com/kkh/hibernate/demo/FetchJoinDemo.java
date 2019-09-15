package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Course;
import com.kkh.hibernate.demo.entity.Instructor;
import com.kkh.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

            // Option 2 : Hibernate query with HQL

            // get the instructor from db
            int theId = 1;
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                    + "JOIN FETCH i.courses "
                                    + "where i.id=:instructorId",
                            Instructor.class);

            // set parameter on query
            query.setParameter("instructorId", theId);

            // execyte query and get instructor
            Instructor instructor = query.getSingleResult();
            // Load instructor and courses all at once

            System.out.println("Instructor : " + instructor);

            // commit transaction 거래 성사
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("\nThe session is now closed!\n");

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
