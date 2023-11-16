package org.csystem.app.simulation.camera.car;


import com.karandev.io.util.console.Console;
import com.karandev.io.util.console.commandline.CommandLineUtil;

import java.io.IOException;

class Application {

    private static void doFromMemory(CarCameraInformation information, String model) throws IOException
    {
        information.load().forEach(Console::writeLine, mi -> Console.writeLine("\t%s", mi));
        Console.writeLine("Result:");
        information.search(model).ifPresentOrElse(list -> list.forEach(Console::writeLine), () -> Console.writeLine("Can not find model"));
    }

    private static void doFromFile(CarCameraInformation information, String model) throws IOException
    {
        information.forEachFromFile(Console::writeLine);
        Console.writeLine("Result:");
        information.searchFromFile(model).ifPresentOrElse(list -> list.forEach(Console::writeLine), () -> Console.writeLine("Can not find model"));
    }

    private static void doForThreshold(CarCameraInformation information, String model, long threshold) throws IOException
    {
        if (threshold == 0 || information.getLength() > threshold)
            doFromFile(information, model);
        else
            doFromMemory(information, model);
    }

    public static void run(String[] args)
    {
        CommandLineUtil.checkLengthEquals(args.length, 3, "Wrong number of arguments");

        try {
            doForThreshold(new CarCameraInformation(args[0]), args[1], Long.parseUnsignedLong(args[2]));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid threshold value!...");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occurred:%s", ex.getMessage());
        }

        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}
