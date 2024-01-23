package org.csystem.util.numeric.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.print;
import static org.csystem.util.numeric.NumberUtil.getDigitsInThrees;

public class GetDigitsInThreesTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Bir sayı giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("--------------------------------------------------------------");
            long val = random.nextLong();
            int [] digits = getDigitsInThrees(val);
            System.out.printf("Value:%d -> ", val);
            print(digits);
            System.out.println("--------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
