package org.csystem.app.io.file.input;

public class CityInfo {
    private final int m_plate;
    private final String m_name;
    private final double m_latitude;
    private final double m_longitude;

    public CityInfo(int plate, String name, double latitude, double longitude)
    {
        m_plate = plate;
        m_name = name;
        m_latitude = latitude;
        m_longitude = longitude;
    }

    public int getPlate()
    {
        return m_plate;
    }

    public String getName()
    {
        return m_name;
    }

    public double getLatitude()
    {
        return m_latitude;
    }

    public double getLongitude()
    {
        return m_longitude;
    }

    public String toString()
    {
        return String.format("[%d] %s, %f %f", m_plate, m_name, m_latitude, m_longitude);
    }
}
