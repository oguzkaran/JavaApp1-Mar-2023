package com.bartucankaya.test;


import com.bartucankaya.AnalyticalCircle;
import com.bartucankaya.test.factory.AnalyticalCircleFactory;

import java.util.Scanner;

import static java.lang.Math.*;

public class AnalyticalCircleCenterDistanceTest {
    private static final double DELTA = 0.00001;
    private static void print(AnalyticalCircle c)
    {
        System.out.println("Daire/çember bilgileri:");
        System.out.printf("Merkez Noktası:(%f, %f)%n", c.getX(), c.getY());
    }

    private static boolean areDistanceEquals(AnalyticalCircle c1, AnalyticalCircle c2)
    {
        double distance = sqrt(pow(c1.getX() - c2.getX(), 2) + pow(c1.getY() - c2.getY(), 2));

        System.out.printf("%f%n", distance);
        System.out.printf("Çember merkezleri arası uzaklık: %f%n", c1.centerDistance(c2));

        return abs(distance - c1.centerDistance(c2)) < DELTA;
    }

    private static void run()
    {
        Scanner kb = new Scanner(System.in);
        AnalyticalCircleFactory factory = new AnalyticalCircleFactory();

        System.out.print("Bir sayı giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("--------------------------------------------------------------");
            AnalyticalCircle analyticalCircle = factory.createRandomAnalyticalCircle(100, 200);
            AnalyticalCircle other = factory.createRandomAnalyticalCircle(100, 200);

            print(analyticalCircle);
            print(other);
            System.out.println(areDistanceEquals(analyticalCircle, other) ? "Test Passed" : "Test Failed");
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}