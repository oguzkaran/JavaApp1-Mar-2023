package org.csystem.util.string.test;

import org.csystem.util.string.StringUtil;

import java.util.Scanner;

public class ReverseTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String str = kb.nextLine();

            if ("elma".equals(str))
                break;

            System.out.printf("Yazının tersi:%s%n", StringUtil.reverse(str));
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }

    public static void main(String[] args)
    {
        run();
    }
}
