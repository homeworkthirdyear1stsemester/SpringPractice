package com.kkh.springdemo.mains;

import com.kkh.springdemo.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationPlaceHolderInjectionDemoApp {

    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        TrackCoach theCoach = context.getBean("trackCoach", TrackCoach.class);
        // default id로 생성

        // get the properties values
        System.out.println(theCoach.getTeamName());
        System.out.println(theCoach.getEmailAddress());

        // close the context
        context.close();
    }
}
