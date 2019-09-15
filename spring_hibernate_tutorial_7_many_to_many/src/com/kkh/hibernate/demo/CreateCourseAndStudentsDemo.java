package com.kkh.hibernate.demo;

import com.kkh.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction 거래 시작
            session.beginTransaction();

            // create a course
            Course course = new Course("Pacman - How To Score One Million Points");

            // save the course
            System.out.println("\nSaving the course...");
            session.save(course);
            System.out.println("Saved the course : " + course);

            // create the Students
            Student student1 = new Student("John", "Doe", "john@kkh.com");
            Student student2 = new Student("Merry", "Public", "merry@kkh.com");

            // add students to the course
            course.addStudent(student1);
            course.addStudent(student2);

            // save students
            System.out.println("\nSaving students ...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students : " + course.getStudents());

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
