/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfının getActualMaximum ve getActualMimimum metotları aldıkları field'a karşılık
    gelen bilgiye göre o field'ın en büyük ve en küçük değerin döndürür. after ve before metotları
    iki Calendar bilgisini karşılatırmak için kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class Application {
    public static void run(String [] args)
    {
        var month = Console.readInt("Son kullanma tarihi ay bilgisini giriniz:");
        var year = Console.readInt("Son kullanma tarihi yıl bilgisini giriniz:");
        var expiryDate = new GregorianCalendar(year, month - 1, 1);
        var now = new GregorianCalendar();

        expiryDate.set(Calendar.DAY_OF_MONTH, expiryDate.getActualMaximum(Calendar.DAY_OF_MONTH));

        if (expiryDate.after(now))
            Console.writeLine("Son kullanma tarihi geçmiştir");
        else
            Console.writeLine("Son kullanma tarihi geçmemiştir");
    }
}

