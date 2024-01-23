package org.csystem.wrapper.test;

import org.csystem.wrapper.IntValue;

import java.util.Scanner;

public class IntValueDecTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Bir sayı giriniz:");
        IntValue count = IntValue.of(kb.nextInt());

        for (IntValue i = count.dec(); IntValue.ZERO.compareTo(i) <= 0; i = i.dec())
            System.out.printf("%d ", i.intValue());

        System.out.println();
    }

    public static void main(String[] args)
    {
        run();
    }
}
