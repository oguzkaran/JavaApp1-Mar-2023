package org.csystem.collection.test;

import org.csystem.collection.CSDArrayList;
import org.csystem.util.console.Console;

public class CSDArrayListConstructorTest {
    public static void run()
    {
        CSDArrayList<String> list = new CSDArrayList<>(11);

        Console.writeLine("Size:%d", list.size());
        Console.writeLine("Capacity:%d", list.capacity());
    }
    public static void main(String[] args)
    {
        run();
    }
}
