package com.kkh.springdemo;

public class SadFortuneService implements FortuneService {


    @Override
    public String getFortune() {
        return "Totday is a sad day";
    }
}
