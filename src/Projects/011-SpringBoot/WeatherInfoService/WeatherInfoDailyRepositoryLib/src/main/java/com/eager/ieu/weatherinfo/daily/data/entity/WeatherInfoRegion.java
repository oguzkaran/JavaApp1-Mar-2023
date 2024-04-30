package com.eager.ieu.weatherinfo.daily.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "weather_info_regions")
public class WeatherInfoRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_info_region_id")
    public long id;

    public String observation;

    public String clouds;

    public String temperature;

    public int humidity;

    @Column(name = "icao")
    public String iCAO;

    @Column(name = "date_time")
    public LocalDateTime dateTime;

    @Column(name = "longitude")
    public double lng;

    @Column(name = "latitude")
    public double lat;

    @Column(name = "dew_point")
    public String dewPoint;

    @Column(name = "station_name")
    public String stationName;

    @Column(name = "weather_condition")
    public String weatherCondition;

    @Column(name = "wind_direction")
    public int windDirection;

    @Column(name = "wind_speed")
    public String windSpeed;

    @Column(name = "clouds_code")
    public String cloudsCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region", nullable = false)
    public PlaceInfoRegion placeInfoRegion;

    @Override
    public int hashCode()
    {
        return Objects.hash(observation, clouds, temperature, humidity, iCAO, dateTime, lng,
                lat, dewPoint, stationName, weatherCondition, windDirection, windSpeed, cloudsCode);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof WeatherInfoRegion w &&
                Objects.equals(observation, w.observation) &&
                Objects.equals(clouds, w.clouds) &&
                Objects.equals(temperature, w.temperature) &&
                Objects.equals(humidity, w.humidity) &&
                Objects.equals(iCAO, w.iCAO) &&
                Objects.equals(dateTime, w.dateTime) &&
                Objects.equals(lng, w.lng) &&
                Objects.equals(lat, w.lat) &&
                Objects.equals(dewPoint, w.dewPoint) &&
                Objects.equals(stationName, w.stationName) &&
                Objects.equals(weatherCondition, w.weatherCondition) &&
                Objects.equals(windDirection, w.windDirection) &&
                Objects.equals(windSpeed, w.windSpeed) &&
                Objects.equals(cloudsCode, w.cloudsCode);
    }
}
