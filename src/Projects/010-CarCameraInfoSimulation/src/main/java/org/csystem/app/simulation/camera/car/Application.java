package org.csystem.app.simulation.camera.car;


import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandline.CommandLineUtil;

import java.io.IOException;

class Application {
    public static void run(String[] args)
    {
        CommandLineUtil.checkLengthEquals(args.length, 3, "Wrong number of arguments");

        try {
            //...
            var ci = new CarCameraInformation(args[0]).load().forEach(Console::writeLine, mi -> Console.writeLine("\t%s", mi));

            ci.search(args[1]).ifPresentOrElse(list -> list.forEach(Console::writeLine), () -> Console.writeLine("Can not find model"));
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occurred:%s", ex.getMessage());
        }

        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}
