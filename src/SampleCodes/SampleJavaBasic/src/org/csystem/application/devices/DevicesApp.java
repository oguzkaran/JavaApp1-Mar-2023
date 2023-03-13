package org.csystem.application.devices;

public class DevicesApp {
    private DevicesApp()
    {}

    public static void run()
    {
        DeviceFactory factory = new DeviceFactory();

        for (DeviceInfo di : factory.getDevices())
            System.out.println(di.toString());
    }
}
