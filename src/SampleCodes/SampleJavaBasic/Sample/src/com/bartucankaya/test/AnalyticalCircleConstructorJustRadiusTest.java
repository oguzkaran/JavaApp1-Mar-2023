package com.bartucankaya.test;

import com.bartucankaya.AnalyticalCircle;

import java.util.Random;
import java.util.Scanner;

public class AnalyticalCircleConstructorJustRadiusTest {
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

        System.out.print("Bir sayı giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("--------------------------------------------------------------");
            double radius = random.nextDouble(50, 100);
            print(new AnalyticalCircle(radius));
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
