package com.sunny.app.weatherinfo.daily.service.dto;

import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoLocation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WeatherInfoLocationSaveDTO {
    @Accessors(prefix = "m_")
    private int m_elevation;

    @Accessors(prefix = "m_")
    private String m_observation;

    @Accessors(prefix = "m_")
    private String m_clouds;

    @Accessors(prefix = "m_")
    private String m_temperature;

    @Accessors(prefix = "m_")
    private int m_humidity;

    @Accessors(prefix = "m_")
    private String m_iCAO;

    @EqualsAndHashCode.Include
    public String dateTime;

    @Accessors(prefix = "m_")
    private double m_longitude;

    @Accessors(prefix = "m_")
    private double m_latitude;

    @Accessors(prefix = "m_")
    private String m_dewPoint;

    @Accessors(prefix = "m_")
    private String m_countryCode;

    @EqualsAndHashCode.Include
    @Accessors(prefix = "m_")
    private String m_stationName;

    @Accessors(prefix = "m_")
    private String m_weatherCondition;

    @Accessors(prefix = "m_")
    private int m_windDirection;

    @Accessors(prefix = "m_")
    private String m_windSpeed;

    @Accessors(prefix = "m_")
    private String m_cloudsCode;

    @Accessors(prefix = "m_")
    private int m_hectoPascAltimeter;

    @Accessors(prefix = "m_")
    private PlaceInfoLocation m_placeInfoLocation;
}
