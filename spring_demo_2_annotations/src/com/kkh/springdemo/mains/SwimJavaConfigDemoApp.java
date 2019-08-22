package com.kkh.springdemo.mains;

import com.kkh.springdemo.Coach;
import com.kkh.springdemo.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring config java class no more xml file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        Coach theCoach = context.getBean("swimCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
