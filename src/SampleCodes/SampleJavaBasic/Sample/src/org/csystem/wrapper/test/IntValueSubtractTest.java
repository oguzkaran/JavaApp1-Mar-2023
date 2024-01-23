package org.csystem.wrapper.test;

import org.csystem.wrapper.IntValue;

import java.util.Scanner;

public class IntValueSubtractTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Bir sayı giriniz:");
        IntValue count = IntValue.of(kb.nextInt());

        for (IntValue i = count; IntValue.ONE.compareTo(i) <= 0; i = i.subtract(2))
            System.out.printf("%d ", i.intValue());

        System.out.println();
    }

    public static void main(String[] args)
    {
        run();
    }
}
