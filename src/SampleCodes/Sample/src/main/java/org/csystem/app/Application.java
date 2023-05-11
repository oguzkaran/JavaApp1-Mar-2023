/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte kendini çağıran metot bu işlemi sürekli yaptığından StackOverflowError nesnesi fırlatılır. Metodun
    parametre değişkeni ve yerel değişkeni olmadığına dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Application {
    public static void run(String [] args)
    {
        Sample.foo();
    }
}

class Sample {
    public static void foo()
    {
        foo();
    }
}