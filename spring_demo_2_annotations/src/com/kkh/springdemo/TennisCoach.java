package com.kkh.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    // filed 변수에 자동으로 bean에서 찾아서 inject 해준다
    @Autowired
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
}
