package org.csystem.collection.test;

import org.csystem.collection.CSDArrayList;
import org.csystem.util.console.Console;

public class CSDArrayListRemoveTest {
    public static void run()
    {
        CSDArrayList<String> list = new CSDArrayList<>(3);

        while (true) {
            String str = Console.readString("Bir yazı giriniz:");

            if ("elma".equals(str))
                break;

            list.add(str);
        }

        Console.writeLine(list);

        try {
            String old = list.remove(3);

            Console.writeLine("Silinen eleman:%s", old);
        }
        catch (IndexOutOfBoundsException ex) {
            Console.writeLine(ex.getMessage());
        }

        Console.writeLine(list);
    }
    public static void main(String[] args)
    {
        run();
    }
}
