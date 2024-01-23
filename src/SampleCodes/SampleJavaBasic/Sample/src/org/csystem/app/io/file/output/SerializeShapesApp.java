package org.csystem.app.io.file.output;

import com.yusuflale.drawing.shape.Shape;
import com.yusuflale.drawing.shape.factory.ShapeFactory;
import org.csystem.util.console.Console;

import java.io.*;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class SerializeShapesApp {
    private static void writeObject(String path, Shape shape) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path, true))) {
            oos.writeObject(shape);
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");

        try  {
            int count = Integer.parseInt(args[1]);
            ShapeFactory factory = new ShapeFactory();

            while (count-- > 0) {
                Shape shape = factory.createShape();

                Console.writeLine(shape);
                writeObject(args[0], shape);
            }
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid count value");
        }
        catch (InvalidClassException ex) {
            Console.writeErrLine("Invalid class to serialize:%s", ex.getMessage());
        }
        catch (NotSerializableException ex) {
            Console.writeErrLine("All of the elements do not implement Serializable:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.writeErrLine("I/O problem occurs:%s", ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}