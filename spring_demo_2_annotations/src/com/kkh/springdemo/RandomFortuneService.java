package com.kkh.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create an array of strings
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    // create a random number generator
    private Random random = new Random();

    @Override
    public String getFortune() {
        //pick a random string from the array
        int index = random.nextInt(data.length);
        String theFortune = this.data[index];

        return theFortune;
    }
}
