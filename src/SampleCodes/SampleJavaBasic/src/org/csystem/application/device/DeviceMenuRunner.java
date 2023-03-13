package org.csystem.application.device;

import org.csystem.util.console.Console;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DeviceMenuRunner implements Closeable {
    private final RandomAccessFile m_deviceFile;
    private final String m_path;
    private long m_curId;

    private static void displayMenu()
    {
        System.out.println("1.Insert");
        System.out.println("2.List");
        System.out.println("3.Delete");
        System.out.println("4.Exit");
        System.out.print("Option:");
    }

    private Device getDeviceByStdIn()
    {
        String name = Console.read("Input name:");
        String host = Console.read("Input host:");

        return new Device(m_curId, name, host);
    }

    private void listDevices() throws IOException
    {
        m_deviceFile.seek(Long.BYTES);

        try {
            for (;;) {
                Device device = DevicePersistence.readActiveDevice(m_deviceFile);

                if (device == null)
                    continue;

                System.out.println(device);
            }
        }
        catch (EOFException ignore) {

        }
    }

    private void insertProc() throws IOException
    {
        Device device = getDeviceByStdIn();

        m_deviceFile.seek(m_deviceFile.length());
        DevicePersistence.writeDevice(device, m_deviceFile);
        m_deviceFile.seek(0);
        m_deviceFile.writeLong(++m_curId);
    }

    private void listProc() throws IOException
    {
        if (m_deviceFile.length() != Long.BYTES)
            this.listDevices();
        else
            System.out.println("No device yet!...");
    }

    private void deleteProc() throws IOException
    {
        String name = Console.read("Input name:");
        m_deviceFile.seek(Long.BYTES);
        boolean found = false;

        try {
            for (;;) {
                long curOffset = m_deviceFile.getFilePointer();
                Device device = DevicePersistence.readActiveDevice(m_deviceFile);

                if (device == null)
                    continue;

                if (device.getName().equalsIgnoreCase(name)) {
                    found = true;
                    m_deviceFile.seek(curOffset);
                    m_deviceFile.writeBoolean(false);
                    break;
                }
            }
        }
        catch (EOFException ignore) {
            if (!found)
                System.out.println("No device found!...");
        }
    }

    private void quitProc()
    {
        System.out.println("Thanks");
        System.exit(0);
    }

    private void doWorkForMenuOption(int option) throws IOException
    {
        switch (option) {
            case 1:
                this.insertProc();
                break;
            case 2:
                this.listProc();
                break;
            case 3:
                this.deleteProc();
                break;
            case 4:
                this.quitProc();
                break;
            default:
                System.out.println("Invalid menu option");
        }
    }

    private void doMenuOperations() throws IOException
    {
        displayMenu();
        int option = Console.readInt("", "Invalid menu option number");
        this.doWorkForMenuOption(option);
    }

    public DeviceMenuRunner(String path) throws IOException
    {
        m_path = path;
        m_deviceFile = new RandomAccessFile(m_path, "rw");
    }

    public void run() throws IOException
    {
        if (m_deviceFile.length() == 0)
            m_deviceFile.writeLong(++m_curId);
        else
            m_curId = m_deviceFile.readLong();

        for (;;)
            this.doMenuOperations();
    }

    public void close() throws IOException
    {
        m_deviceFile.close();
    }
}
