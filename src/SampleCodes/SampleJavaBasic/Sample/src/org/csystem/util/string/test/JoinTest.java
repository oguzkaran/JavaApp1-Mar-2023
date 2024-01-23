package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Scanner;

public class JoinTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Bir sayı giriniz:");
        int n = kb.nextInt();

        String [] str = new String[n];

        for (int i = 0; i < n; ++i)
            str[i] = StringUtil.getRandomTextEN(r, r.nextInt(0, 21));

        System.out.println(StringUtil.join(str, '-'));

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
