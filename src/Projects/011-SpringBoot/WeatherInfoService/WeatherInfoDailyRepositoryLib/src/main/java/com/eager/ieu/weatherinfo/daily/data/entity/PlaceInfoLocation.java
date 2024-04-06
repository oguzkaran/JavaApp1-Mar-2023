package com.eager.ieu.weatherinfo.daily.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "place_info_locations")
public class PlaceInfoLocation {
    @Id
    @Column(name = "place_name")
    public String placeName;

    public double latitude;

    public double longitude;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "placeInfoLocation", cascade = CascadeType.ALL)
    public WeatherInfoLocation weatherInfoLocation;

    @Override
    public int hashCode() {
        return placeName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PlaceInfoLocation p && placeName.equals(p.placeName);
    }
}
