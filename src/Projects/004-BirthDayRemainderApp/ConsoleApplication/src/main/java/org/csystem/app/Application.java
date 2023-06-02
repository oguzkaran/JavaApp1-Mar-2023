package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.datetime.BirthDayRemainder;

import static com.karandev.util.console.commandline.CommandLineUtil.checkLengthEquals;
class Application {
    private static void doBirthDayReminder(BirthDayRemainder remainder)
    {
        var birthDayInfo = remainder.getBirthDayInfo();

        switch (birthDayInfo.getBirthDayStatus()) {
            case BEFORE -> Console.writeLine("Doğum gününüz şimdiden kutlu olsun");
            case AFTER -> Console.writeLine("Geçmiş doğum gününüz kutlu olsun");
            default -> Console.writeLine("Doğum gününüz kutlu olsun");
        }

        Console.writeLine("Yeni yaşınız:%f", birthDayInfo.getAge());
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 3, "Wrong number of arguments");

        try {
            var day = Integer.parseInt(args[0]);
            var month = Integer.parseInt(args[1]);
            var year = Integer.parseInt(args[2]);

            doBirthDayReminder(new BirthDayRemainder(day, month, year));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
    }
}
