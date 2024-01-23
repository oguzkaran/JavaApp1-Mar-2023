package com.bartucankaya.test;

import com.bartucankaya.AnalyticalCircle;
import com.bartucankaya.test.factory.AnalyticalCircleFactory;
import org.csystem.math.geometry.Circle;

import java.util.Random;
import java.util.Scanner;

public class AnalyticalCircleConstructorGetterSetterTest {
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
            print(factory.createRandomAnalyticalCircle(50, 100));
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
