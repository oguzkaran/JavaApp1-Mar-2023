package org.csystem.util.array.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.*;

public class SumLongTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Bir sayı giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("--------------------------------------------------------------");
            int [] a = getRandomArray(random, random.nextInt(500, 1000), Integer.MIN_VALUE, Integer.MAX_VALUE);

            print(a);
            System.out.printf("Toplam:%d%n", sumLong(a));
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
