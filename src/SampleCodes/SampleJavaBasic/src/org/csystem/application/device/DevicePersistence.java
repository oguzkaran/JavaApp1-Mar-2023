package org.csystem.application.device;

import org.csystem.application.devices.DeviceInfo;

import java.io.IOException;
import java.io.RandomAccessFile;

public final class DevicePersistence {
    private DevicePersistence()
    {
    }

    public static void writeDevice(Device dev, RandomAccessFile raf) throws IOException
    {
        raf.writeBoolean(true);
        raf.writeLong(dev.getId());
        raf.writeUTF(dev.getName());
        raf.writeUTF(dev.getHost());
    }

    public static Device readActiveDevice(RandomAccessFile raf) throws IOException
    {
        DeviceRecord dr = readDevice(raf);

        return dr.active ? dr.device : null;
    }

    public static DeviceRecord readDevice(RandomAccessFile raf) throws IOException
    {
        boolean active = raf.readBoolean();
        long id = raf.readLong();
        String name = raf.readUTF();
        String host = raf.readUTF();

        return new DeviceRecord(new Device(id, name, host), active);
    }
}
