package org.csystem.weatherinfo.data.daily.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "weather_info_regions")
public class WeatherInfoRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weather_info_region_id")
    public long id;
    public int elevation;
    public String observation;

    @Column(name = "icao")
    public String iCAO;
    public String clouds;
    public LocalDateTime datetime;
    public String temperature;
    public int humidity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_info_region", nullable = false)
    public PlaceInfoRegion placeInfoRegion;

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof WeatherInfoRegion w && id == w.id;
    }
}
