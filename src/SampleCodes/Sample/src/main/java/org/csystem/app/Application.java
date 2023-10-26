/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: FIFO kuyruğu temsil CSDQueue<E> sınıfını org-csystem-collection kütüphanesinde sınıfın public
    bölümünü değiştirmeden yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.LinkedList;
import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        var random = new Random();
        var deq = new LinkedList<Integer>();
        int val;

        while ((val = random.nextInt(-99, 100)) != 0) {
            Console.write("%d ", val);

            if (NumberUtil.isPrime(val))
                deq.offerFirst(val);
            else
                deq.offerLast(val);
        }

        Console.writeLine();

        deq.forEach(a -> Console.write("%d ", a));

        Console.writeLine();
    }
}

