package com.sunny.app.weatherinfo.daily.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"m_latitude", "m_longitude"})
public class PlaceInfoLocationDTO {
    @Accessors(prefix = "m_")
    private String m_placeName;
    @Accessors(prefix = "m_")
    private double m_latitude;
    @Accessors(prefix = "m_")
    private double m_longitude;

}
