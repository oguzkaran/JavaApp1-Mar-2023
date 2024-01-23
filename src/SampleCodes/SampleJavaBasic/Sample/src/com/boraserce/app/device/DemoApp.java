package com.boraserce.app.device;

import com.bartucankaya.device.Device;
import com.kerimtugal.operation.device.DeviceOperation;
import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.io.IOException;

public class DemoApp {
    private static void doForDevice(Device device, DeviceOperation deviceOperation) throws IOException
    {
        try (device; deviceOperation) {
            deviceOperation.doForDevice();
        }
    }
    
    public static void run()
    {
        while (true) {
            ThreadUtil.sleep(1000);
            Console.writeLine("-------------------------------------------------------------------");

            try {
                Device dev = new Device("www.csystem.org:50500/app/dev");
                DeviceOperation deviceOperation = new DeviceOperation(dev);

                doForDevice(dev, deviceOperation);
            }
            catch (IllegalArgumentException ignore) {
                Console.writeLine("Invalid URL!...");
            }
            catch (IllegalStateException ignore) {
                Console.writeLine("Connection problem occurs!...");
            }
            catch (IOException ignore) {
                Console.writeLine("Problem in IO!...");
            }


            Console.writeLine("-------------------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
