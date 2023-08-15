/*----------------------------------------------------------------------------------------------------------------------
    Deprecated annotation'ı bir bildirimin deprecated olarak işaretlenmesi için kullanılır. Deprecated, bir RUNTIME
    annotation olmasına karşın Java derleyicisi ve bir çok static kod analizi aracı tarafından dikkate alınır. Java
    derleyicileri ve static kod analizi araçları deprecated olan bir bildirimin kullanılması durumunda uyarı mesajı
    verirler. Java 9 ile birlikte Deprecated annotation'ına boolean türden forRemoval ve String türden since elemanları
    eklenmiştir. forRemoval default olarak false değerindedir. Bu eleman deprecated olan bildirimin ileride silinip
    silinmeyeceği konusunda bilgi vermek amaçlı kullanılır. since elemanının default değeri boş string'dir. Genel olarak
    deprecated olan versiyonu belirtmek için kullanılır. Derleyicilerin ve static kod analizi araçlarının hemen hepsi
    bu iki eleman için de uygun uyarıyı verirler.
    org-csystem-util-datetime-legacy kütüphanesindeki sınıfları inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.datetime.DateTime;

class Application {
    public static void run(String [] args)
    {
        var a = new Integer(10);

        Console.writeLine(a);
    }
}

