package org.csystem.application.devices;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public final class StoreDevicesToArrayApp {
    private StoreDevicesToArrayApp()
    {}

    public static void run()
    {
        Random random = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.print("Başlangıç \"capacity\" değerini giriniz:");
        ArrayList<DeviceInfo> devices = new ArrayList<>(Integer.parseInt(kb.nextLine()));

        for (;;) {
            System.out.print("Cihaz adını giriniz:");
            String name = kb.nextLine();

            if ("elma".equals(name))
                break;

            System.out.print("Cihaz IP adresini giriniz:");
            String host = kb.nextLine();

            System.out.print("Cihaz port numarasını giriniz:");
            int port = Integer.parseInt(kb.nextLine());

            devices.add(new DeviceInfo(name, host, port, random.nextBoolean()));
            System.out.printf("Size:%d%n", devices.size());
        }

        System.out.println("-------------------------------------------");

        for (DeviceInfo di : devices)
            System.out.println(di);


        System.out.printf("Size:%d%n", devices.size());
    }
}
