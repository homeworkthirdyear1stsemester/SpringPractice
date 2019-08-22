package com.kkh.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype") // create new instance everytime
public class TennisCoach implements Coach {

    // filed 변수에 자동으로 bean에서 찾아서 inject 해준다
    @Autowired
    @Qualifier("randomFortuneService") // bean id 에 맞는 해당 객체에 injection이 일어난다
    private FortuneService fortuneService;

    // define  a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach : inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    @PostConstruct
    public void doSomethingAfterConstructor() {
        System.out.println("do something after constructor!!!");
    }

    @PreDestroy
    public void doSomethingBeforeDestory() {
        System.out.println("do something before destory!!!");
    }
}
