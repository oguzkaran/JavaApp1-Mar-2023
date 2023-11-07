/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte HashSet içerisinde tutulan elemanların ekleme sırasıyla olacağının bir garantisi yoktur. Aslında
    HashSet<E> sınıfının elemanları her zaman aynı sırada tutacağının da bir garantisi yoktur. Programcı da bunu bildiği
    için bu veri yapısını ona göre kullanır. Aşağıdaki örneği çalıştırıp sonuçları gözlemleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.HashSet;
import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        var random = new Random();
        var hashSet = new HashSet<Integer>();
        int val;

        while ((val = random.nextInt(-99, 100)) != 0)
            Console.writeLine("%d -> %s", val, hashSet.add(val) ? "Added" : "Duplicate");

        hashSet.forEach(v -> Console.write("%d ", v));

        Console.writeLine();

        for (int v = 60; v < 71; ++v)
            Console.writeLine(hashSet.remove(v) ? "Removed" : "Not in set");

        hashSet.forEach(v -> Console.write("%d ", v));

        Console.writeLine();
    }
}
