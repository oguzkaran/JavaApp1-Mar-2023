package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class DrawHistogramTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        for (;;) {
            System.out.print("Bir sayı giriniz:");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            int [] a = ArrayUtil.getRandomArray(random, n, 0, 11);

            ArrayUtil.print(a);

            int [] data = ArrayUtil.getHistogramData(a, 10);

            ArrayUtil.print(data);

            System.out.println("Histogram:");
            ArrayUtil.drawHistogram(data, 10, 'X');
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
