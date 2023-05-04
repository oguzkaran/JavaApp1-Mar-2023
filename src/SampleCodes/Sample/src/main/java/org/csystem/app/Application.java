/*----------------------------------------------------------------------------------------------------------------------
    Bir program çalıştırıldığında 3 tane dosya açılır: standard input (stdin), standard output (stdout), "standard error (stderr)"
    Aslında ekrana basma ve klavyeden okuma kavramı işletim sistemine özgüdür. Aslında desktop işletim sistemlerinde
    genel olarak klavye default olarak "stdin"'e yönlendirilmiştir. Ekran da default olarak "stdout"'a yönlendirilmiştir.
    System sınıfı içerisinde out isimli static olarak bildirilmiş PrintStream türünden bir raferans bulunmaktadır.
    Bu referans ile çağrılan print, prinln, printf, format gibi metotlar stdout'a yazma yaparlar. JavaSE'de stdout'a yazma yapan
    metotlar da bulunmaktadır. Benzer şekilde System sınıfı içerisibde static olarak bildirilmiş InputStream türünden
    bir referans da bulumaktadır. Bu durumda hep kullandığımız şu kalıpta aslında stdin'den okuma Scanner sınıfı sağlanmaktadır:
        var kb = new Scanner(System.in);
    InputStream sınıfı ileride detaylı olarak incelenecektir. Yani özetle System.in stdin'i, System.out ise stdout'u
    temsil eder. stderr birçok sistemde default olarak stdout'a yönlendirilmiştir. stderr System.err ile temsil edilmektedir.
    err'de PrintStream türünden bir referanstır.

    stdin, stdout ve stderr başka bir yere yönlendirilebilir. Bu işlem program çalıştırılırken yapılabilmektedir Program
    içerisinde veya program çalıştırılırken bir yönlendirme yapılmamışsa default yönlendirmeler kullanılır.

    Aşağıdaki programı komut satırından şu şekilde çalıştırınız:
        java -jar Sample-14.0.0.jar < input.txt 2> error.txt > output.txt
    Burada input.txt dosyasından 4 tane satır okunacak ve ouput.txt ve error.txt dosyalarınba yazma yapılacaktır. Yani
    stdin, stdout ve stderr dosyaları ilgili dosyalara yönlendirilerek program çalıştırılmıştır (redirection).
    Bu şekildeki çalıştırmada output.txt ve error.txt dosyaları daha önce varsa, içerisindeki bilgiler kaybedilecektir (truncate).
    stdout ve stderr yönlendirmeleri >> veta 2>> şeklinde yapılırsa bu durumda yönlendirilen dosyalar daha önce varsa dosyaların
    sonuna ekleme yapılacaktır. Burada stdin, stdout ve stderr dosyaları, dosyalara yönlendirilmiştir. Bu işlen uygulamalaar
    arasında da işletim sistemine bağlı olarak ve ya program içerisinde yapılabilir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.NoSuchElementException;
import java.util.Scanner;

class Application {
    public static void run(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Console.writeLine("Program started");

        try {
            while (true) {
                var str = scanner.nextLine();

                System.out.printf("Line:%s%n", str);
            }
        }
        catch (NoSuchElementException ignore) {
            System.out.println("End of lines");
        }
    }
}



