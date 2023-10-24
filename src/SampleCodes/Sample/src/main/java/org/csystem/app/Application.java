/*----------------------------------------------------------------------------------------------------------------------
    JavaSE'de tipik olarak First In First Out (FIFO) kuyruk yapısının temsil eden ve Collection<T> arayüzünden türetilmiş Queue<T>
    arayüzü vardır. FIFO kuyruk sistemi elemanın sona eklenip baştan alınması anlamında olduğundan bu arayüzü destekleyen
    veri yapıları maliyet açısından bu yapıya uygundur. Yani, veri yapısının ilk elemanın alınması dolayısıyla silinmesinin
    maliyeli olabileceği  durumlarda implemente edilmez. Örneğin ArrayList ve Vector sınıfları bu arayüzü impelemente
    etmezler.

    Queue<T> arayüzünün önemli bazı metotları şunlardır:
        add, offer -> Kuyruğa eleman eklemek için kullanılırlar. add metodu fixed size kuyyruk sistemleri için IllegalStateException
        fırlatır, offer metodu ise bu durumda false değerine geri döner

        element, peek -> Kuyruğun başındaki elemanı silmeden döndürürler. Kuyruk boş ise element metodu NoSuchElementException
        fırlatır, peek metodu bu durumda null değerine geri döner

        remove, poll -> Kuyruğun başındaki elemanı döndürürler ve aynı zamanda silerler. Kuyruk boş ise element metodu
        NoSuchElementException fırlatır, poll metodu bu durumda null değerine geri döner

     Anahtar Notlar: Queue<T> arayüzü tipik olarak FIFO kuyruk sistemleri için kullanılsa da başka şekilde çalışan
     kuyruk sistemleri de söz konusu olabilir. Bu anlamda örneğin add metodu için dokümanlarda insert fiili kullanılmıştır.

     İki taraftan da sonlanabilen kuyruk veri yapıları Deque<T> arayüzü ile temsil edilir (Double ended queue). Deque<T>
     arayüzü Queue<T> arayüzünden türetilmiştir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class Application {
    public static void run(String[] args)
    {

    }
}

