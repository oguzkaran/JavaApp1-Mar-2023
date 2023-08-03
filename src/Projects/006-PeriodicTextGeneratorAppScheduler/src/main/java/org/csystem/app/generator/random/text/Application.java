package org.csystem.app.generator.random.text;

import com.karandev.util.console.Console;
import org.csystem.generator.random.RandomPeriodicTextGenerator;

import java.util.Random;

import static com.karandev.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 5, "Wrong number of arguments");
            var count = Integer.parseInt(args[0]);
            var min = Integer.parseInt(args[1]);
            var bound = Integer.parseInt(args[2]);
            var delay = Long.parseLong(args[3]);
            var period = Long.parseLong(args[4]);
            var randomTextGenerator = new RandomPeriodicTextGenerator(new Random(), min, bound, count, delay, period);

            randomTextGenerator.generate(str -> Console.writeLine("Text:%s", str));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments!...");
        }
    }
}
