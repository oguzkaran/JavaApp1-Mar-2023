/*----------------------------------------------------------------------------------------------------------------------
    Bir metot içerisinde bildirilen sınıflara yerel sınıflar denir. Yerel sınıflar adında da anlaşılacağı gibi yalnızca
    bildirildikleri blok boyunca görülebilirdirler. Yerel sınıflar pratikte çok fazla kullanılmaz. Yerel sınıflar byte
    kodları oluşturulurken genel olarak şu isimlendirme şablonu kullanılır:
        <kapsayan sınıf ismi>$<yukarıdan aşağıya kaçıncı aynı isimde yerel sınıf olduğu bilgisi><yerel sınıf ismi>
    Aşağıdaki örnekte yerel sınıfların arakodları A$1B.class ve A$2B.class şeklinde üretilecektir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String [] args)
    {
        A a = new A();

        a.tar(20);
    }
}

class B {
    //...
}

class A {
    public void tar(int val)
    {
        class B {
            public static void foo()
            {
                Console.writeLine("B.foo");
            }

            public void bar()
            {
                Console.writeLine("B.bar");
            }
        }

        B.foo();

        B x = new B();

        x.bar();
    }

    public void car(int val)
    {
        class B {
            public static void foo()
            {
                Console.writeLine("B.foo");
            }

            public void bar()
            {
                Console.writeLine("B.bar");
            }
        }

        B.foo();

        B x = new B();

        x.bar();
    }
}


