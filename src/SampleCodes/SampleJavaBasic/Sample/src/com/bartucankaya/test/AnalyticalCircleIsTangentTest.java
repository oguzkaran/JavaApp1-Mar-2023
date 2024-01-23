package com.bartucankaya.test;

import com.bartucankaya.AnalyticalCircle;
import com.bartucankaya.test.factory.AnalyticalCircleFactory;

import java.util.Random;
import java.util.Scanner;

public class AnalyticalCircleIsTangentTest {
    private static void print(AnalyticalCircle c)
    {
        System.out.println("Daire/çember bilgileri:");

        System.out.printf("Yarıçap:%f%n", c.getRadius());

        System.out.printf("Merkez Noktası:(%f, %f)%n", c.getX(), c.getY());
    }

    private static void doWorkForTest(AnalyticalCircle analyticalCircle, AnalyticalCircle other)
    {
        System.out.printf("Çember merkezleri arası uzaklık: %f%n", analyticalCircle.centerDistance(other));

        System.out.printf("isTangent: %b%n", analyticalCircle.isTangent(other));
    }

    private static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();
        AnalyticalCircleFactory factory = new AnalyticalCircleFactory();

        System.out.print("Bir sayı giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            AnalyticalCircle analyticalCircle = factory.createRandomAnalyticalCircle(50, 100);
            AnalyticalCircle other = new AnalyticalCircle(random.nextDouble(1, 100));
            double sumOfRadius = analyticalCircle.getRadius() + other.getRadius();

            other.set(analyticalCircle.getX() + sumOfRadius, analyticalCircle.getY());
            System.out.println("--------------------------------------------------------------");
            print(analyticalCircle);
            print(other);
            doWorkForTest(analyticalCircle, other);
            other.offset(random.nextDouble(1, 10));
            System.out.println("------------------ 2. Daire/çember ötelendi ------------------");
            doWorkForTest(analyticalCircle, other);
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}


