package org.csystem.wrapper.test;

import org.csystem.wrapper.IntValue;

import java.util.Random;
import java.util.Scanner;

public class IntValueDivideAndRemainderTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Bir sayı giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            int a = r.nextInt(-128, 127);
            int b = r.nextInt(-128, 127);

            System.out.printf("a = %d, b = %d%n", a, b);
            IntValue aVal = IntValue.of(a);
            IntValue bVal = IntValue.of(b);

            IntValue [] results = aVal.divideAndRemainder(bVal);

            System.out.printf("Bölüm:%d, Kalan:%d%n", results[0].intValue(), results[1].intValue());
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
