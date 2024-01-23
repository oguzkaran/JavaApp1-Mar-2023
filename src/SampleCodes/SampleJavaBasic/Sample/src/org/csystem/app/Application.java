package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConverter;
import org.csystem.util.system.SystemUtil;

public class Application {
    public static void run(String[] args)
    {
        Console.writeLine("Endian of system:%s", SystemUtil.endianText());
        while (true) {
            int a = Console.readInt("Input a number:");
            Console.writeLine("Big endian value:%d, Little endian value:%d", a, BitConverter.toLittleEndian(a));

            if (a == 0)
                break;
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
