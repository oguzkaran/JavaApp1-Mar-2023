package org.csystem.weatherinfo.data.backup.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "place_info_by_locations")
public class PlaceInfoByLocation {
    @Id
    @Column(name = "place_name")
    public String placeName;
    public double latitude;
    public double longitude;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "weather_info_location", cascade = CascadeType.ALL)
    public Set<WeatherInfoLocation> weatherInfoLocations;

    @Override
    public int hashCode() {
        return placeName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PlaceInfoByLocation p && placeName.equals(p.placeName);
    }
}
