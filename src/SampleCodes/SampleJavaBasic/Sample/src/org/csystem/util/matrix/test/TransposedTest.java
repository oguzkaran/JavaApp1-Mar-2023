package org.csystem.util.matrix.test;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.matrix.MatrixUtil;

import java.util.Random;
import java.util.Scanner;

public class TransposedTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Üretilecek matris sayısını giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("---------------------------------");
            int[][] a = MatrixUtil.getRandomMatrix(random, random.nextInt(2, 10), random.nextInt(2, 10), 0, 100);

            ArrayUtil.print(2, a);
            System.out.println();
            ArrayUtil.print(2, MatrixUtil.transposed(a));
            System.out.println("---------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
