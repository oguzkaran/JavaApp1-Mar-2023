/*----------------------------------------------------------------------------------------------------------------------
    Console sınıfının readBigDecimal metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var a = Console.readBigDecimal("Birinci sayıyı giriniz:");
        var b = Console.readBigDecimal("İkinci sayıyı giriniz:");
        var c = Console.readBigDecimal("Üçüncü sayıyı giriniz:");
        var d = a.add(b);

        Console.writeLine("a = %.20f", a.doubleValue());
        Console.writeLine("b = %.20f", b.doubleValue());
        Console.writeLine("c = %.20f", c.doubleValue());
        Console.writeLine("d = %.20f", d.doubleValue());
        Console.writeLine(c.equals(d) ? "Eşit" : "Eşit değil");
    }
}
