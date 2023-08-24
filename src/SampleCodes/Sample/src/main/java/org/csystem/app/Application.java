/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte generic bir UDT'nin her açılımının çalışma zamanında farklı türler OLMADIĞı gösterilmektedir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.math.geometry.Point;

import java.util.ArrayList;

class Application {
    public static void run(String [] args)
    {
        var texts = new ArrayList<String>();
        var points = new ArrayList<Point>();

        Console.writeLine(texts.getClass() == points.getClass() ? "Aynı nesne" : "Farklı nesneler");
    }
}

