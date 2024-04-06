package com.eager.ieu.weatherinfo.daily.data.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "place_info_regions")
public class PlaceInfoRegion {
    @Id
    public String region;

    public double east;

    public double west;

    public double north;

    public double south;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "placeInfoRegion", cascade = CascadeType.ALL)
    public Set<WeatherInfoRegion> weatherInfoRegions;

    @Override
    public int hashCode()
    {
        return region.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PlaceInfoRegion p && region.equals(p.region);
    }
}
