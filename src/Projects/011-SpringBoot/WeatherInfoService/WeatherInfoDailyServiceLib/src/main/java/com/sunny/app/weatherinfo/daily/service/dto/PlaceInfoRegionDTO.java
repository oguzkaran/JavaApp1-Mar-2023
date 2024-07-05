package com.sunny.app.weatherinfo.daily.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"m_north", "m_south", "m_east", "m_west"})
public class PlaceInfoRegionDTO {
    @Accessors(prefix = "m_")
    private String m_region;

    @Accessors(prefix = "m_")
    private double m_north;

    @Accessors(prefix = "m_")
    private double m_south;

    @Accessors(prefix = "m_")
    private double m_east;

    @Accessors(prefix = "m_")
    private double m_west;
}
