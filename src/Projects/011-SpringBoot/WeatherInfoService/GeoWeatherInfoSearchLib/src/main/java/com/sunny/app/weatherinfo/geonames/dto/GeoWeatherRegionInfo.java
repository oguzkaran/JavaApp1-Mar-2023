package com.sunny.app.weatherinfo.geonames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoWeatherRegionInfo {
    @JsonProperty("lng")
    public double longitude;
    public String observation;
    @JsonProperty("ICAO")
    public String icao;
    public String clouds;
    public String dewPoint;
    public String cloudsCode;
    @JsonProperty("datetime")
    public String dateTime;
    public String temperature;
    public int humidity;
    public String stationName;
    public String weatherCondition;
    public int windDirection;
    public int hectoPascAltimeter;
    public String windSpeed;
    @JsonProperty("lat")
    public double latitude;
}
