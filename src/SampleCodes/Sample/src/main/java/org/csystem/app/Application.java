/*----------------------------------------------------------------------------------------------------------------------
    
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String [] args)
    {
        var a = Console.readInt("Birinci sayıyı giriniz:");
        var b = Console.readInt("İkinci sayıyı giriniz:");
        var c = Console.readInt("Üçüncü sayıyı giriniz:");

        IntValue iVal = new IntValue(a) {
            public int addWith()
            {
                return val + b + c;
            }
        };

        Console.writeLine(iVal.getClass().getName());
        Util.printSum(iVal);
        Util.printSum(new IntValue(a) {
            public int addWith()
            {
                return val + b;
            }
        });

        Console.writeLine("---------------------------------------");
        var myValue1 = new MyValue1(a, b, c);
        var myValue2 = new MyValue2(a, b);

        Util.printSum(myValue1);
        Util.printSum(myValue2);
    }
}

class MyValue1 extends IntValue {
    private final int m_b, m_c;

    public MyValue1(int a, int b, int c)
    {
        super(a);
        m_b = b;
        m_c = c;
    }

    public int addWith()
    {
        return val + m_b + m_c;
    }
}

class MyValue2 extends IntValue {
    private final int m_b;
    public MyValue2(int a, int b)
    {
        super(a);
        m_b = b;
    }
    public int addWith()
    {
        return val + m_b;
    }
}

class Util {
    public static void printSum(IntValue iVal)
    {
        Console.writeLine(iVal.addWith());
    }
}

abstract class IntValue {
    protected int val;

    protected IntValue(int val)
    {
        this.val = val;
    }

    public abstract int addWith();
}