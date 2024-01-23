package org.csystem.util.matrix.test;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.matrix.MatrixUtil;

import java.util.Random;
import java.util.Scanner;

public class SumDiagonalTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Üretilecek matris sayısını giriniz:");
        int count = kb.nextInt();

        while (count-- > 0) {
            System.out.println("---------------------------------");
            int[][] a = MatrixUtil.getRandomSquareMatrix(random, random.nextInt(2, 10), 0, 11);

            ArrayUtil.print(2, a);
            System.out.printf("Toplam:%d%n", MatrixUtil.sumDiagonal(a));
            System.out.println("---------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
