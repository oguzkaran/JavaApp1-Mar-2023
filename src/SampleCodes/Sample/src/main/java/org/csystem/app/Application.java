/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte "memory leak" oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String [] args)
    {
        var a = new A();
        var n = Console.readInt("Bir sayı giriniz:");

        for (int i = 0; i < n; ++i)
            a.doWork();

        a = new A();

        while (true) //Burası akışın sürekli devam ettiğini yani programın hiç sonlanmadığını göstermektedir
            ;
    }
}

class A {
    private B m_b;

    private class B {
        void doSomething()
        {
            //...
        }
    }

    public void doWork()
    {
        //...
        m_b = new B();

        m_b.doSomething();
    }
}

