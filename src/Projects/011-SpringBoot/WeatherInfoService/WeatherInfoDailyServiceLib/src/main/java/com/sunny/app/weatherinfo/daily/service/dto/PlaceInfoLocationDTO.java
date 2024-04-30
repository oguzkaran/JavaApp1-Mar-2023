package com.sunny.app.weatherinfo.daily.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceInfoLocationDTO {
    @JsonProperty("placename")
    public String placeName;
    public double latitude;
    public double longitude;

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PlaceInfoLocationDTO pil && placeName.equals(pil.placeName);
    }

    @Override
    public int hashCode()
    {
        return placeName.hashCode();
    }
}
