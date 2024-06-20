package com.sunny.app.weatherinfo.daily.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Accessors(prefix = "m_")
public class WeatherInfoRegionDTO {
    private double m_longitude;

    private String m_observation;

    private String m_iCAO;

    private String m_clouds;

    private String m_dewPoint;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String m_cloudsCode;

    @EqualsAndHashCode.Include
    public String dateTime;

    private String m_temperature;

    private int m_humidity;

    @EqualsAndHashCode.Include
    private String m_stationName;

    private String m_weatherCondition;

    private int m_windDirection;

    private String m_windSpeed;

    private double m_latitude;
}
