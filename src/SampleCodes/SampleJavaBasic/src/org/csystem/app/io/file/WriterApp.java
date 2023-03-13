/*----------------------------------------------------------------------------------------------------------------------
    WriterApp
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file;

import org.csystem.util.converter.BitConverter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.csystem.util.console.CommandLineUtil.checkIfNotEqualAndExit;

public class WriterApp {
    public static void main(String[] args)
    {
        checkIfNotEqualAndExit(args, 1, "Invalid arguments");

        Scanner kb = new Scanner(System.in);

        try (FileOutputStream fos = new FileOutputStream(args[0], true)) {
            for (;;) {
                System.out.print("Input a text:");
                String text = kb.nextLine();

                if ("quit".equals(text))
                    break;

                fos.write(BitConverter.getFixedBytes(text, 128));
            }
        }
        catch (NumberFormatException ignore) {
            System.err.println("Invalid number format");
        }
        catch (IOException ignore) {
            System.err.println("IO problem occurs. Try again later!...");
        }
    }
}
