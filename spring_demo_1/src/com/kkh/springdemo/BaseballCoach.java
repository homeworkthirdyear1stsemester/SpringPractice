package com.kkh.springdemo;

public class BaseballCoach implements Coach {
    // define a private filed for the dependency
    private FortuneService fortuneService;

    // define a constructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "spend 30 minutes on bating practice";
    }

    @Override
    public String getDailyFortune() {
        // use my fortuneService to get a fortune
        return this.fortuneService.getFortune();
    }
}
