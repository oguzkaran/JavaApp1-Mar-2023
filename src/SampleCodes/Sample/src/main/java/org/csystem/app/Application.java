/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Eleman sayısını ctor ile alan ve stack dolduğunda RuntimeException sınıfından türetilmiş
    FullStackException fırlatan CSDBoundedStack sınıfını org-csystem-collection kütüphanesi içerisinde yazınız
    ve test edilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Random;
import java.util.Stack;

class Application {
    public static void run(String[] args)
    {
        var stack = new Stack<Integer>();
        var random = new Random();
        int val;

        while ((val = random.nextInt(-99, 100)) != 0)
            Console.write("%d ", stack.push(val));

        Console.writeLine();

        val = random.nextInt(-99, 100);

        Console.writeLine("Size:%d", stack.size());
        Console.writeLine("Value:%d", val);

        var order = stack.search(val);

        if (order != -1)
            Console.writeLine("Order of %d is %d from top", val, order);
        else
            Console.writeLine("%d not found", val);
    }
}
