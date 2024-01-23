package org.csystem.wrapper.test;

import org.csystem.wrapper.IntValue;

public class IntValueCacheTest {
    public static void run()
    {
        IntValue iVal1 = IntValue.of(100);
        IntValue iVal2 = IntValue.of(100);
        IntValue iVal3 = IntValue.of(-129);
        IntValue iVal4 = IntValue.of(-129);

        System.out.println(iVal1 == iVal2 ? "Aynı nesne" : "Farklı nesneler");
        System.out.println(iVal3 == iVal4 ? "Aynı nesne" : "Farklı nesneler");
    }

    public static void main(String[] args)
    {
        run();
    }
}
