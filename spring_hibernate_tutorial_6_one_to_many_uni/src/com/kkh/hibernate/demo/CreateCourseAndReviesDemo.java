package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.Course;
import com.kkh.hibernate.demo.entity.Instructor;
import com.kkh.hibernate.demo.entity.InstructorDetail;
import com.kkh.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviesDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction 거래 시작
            session.beginTransaction();

            // create a course
            Course course = new Course("Pacman - How To Score One Million Points");

            // add some reviews
            course.addReview(new Review("Greate course ... loved it"));
            course.addReview(new Review("Cool course, job well done"));
            course.addReview(new Review("nice thing for me!"));

            // save the course ... and leverage the cascade all
            System.out.println("Savint course");
            System.out.println(course);
            System.out.println(course.getReviews());

            session.save(course);

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
