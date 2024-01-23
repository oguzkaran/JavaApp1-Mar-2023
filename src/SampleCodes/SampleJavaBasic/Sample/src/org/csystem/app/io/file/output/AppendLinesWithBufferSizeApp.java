package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendLinesWithBufferSizeApp {
    private static void doAppend(BufferedWriter bw) throws IOException
    {
        while (true) {
            String str = Console.readString("Input a text:");

            if ("quit".equals(str))
                break;

            bw.write(str + "\r\n");
            Console.readChar(); //**
        }
    }

    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(args[0], StandardCharsets.UTF_8, true), Integer.parseInt(args[1]))) {
            doAppend(bw);
        }
        catch (IllegalArgumentException ignore) {
            Console.writeErrLine("Invalid buffer size!....");
        }
        catch (IOException ex) {
            Console.writeErrLine("IO Problem occurred:%s", ex.getMessage());
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
