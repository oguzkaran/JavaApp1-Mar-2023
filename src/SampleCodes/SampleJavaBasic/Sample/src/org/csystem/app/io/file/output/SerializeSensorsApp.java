package org.csystem.app.io.file.output;

import org.csystem.app.io.file.data.ConnectionInfo;
import org.csystem.app.io.file.data.Sensor;
import org.csystem.util.console.Console;

import java.io.*;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class SerializeSensorsApp {
    private static void writeObject(String path) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path, true))) {
            int id = Console.readInt("Input id:");
            String name = Console.readString("Input name:");
            String description = Console.readString("Input description:");
            int port = Console.readInt("Input port number:");
            String host = Console.readString("Input host:");
            ConnectionInfo connectionInfo = new ConnectionInfo(port, host);
            Sensor sensor = new Sensor(id, name, connectionInfo);

            sensor.setDescription(description);

            oos.writeObject(sensor);
            oos.flush();
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try  {
            writeObject(args[0]);
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