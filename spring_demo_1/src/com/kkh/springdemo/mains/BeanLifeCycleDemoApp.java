package com.kkh.springdemo.mains;

import com.kkh.springdemo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // context
        System.out.println(theCoach.getDailyWorkout());

        // close the context
        context.close();

        /*
        만약 xml에 bean의 scope를 prototype로 설정 할 경우 init은 호출 되지만 destory는 호출 되지 않는다.
        singleton : init + destory
        prototype : init
         */
    }
}
