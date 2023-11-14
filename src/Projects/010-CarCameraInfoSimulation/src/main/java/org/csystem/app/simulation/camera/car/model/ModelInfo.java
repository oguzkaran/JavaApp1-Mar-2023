package org.csystem.app.simulation.camera.car.model;

import org.csystem.util.datetime.formatter.DateTimeFormatterUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModelInfo {
    private final String m_model;
    private final LocalDateTime m_dateTime;
    private final double m_latitude;

    private final double m_longitude;

    public ModelInfo(String model, String dateTimeStr, double latitude, double longitude)
    {
        this(model, LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss")), latitude, longitude);
    }

    public ModelInfo(String model, LocalDateTime dateTime, double latitude, double longitude)
    {
        m_model = model;
        m_dateTime = dateTime;
        m_latitude = latitude;
        m_longitude = longitude;
    }

    public String getModel()
    {
        return m_model;
    }

    public LocalDateTime getDateTime()
    {
        return m_dateTime;
    }

    public double getLatitude()
    {
        return m_latitude;
    }

    public double getLongitude()
    {
        return m_longitude;
    }

    @Override
    public int hashCode()
    {
        return m_model.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof ModelInfo mi && mi.m_model.equals(m_model);
    }

    @Override
    public String toString()
    {
        return String.format("%s, %s %f, %f", m_model, DateTimeFormatterUtil.DATETIME_DOT_SEC_TR.format(m_dateTime), m_latitude, m_longitude);
    }
}
