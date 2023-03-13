/*----------------------------------------------------------------------------------------------------------------------
    ReaderApp
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file;

import org.csystem.util.converter.BitConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.csystem.util.console.CommandLineUtil.checkIfNotEqualAndExit;

public class ReaderApp {
    public static void main(String[] args)
    {
        checkIfNotEqualAndExit(args, 1, "Invalid arguments");

        try (FileInputStream fis = new FileInputStream(args[0])) {
            int result;
            byte [] data = new byte[256];

            while ((result = fis.read(data)) > 0 && result == data.length) {
                String str = BitConverter.toStringFixed(data);
                System.out.println(str);
            }

            if (result != -1)
                throw new IOException("File format corruption");
        }
        catch (FileNotFoundException ignore) {
            System.err.println("File not found");
        }
        catch (IOException ex) {
            System.err.printf("Exception occurs:%s", ex.getMessage());
        }
    }
}
