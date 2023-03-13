package org.csystem.application.io.file.ncharacters;

import org.csystem.util.console.CommandLineUtil;

import java.io.IOException;

public final class NumberOfCharacterInFileApp {
    private static int getEscapeChar(String arg)
    {
        String escapes = "n\nr\rt\ts ";
        int idx = escapes.indexOf(arg.charAt(1));

        return idx == -1 ? -1 : escapes.charAt(idx + 1);
    }

    private static char checkAndGetChar(String arg)
    {
        int len = arg.length();

        char ch = 0;
        boolean invalid = false;

        if (len > 2)
            invalid = true;
        else if (len == 2) {
            if (arg.charAt(0) == '\\') {
                int result = getEscapeChar(arg);

                if (result == -1)
                    invalid = true;
                else
                    ch = (char)result;
            }
            else
                invalid = true;
        }
        else
            ch = arg.charAt(0);

        if (invalid) {
            System.out.println("Invalid argument");
            System.exit(1);
        }

        return ch;
    }

    private NumberOfCharacterInFileApp()
    {
    }

    public static void run(String [] args)
    {
        CommandLineUtil.checkIfNotEqualAndExit(args, 2, "Wrong number of arguments");

        char ch = checkAndGetChar(args[1]);

        try (NumberOfCharacterInFile nocf = new NumberOfCharacterInFile(args[0], ch)) {
            nocf.run();
            System.out.println(nocf.getCount());
        }
        catch (IOException ignore) {
            System.err.println("IOError occurs");
        }
    }
}
