package org.csystem.application.devices;

public class DeviceFactory {
    private final String [] m_devicesStr;

    public DeviceFactory()
    {
        m_devicesStr = new String[] {
                "Weather Sensor\0:34000:\0:185.45.67.23",
                "Humidity Sensor\0:35000:\0:185.45.67.27",
                "Test sensor\0:4000:\0:195.45.67.23",
        };
    }

    public DeviceInfo [] getDevices()
    {
        DeviceInfo [] devices = new DeviceInfo[m_devicesStr.length];

        for (int i = 0; i < m_devicesStr.length; ++i) {
            String devicesStr = m_devicesStr[i];

            int firstNullCharIndex = devicesStr.indexOf('\0');

            //...

            int lastNullCharIndex = devicesStr.lastIndexOf('\0');

            //...

            int port = Integer.parseInt(devicesStr, firstNullCharIndex + 2, lastNullCharIndex - 1, 10); // Since Java 9

            String name = devicesStr.substring(0, firstNullCharIndex);
            String host = devicesStr.substring(lastNullCharIndex + 2);

            devices[i] = new DeviceInfo(name, host, port);
        }

        return devices;
    }
}
