package com.kkh.springdemo;

import org.springframework.stereotype.Component;

@Component("sillyCoach")
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
