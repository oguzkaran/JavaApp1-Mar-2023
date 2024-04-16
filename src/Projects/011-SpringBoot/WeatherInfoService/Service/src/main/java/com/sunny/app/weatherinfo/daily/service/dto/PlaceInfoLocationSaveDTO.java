package com.sunny.app.weatherinfo.daily.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceInfoLocationSaveDTO {
    @JsonProperty("placename")
    public String placeName;
    public double latitude;
    public double longitude;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PlaceInfoLocationSaveDTO pil && placeName.equals(pil.placeName);
    }

    @Override
    public int hashCode()
    {
        return placeName.hashCode();
    }
}
