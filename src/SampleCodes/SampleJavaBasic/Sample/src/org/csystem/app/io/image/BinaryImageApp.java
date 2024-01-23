package org.csystem.app.io.image;

import org.csystem.io.image.CImage;
import org.csystem.io.image.CImageFormat;
import org.csystem.util.console.Console;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class BinaryImageApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");

        try {
            int threshold = Integer.parseInt(args[1]);
            CImage image = new CImage(args[0]);

            image.binary(threshold);
            image.save("bi" + args[0], CImageFormat.PNG);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid threshold value!...");
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
