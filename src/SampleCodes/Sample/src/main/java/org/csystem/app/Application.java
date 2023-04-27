/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var sb = new StringBuilder();

        sb.append("ankara:").append("06").append('-').append("istanbul:").append(34);

        Console.writeLine(sb);
    }
}



