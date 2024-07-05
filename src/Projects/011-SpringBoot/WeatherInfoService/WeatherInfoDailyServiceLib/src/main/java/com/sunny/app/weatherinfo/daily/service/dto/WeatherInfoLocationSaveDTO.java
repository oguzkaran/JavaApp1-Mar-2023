package com.sunny.app.weatherinfo.daily.service.dto;

import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoLocation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(prefix = "m_")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WeatherInfoLocationSaveDTO {

    private int m_elevation;

    private String m_observation;

    private String m_clouds;

    private String m_temperature;

    private int m_humidity;

    private String m_iCAO;

    @EqualsAndHashCode.Include
    public String dateTime;

    private double m_longitude;

    private double m_latitude;

    private String m_dewPoint;

    private String m_countryCode;

    @EqualsAndHashCode.Include
    private String m_stationName;

    private String m_weatherCondition;

    private int m_windDirection;

    private String m_windSpeed;

    private String m_cloudsCode;

    private int m_hectoPascAltimeter;

    private PlaceInfoLocation m_placeInfoLocation;
}
