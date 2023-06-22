/*----------------------------------------------------------------------------------------------------------------------
    Anonim Sınıflar: Bildirim sırasında programcının isim vermediği sınıflardır. Anonim sınıf bildiriminin genel biçimi
    şu şekildedir:
        new <tür>([Argümanlar]) {
            <bildirimler>
        }
    Bu sentaksta tür sınıf, arayüz vb. user defined type'lardan olabilir. Eğer bu tür bir sınıf ise o sınıftan türetilmiş
    bir sınıf bildirimi ile beraber, türemiş sınıf türünden nesne yaratılmış olur. Eğer tür bir arayüz ise o arayüzü
    destekleyen (implementation) bir sınıf bildirimi ve o sınıf türünden bir nesne yatılmış olur. Şüphesiz anonim sınıflara
    byte code üretilirken isim verilir. Bu ismin genel convention'ı şudur:
        <anonim sınıf bildiriminin yapıldığı sınıf ismi>$<o sınıf içerisinde yukarıdan aşağıya kaçıncı anonim sınıf olduğu sayısı>
    Birebir aynı olsa bile her bildirim ayrı bir sınıf demektir.
    Bu sentaksta kullanılan sınıfın türetmeye kapalı olmaması yani final olarak bildirilmemiş olması gerekir. Sınıfn
    sentaksta geçilen argümanlar için "the most applicable" ctor'unun var olması gerekir. Yani hangi ctor'un çağrılacağı
    method overload resolution kurallarına göre belirlenir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String [] args)
    {
        Sample s1 = new Sample() {

            public void foo()
            {
                //...
            }
            //...
        };

        Sample s2 = new Sample(10) {
            //...
        };

        Console.writeLine(s1.getClass().getName());
        Console.writeLine(s2.getClass().getName());
    }
}


class Sample {
    private int m_x;

    public Sample()
    {
    }

    public Sample(int x)
    {
        m_x = x;
    }

    public void printValue()
    {
        Console.writeLine("value: %d", m_x);
    }
}

