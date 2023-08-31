/*----------------------------------------------------------------------------------------------------------------------
   Bir annotation default olarak aynı bildirimde birden fazla kez işaretlenemez. Bir annotation'ın aynı bildirimde
   birden fazla kez yazılabilmesi için aşağıdaki adımlara göre bidirilmelidir:
   1. Annation Reperatable isimli bir annotationb ile işraretlenir. Repeatable annotation'ı bir annotation sınıfın
   class referansını alır.

   2. Repeatable annotation'ına verilecek annotation'ın tekrarlanacak annotation türümde bir dizi türünden value isimli
   bir attibute'uolmalıdır

   Burada Repeatable annotation'ına verilen annotation sınıfın Target değerleri, tekrarlanan annotation'ın target
   değerlerinin alt kümesi olmalıdır. Ancak pratikte Target ve Retention bilgileri aynı yapılır.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.commandprompt.CommandPrompt;
import com.karandev.util.console.commandprompt.annotation.Command;
import com.karandev.util.console.commandprompt.annotation.Commands;
import com.karandev.util.console.commandprompt.annotation.ErrorCommand;

class Application {
    public static void run(String [] args)
    {
        var commandPrompt = new CommandPrompt.Builder()
                .setPrompt("CSD")
                .setSuffix(">")
                .register(new CommandInfo())
                .build();

        commandPrompt.run();
    }
}

class CommandInfo {
    @Command("ls")
    @Command("list")
    @Command("dir")
    public void list(String path)
    {
        //...
    }

    @Commands({@Command("copy"), @Command("cp")})
    public void copy(String source, String target)
    {
        //...
    }

    @Commands({@Command("quit"), @Command})
    public void exit()
    {
        //...
    }


    @ErrorCommand
    public void error()
    {
        //...
    }
}