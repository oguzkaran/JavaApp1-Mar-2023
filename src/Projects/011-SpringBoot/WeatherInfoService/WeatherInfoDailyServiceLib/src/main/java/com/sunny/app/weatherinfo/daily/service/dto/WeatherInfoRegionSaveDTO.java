package com.sunny.app.weatherinfo.daily.service.dto;

import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoRegion;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WeatherInfoRegionSaveDTO {
    private double m_longitude;
    private String m_observation;
    private String m_iCAO;
    private String m_clouds;
    private String m_dewPoint;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String m_cloudsCode;
    @EqualsAndHashCode.Include
    private String m_dateTime;
    private String m_temperature;
    private int m_humidity;
    private String m_stationName;
    private String m_weatherCondition;
    private int m_windDirection;
    private String m_windSpeed;
    private double m_latitude;
    @EqualsAndHashCode.Include
    private PlaceInfoRegion m_placeInfoRegion;
}
