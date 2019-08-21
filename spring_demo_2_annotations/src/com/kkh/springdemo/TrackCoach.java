package com.kkh.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Value("${foo.email}")
    private String emailAddress;

    @Value("${foo.team}")
    private String teamName;

    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return null;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }
}
