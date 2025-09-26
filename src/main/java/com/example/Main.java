package com.example;

import app.FirstTaskMetrics;
import app.SecondTaskMetrics;
import app.ThirdTaskMetrics;

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
        SecondTaskMetrics task2 = new SecondTaskMetrics(task1);

        int startRating = 2000;
        int programsCount = 3;
        int[] programsSize = {4, 8, 10};
        int[] errorsPerProgram = {1, 2, 4};
        int nextProgramSize = 14;

        ThirdTaskMetrics task3 = new ThirdTaskMetrics(
                startRating,
                languageLevel,
                programsCount,
                programsSize,
                errorsPerProgram,
                nextProgramSize
        );

        task1.output();
        task2.output();
        task3.output();
    }
}