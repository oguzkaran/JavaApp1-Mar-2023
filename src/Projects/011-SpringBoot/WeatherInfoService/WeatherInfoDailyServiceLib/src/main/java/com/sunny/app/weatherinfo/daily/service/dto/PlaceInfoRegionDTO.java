package com.sunny.app.weatherinfo.daily.service.dto;

public class PlaceInfoRegionDTO {
    public String region;
    public double north;
    public double south;
    public double east;
    public double west;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PlaceInfoRegionDTO pir && region.equals(pir.region);
    }

    @Override
    public int hashCode()
    {
        return region.hashCode();
    }
}
