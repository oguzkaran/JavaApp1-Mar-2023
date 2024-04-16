package com.sunny.app.weatherinfo.geonames;

import com.sunny.app.weatherinfo.geonames.dto.GeoWeatherLocationInfo;
import com.sunny.app.weatherinfo.geonames.dto.GeoWeatherLocation;
import com.sunny.app.weatherinfo.geonames.dto.GeoWeatherRegion;
import com.sunny.app.weatherinfo.geonames.dto.GeoWeatherRegionInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class GeoWeatherInfoSearchHelper {
    private final RestTemplate m_restTemplate;
    private final String m_locationUrlTemplate;
    private final String m_regionUrlTemplate;

    public GeoWeatherInfoSearchHelper(RestTemplate restTemplate,
                                      @Value("${weather.location.url}") String locationUrlTemplate,
                                      @Value("${weather.region.url}") String regionUrlTemplate) {
        this.m_restTemplate = restTemplate;
        this.m_locationUrlTemplate = locationUrlTemplate;
        this.m_regionUrlTemplate = regionUrlTemplate;
    }

    public Optional<GeoWeatherLocation> findWeatherLocation(double latitude, double longitude)
    {
        var gwl = m_restTemplate.getForObject(String.format(m_locationUrlTemplate, latitude, longitude), GeoWeatherLocation.class);

        return Optional.ofNullable(gwl);
    }

    public Optional<GeoWeatherLocationInfo> findWeatherLocationInfo(double latitude, double longitude)
    {
        var gwliOpt = findWeatherLocation(latitude, longitude);

        return gwliOpt.map(geoWeatherLocation -> geoWeatherLocation.weatherObservation);
    }

    public Optional<GeoWeatherRegion> findWeatherRegion(double north, double south, double east, double west)
    {
        return findWeatherRegion(north, south, east, west, 10);
    }

    public Optional<GeoWeatherRegion> findWeatherRegion(double north, double south, double east, double west, int maxRows)
    {
        var gwrOpt = m_restTemplate.getForObject(String.format(m_regionUrlTemplate, north, south, east, west, maxRows), GeoWeatherRegion.class);

        return Optional.ofNullable(gwrOpt);
    }

    public Iterable<GeoWeatherRegionInfo> findWeatherRegionInfo(double north, double south, double east, double west)
    {
        return findWeatherRegionInfo(north, south, east, west, 10);
    }

    public Iterable<GeoWeatherRegionInfo> findWeatherRegionInfo(double north, double south, double east, double west, int maxRows)
    {
        var gwriOpt = findWeatherRegion(north, south, east, west, maxRows);

        if(gwriOpt.isEmpty())
            return new ArrayList<>();

        return gwriOpt.get().weatherObservations;
    }
}
