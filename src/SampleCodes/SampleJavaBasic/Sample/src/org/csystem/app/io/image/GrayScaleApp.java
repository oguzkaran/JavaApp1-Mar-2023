package org.csystem.app.io.image;

import org.csystem.io.image.CImage;
import org.csystem.io.image.CImageFormat;
import org.csystem.util.console.Console;

import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class GrayScaleApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try {
            CImage image = new CImage(args[0]);

            image.grayScale();
            image.save("gi" + args[0], CImageFormat.PNG);
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
