/*----------------------------------------------------------------------------------------------------------------------
    static bir sınıf ismine import static bildirimleri ile de doğrudan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import static org.csystem.app.A.B;

class Application {
    public static void run(String [] args)
    {
        var b = new B();

        b.foo(10);
    }
}

class A {
    private int m_value;
    //...
    public static class B {
        public void foo(int value)
        {
            var x = new A();

            x.m_value = value;

            Console.writeLine("m_value = %d", x.m_value);
        }
    }
}

