package com.eager.ieu.weatherinfo.daily.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "weather_info_locations")
public class WeatherInfoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weather_info_location_id")
    public long id;

    public int elevation;

    public String observation;

    public String clouds;

    public String temperature;

    public int humidity;

    @Column(name = "icao")
    public String iCAO;

    @Column(name = "date_time")
    public LocalDateTime dateTime;

    @Column(name = "langitude")
    public double lng;

    @Column(name = "latitude")
    public double lat;

    @Column(name = "dew_point")
    public String dewPoint;

    @Column(name = "country_code")
    public String countryCode;

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

    @Column(name = "hecto_pasc_altimeter")
    public int hectoPascAltimeter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_name", nullable = false)
    public PlaceInfoLocation placeInfoLocation;

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof WeatherInfoLocation w && id == w.id;
    }
}
