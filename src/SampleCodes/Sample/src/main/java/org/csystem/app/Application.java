/*----------------------------------------------------------------------------------------------------------------------
    Anımsanacağı gibi Java'da veri yapılarına "collection" denir. Bu anlamda bir veri yapısını temsil eden sınıfa da
    "collection class" denir. ArrayList<E> bir collection sınıftır. Java'da Map<K, V> arayüzünü implemente eden collection
    sınıflar dışındaki her collection sınıf Iterable<T> arayüzünü implemente eder. Bu collection sınıflar Iterable<T>
    arayüzünü doğrudan implemente etmez. O arayüzden türetilen arayüz ya da arayüzleri implemente eder. Aslında Iterable<T>
    arayüzünden Collection<T> isimli bir arayüz türetilmiştir. Collection<T>, Map<K, V> arayüzünü implemente eden collection
    sınıflar dışındaki tüm collection sınıfların arayüzüdür. Aslında collection sınıflar Collection<T> arayüzden türetilmiş
    çeşitli arayüzler ile sınıflandırılırlar. Collection arayüzünden türetilen önemli arayüzler şunlardır: List<T>, Set<T>,
    Queue<T>, Deque<T>. Bu arayüzleri implemente eden collection sınıflara genel olarak, sırasıyla liste tarzı, küme tarzı,
    kuyruk tarzı ve çift yönlü büyüyen kuyruk tarzı collection sınıflar denilmektedir. Map<K, V> arayüzünü implemente
    eden collection sınıflara ise map tarzo ya da sözlük tarzı collection sınıflar denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.range.IntRange;

class Application {
    public static void run(String[] args)
    {
        var range = IntRange.ofClosed(10, 20);

        range.iterator().forEachRemaining(val -> Console.write("%s ", val));
        Console.writeLine();
    }
}
