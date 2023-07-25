package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.karandev.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    private static TimerTask createTimerTask(Timer timer, int count, int min, int bound)
    {
        var random = new Random();

        return new TimerTask() {
            int n;
            public void run()
            {
                if (n++ != count)
                    Console.writeLine(StringUtil.getRandomTextEN(random, random.nextInt(min, bound)));
                else
                    timer.cancel();
            }
        };
    }

    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 5, "Wrong number of arguments");
            var count = Integer.parseInt(args[0]);
            var min = Integer.parseInt(args[1]);
            var bound = Integer.parseInt(args[2]);
            var delay = Long.parseLong(args[3]);
            var period = Long.parseLong(args[4]);
            var timer = new Timer();

            timer.scheduleAtFixedRate(createTimerTask(timer, count, min, bound), delay, period);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments!...");
        }
    }
}
