package com.eager.ieu.weatherinfo.backup.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather_info_locations")
public class WeatherInfoRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_info_location_id")
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
    @JoinColumn(name = "place_info_by_location", nullable = false)
    public PlaceInfoLocation m_placeInfoLocation;

    @Override
    public int hashCode()
    {
        return Long.valueOf(id).hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof WeatherInfoRegion w && id == w.id;
    }
}
