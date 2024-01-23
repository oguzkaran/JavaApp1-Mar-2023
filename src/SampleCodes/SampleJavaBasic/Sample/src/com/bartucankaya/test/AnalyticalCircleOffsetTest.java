package com.bartucankaya.test;

import com.bartucankaya.AnalyticalCircle;
import com.bartucankaya.test.factory.AnalyticalCircleFactory;

import java.util.Random;
import java.util.Scanner;

public class AnalyticalCircleOffsetTest {
    private static void print(AnalyticalCircle c)
    {
        System.out.println("Daire/çember bilgileri:");
        System.out.printf("Yarıçap:%f%n", c.getRadius());
        System.out.printf("Alan:%f%n", c.getArea());
        System.out.printf("Çevre:%f%n", c.getCircumference());
        System.out.printf("Merkez Noktası:(%f, %f)%n", c.getX(), c.getY());
    }
    private static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();
        AnalyticalCircleFactory factory = new AnalyticalCircleFactory();

        System.out.print("Bir sayı giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("--------------------------------------------------------------");
            AnalyticalCircle analyticalCircle = factory.createRandomAnalyticalCircle(50, 100);
            double dx = random.nextDouble(-100, 100);
            double dy = random.nextDouble(-100, 100);

            print(analyticalCircle);
            System.out.printf("dx = %f, dy = %f%n", dx, dy);
            analyticalCircle.offset(dx, dy);
            print(analyticalCircle);
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
