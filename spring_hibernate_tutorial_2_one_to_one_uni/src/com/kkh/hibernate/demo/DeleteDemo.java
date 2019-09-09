package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Instructor;
import com.kkh.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
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

            // get instructor by primary key / id
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId); // if not found return null
            System.out.println("Found instructor : " + instructor);

            // delete the instructors
            if (instructor != null) {
                System.out.println("Deleting : " + instructor);

                // Note : Will ALSO delete associated "detail" object
                // because of CascadeType.ALL
                session.delete(instructor);
            }

            // commit transaction 거래 성사
            session.getTransaction().commit();

            System.out.println("Done!!!");
        } finally {
            factory.close();
        }
    }
}
