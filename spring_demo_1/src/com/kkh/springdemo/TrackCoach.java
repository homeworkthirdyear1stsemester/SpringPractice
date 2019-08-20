package com.kkh.springdemo;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach() {

    }

    public TrackCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do It : " + this.fortuneService.getFortune();
    }

    // add an init method
    public void doMyStartUpStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    // add a destory method
    public void doMyCleanUpStuff() {
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }
}
