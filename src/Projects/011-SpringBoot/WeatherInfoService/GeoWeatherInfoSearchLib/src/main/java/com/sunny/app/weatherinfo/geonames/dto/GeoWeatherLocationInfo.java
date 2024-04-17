package com.sunny.app.weatherinfo.geonames.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoWeatherLocationInfo {
    public int elevation;
    @JsonProperty("lng")
    public double longitude;
    public String observation;
    @JsonProperty("ICAO")
    public String icao;
    public String clouds;
    public String dewPoint;
    @JsonInclude(Include.NON_NULL)
    public String cloudsCode;
    @JsonProperty("datetime")
    public String dateTime;
    public String countryCode;
    public String temperature;
    public int humidity;
    public String stationName;
    public String weatherCondition;
    @JsonInclude(Include.NON_NULL)
    public Integer windDirection;
    public int hectoPascAltimeter;
    public String windSpeed;
    @JsonProperty("lat")
    public double latitude;
}
