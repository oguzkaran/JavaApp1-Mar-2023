package org.csystem.application.device;

import org.csystem.util.console.CommandLineUtil;

import java.io.IOException;

public class DeviceMenuApp {
    public static void run(String [] args)
    {
        CommandLineUtil.checkIfNotEqualAndExit(args, 1, "Wrong number od arguments");

        try (DeviceMenuRunner runner = new DeviceMenuRunner(args[0])) {
            runner.run();
        }
        catch (IOException ignore) {
            System.err.println("I/O error occurs");
        }
        catch (Throwable ignore) {
            System.err.println("Internal problem. Try again later!...");
        }
    }
}
