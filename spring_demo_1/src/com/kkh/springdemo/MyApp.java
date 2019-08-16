package com.kkh.springdemo;

public class MyApp {
    public static void main(String[] args) {
        //create the object
        Coach theCoach = new TackCoach();

        //use the object
        System.out.println(theCoach.getDailyWorkout());
    }
}
