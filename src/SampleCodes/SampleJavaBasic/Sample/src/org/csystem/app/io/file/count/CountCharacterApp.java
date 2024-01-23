package org.csystem.app.io.file.count;

import org.csystem.util.console.Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class CountCharacterApp {
    private static char getCharacter(String arg)
    {
        int len = arg.length();

        if (len == 2 && arg.charAt(0) != ':' || len > 2)
            return '\0';

        String supported = "nrts";
        String supportedMap = "\n\r\t ";

        if (len == 2) {
            int index;

            if ((index = supported.indexOf(arg.charAt(1))) != -1)
                return supportedMap.charAt(index);

            return '\0';
        }

        return arg.charAt(0);
    }

    private static char checkCharacter(String arg)
    {
        char ch = getCharacter(arg);
        if (ch == '\0') {
            Console.writeErrLine("Invalid character!...");
            System.exit(1);
        }

        return ch;
    }

    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");
        char ch = checkCharacter(args[1]);

        try (BufferedReader br = new BufferedReader(new FileReader(args[0], StandardCharsets.UTF_8))) {
            int count = 0;
            int c;

            while ((c = br.read()) != -1)
                if (c == ch)
                    ++count;

            Console.writeLine("Count:%d", count);
        }
        catch (IOException ex) {
            Console.writeErrLine("IO problem occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.writeErrLine("Problem occurred:%s", ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
