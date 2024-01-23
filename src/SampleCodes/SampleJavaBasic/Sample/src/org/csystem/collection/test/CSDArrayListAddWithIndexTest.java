package org.csystem.collection.test;

import org.csystem.collection.CSDArrayList;
import org.csystem.util.console.Console;

public class CSDArrayListAddWithIndexTest {
    public static void run()
    {
        CSDArrayList<String> list = new CSDArrayList<>(3);

        while (true) {
            String str = Console.readString("Bir yazı giriniz:");

            if ("elma".equals(str))
                break;

            list.add(0, str);
        }

        Console.writeLine(list);
        Console.writeLine("Size:%d", list.size());
        Console.writeLine("Capacity:%d", list.capacity());
    }
    public static void main(String[] args)
    {
        run();
    }
}
