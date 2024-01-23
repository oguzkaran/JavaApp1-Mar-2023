package com.boraserce.app.device;

import com.bartucankaya.device.Device;
import org.csystem.util.console.Console;

import java.io.IOException;

public final class DeviceConnectionUtil {
    private DeviceConnectionUtil()
    {}

    public static void doConnection(String url) throws IOException
    {
        Device dev = null;

        try {
            dev = new Device(url);
            dev.doWork();
        }
        catch (IllegalArgumentException ignore) {
            Console.writeLine("Invalid URL!...");
        }
        catch (IllegalStateException ignore) {
            Console.writeLine("Connection problem occurs!...");
        }
        finally {
            if (dev != null)
                dev.close();
        }
    }
}
