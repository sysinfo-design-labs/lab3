package com.example;

import app.FirstTaskMetrics;

public class Main {
    public static void main(String[] args) {

        double languageLevel = 1.6;
        int[] data = {25, 28, 8, 3};

        FirstTaskMetrics task1 = new FirstTaskMetrics(
                data[0],
                data[1],
                data[2],
                data[3],
                languageLevel
        );

        task1.output();
    }
}