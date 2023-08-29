/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Singleton sınıfı enum class olarak bildirilmiştir. enum class türünden bir nesne reflection
    yöntemi ile bile programcı tarafından yaratılamaz. Örnek durumu göstermek için yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.lang.reflect.InvocationTargetException;

class Application {
    public static void run(String [] args)
    {
        try {
            var cls = Singleton.class;
            var count = Console.readInt("Input count:");
            var s = Singleton.INSTANCE;

            for (var i = 0; i < count; ++i) {
                var ctor = cls.getDeclaredConstructor();

                ctor.setAccessible(true);
                var k = ctor.newInstance();
                ctor.setAccessible(false);

                Console.writeLine(s == k ? "Aynı nesne" : "Farklı nesneler");
            }
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            Console.Error.writeLine(ex.getMessage());
        }
    }
}

enum Singleton {
    INSTANCE;
    private int m_val;

    public int getVal()
    {
        return m_val;
    }

    public void setVal(int val)
    {
        m_val = val;
    }
}