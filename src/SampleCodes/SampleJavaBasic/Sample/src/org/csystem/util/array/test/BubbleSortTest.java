package org.csystem.util.array.test;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.array.ArrayUtil.*;

public class BubbleSortTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        for (;;) {
            System.out.print("Dizinin eleman sayısını giriniz:");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            int [] a = ArrayUtil.getRandomArray(random, n, 0, 100);

            ArrayUtil.print(2, a);

            boolean desc = random.nextBoolean();

            ArrayUtil.bubbleSort(a, desc);

            System.out.printf("%s sıralanmış dizi:%n", desc ? "Büyükten küçüğe" : "Küçükten büyüğe");
            ArrayUtil.print(2, a);
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
