package com.kerimtugal.operation.device;

import com.bartucankaya.device.Device;
import org.csystem.util.console.Console;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.random.RandomGenerator;

public class DeviceOperation implements Closeable {
    private final Device m_device;

    public DeviceOperation(Device device)
    {
        Console.writeLine("Device Operation!...");
        m_device = device;
    }

    public void doForDevice() throws IOException
    {
        //...
        RandomGenerator randomGenerator = new Random();

        if (randomGenerator.nextBoolean())
            throw new IOException("IO problem");

        m_device.doWork();

        Console.writeLine("Operation on %s device at '%s'", m_device.isOpen() ? "open" : "closed", m_device.getUrl());
    }

    public void close() throws IOException
    {
        Console.writeLine("Device operation closed!...");
        m_device.close();
    }
}
