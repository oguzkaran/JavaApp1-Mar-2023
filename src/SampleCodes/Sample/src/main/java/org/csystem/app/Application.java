/*----------------------------------------------------------------------------------------------------------------------
    Bir record'a özgü olarak şu ctor'lar yazılabilir:
    - Tüm elemanları parametre olarak alan ctor: Bu ctor'un parametre değişkenleri ile aynı isimde getter metotlar
    otomatik olarak yazılır. Bu ctor bazı kaynaklarda "primaru ctor" olarak da isimlendirilmektedir

    - Canonical ctor: Bu ctor sınıf isminden sonra { ve } küme parantezleri olarak yazılır. non-static initializer'a
    benzetilebilir. Ancak burada arka planda oluşturuan veri elemnanlaraına (back field) değer atanmış olur. Halbıki
    non-static initializer ctor'aan önce çağrılır. Burada tipik olarak ctr'a geçilen değerlerin kontrolü gibi işlemler
    yapılabilir

    - Herhagi bir parmetrik yapıda ctor: Bu ctor'lar içerisinde tüm elemanlara değer atanmalıdır. Buradaki elemanmlara
    tüm elemanları içeren ctor ctor'un parametre değişken isimleriyle erişilebilir.

    Anahtar Notlar: Herhangi bir ctor içerisinde tüm parametreleri içeen ctor'a this ctor sentaksı ile erişilmelidir

    Bir record herhangi bir sınıftan türetilemez. Bir record istenildiği kadar arayüzü destekleyebilir. Programcı isterse
    Object sınıfının hashCode, toString, equals ve clone metotlarını record içerisinde override edebilir. recor'unb n
    non-static bir metodu içerisinde veri elemanlarına doğrunda ismş ile yani getter kullanmadan erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.io.Closeable;
import java.io.IOException;

class Application {
    public static void run(String[] args)
    {
        var dev = new Device("test", "192.168.1.123", 300);

        Console.writeLine(dev);
    }
}

record Device(String name, String host, int port) implements Closeable {
    Device {
        if (port < 1024 || port > 65535)
            throw new IllegalArgumentException("invalid port");
        //...
    }

    public Device(String name)
    {
        this(name, "localhost", 3000);
    }


    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void close() throws IOException
    {
        //...
    }
}


