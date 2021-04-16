package com.learning.hermes.utils;

import java.util.Random;

public class TtnGenerator {

    public static String generate() {
        Random rand = new Random();
        String ttn;
        ttn = ("TTN" + Integer.toString(rand.nextInt(1001)) + Integer.toString(rand.nextInt(1001))
                + Integer.toString(rand.nextInt(1001)) + Integer.toString(rand.nextInt(1001)));
        return ttn;
    }
}
