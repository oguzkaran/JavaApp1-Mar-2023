package com.sunny.app.weatherinfo.daily.service.dto;

public class PlaceInfoRegionSaveDTO {
    public String region;
    public double north;
    public double south;
    public double east;
    public double west;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PlaceInfoRegionSaveDTO pir && region.equals(pir.region);
    }

    @Override
    public int hashCode()
    {
        return region.hashCode();
    }
}
