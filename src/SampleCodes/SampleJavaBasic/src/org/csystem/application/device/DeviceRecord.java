package org.csystem.application.device;

public class DeviceRecord {
    public Device device;
    public boolean active;

    public DeviceRecord(Device device, boolean active)
    {
        this.device = device;
        this.active = active;
    }
}
