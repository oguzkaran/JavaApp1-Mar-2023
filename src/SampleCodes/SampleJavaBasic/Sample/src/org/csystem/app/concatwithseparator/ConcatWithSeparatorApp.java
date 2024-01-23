package org.csystem.app.concatwithseparator;

import org.csystem.collection.string.StringList;

import java.util.Scanner;

public class ConcatWithSeparatorApp {
    private static void doConcat(StringList list, Scanner kb)
    {
        System.out.print("Ayracı giriniz:");
        String separator = kb.nextLine();

        String str = list.concat(separator);

        System.out.println(str);
    }

    private static void fillList(StringList list, Scanner kb)
    {
        while (true) {
            System.out.print("Bir yazı giriniz:");
            String s = kb.nextLine();

            if ("elma".equals(s))
                break;

            list.add(s);
        }
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        StringList list = new StringList();

        fillList(list, kb);
        doConcat(list, kb);
    }

    public static void main(String[] args)
    {
        run();
    }
}
