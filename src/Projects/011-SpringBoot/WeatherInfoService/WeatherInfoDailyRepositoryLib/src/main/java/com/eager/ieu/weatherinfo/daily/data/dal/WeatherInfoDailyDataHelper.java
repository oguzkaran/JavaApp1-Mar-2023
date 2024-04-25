package com.eager.ieu.weatherinfo.daily.data.dal;

import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoLocation;
import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoRegion;
import com.eager.ieu.weatherinfo.daily.data.entity.WeatherInfoLocation;
import com.eager.ieu.weatherinfo.daily.data.entity.WeatherInfoRegion;
import com.eager.ieu.weatherinfo.daily.data.repository.IPlaceInfoLocationRepository;
import com.eager.ieu.weatherinfo.daily.data.repository.IPlaceInfoRegionRepository;
import com.eager.ieu.weatherinfo.daily.data.repository.IWeatherInfoLocationRepository;
import com.eager.ieu.weatherinfo.daily.data.repository.IWeatherInfoRegionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WeatherInfoDailyDataHelper {
    private final IWeatherInfoLocationRepository m_weatherInfoLocationRepository;

    private final IPlaceInfoRegionRepository m_placeInfoRegionRepository;

    private final IPlaceInfoLocationRepository m_placeInfoLocationRepository;

    private final IWeatherInfoRegionRepository m_weatherInfoRegionRepository;

    public WeatherInfoDailyDataHelper(IWeatherInfoLocationRepository weatherInfoLocationRepository,
                                      IPlaceInfoRegionRepository placeInfoRegionRepository,
                                      IPlaceInfoLocationRepository placeInfoLocationRepository,
                                      IWeatherInfoRegionRepository weatherInfoRegionRepository)
    {
        m_weatherInfoLocationRepository = weatherInfoLocationRepository;
        m_placeInfoRegionRepository = placeInfoRegionRepository;
        m_placeInfoLocationRepository = placeInfoLocationRepository;
        m_weatherInfoRegionRepository = weatherInfoRegionRepository;
    }

    public PlaceInfoRegion savePlaceInfoRegion(PlaceInfoRegion placeInfoRegion)
    {
        return m_placeInfoRegionRepository.save(placeInfoRegion);
    }

    public PlaceInfoLocation savePlaceInfoLocation(PlaceInfoLocation placeInfoLocation)
    {
        return m_placeInfoLocationRepository.save(placeInfoLocation);
    }

    public WeatherInfoRegion saveWeatherInfoRegion(WeatherInfoRegion weatherInfoRegion)
    {
        return m_weatherInfoRegionRepository.save(weatherInfoRegion);
    }

    public WeatherInfoLocation saveWeatherInfoLocation(WeatherInfoLocation weatherInfoLocation)
    {
        return m_weatherInfoLocationRepository.save(weatherInfoLocation);
    }

    public Optional<PlaceInfoLocation> findPlaceInfoLocationByPlaceName(String placeName)
    {
        return m_placeInfoLocationRepository.findById(placeName);
    }

    public Optional<PlaceInfoLocation> findPlaceInfoLocationByCoordinate(double latitude, double longitude)
    {
        return m_placeInfoLocationRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

    public Optional<WeatherInfoLocation> findWeatherInfoLocationById(long id)
    {
        return m_weatherInfoLocationRepository.findById(id);
    }

    public Optional<WeatherInfoLocation> findWeatherInfoLocationByCoordinate(double latitude, double longitude)
    {
        return m_weatherInfoLocationRepository.findByLatAndLng(latitude, longitude);
    }

    public Optional<WeatherInfoLocation> findWeatherInfoLocationByPlaceName(String placeName)
    {
        return m_weatherInfoLocationRepository.findByPlaceName(placeName);
    }

    public Optional<PlaceInfoRegion> findPlaceInfoRegionByRegion(String region)
    {
        return m_placeInfoRegionRepository.findById(region);
    }

    public Optional<PlaceInfoRegion> findPlaceInfoRegionByRegionCoordinate(double east, double west,
                                                                           double north, double south)
    {
        return m_placeInfoRegionRepository.findByEastAndWestAndNorthAndSouth(east, west, north, south);
    }


    public Optional<WeatherInfoRegion> findWeatherInfoRegionById(long id)
    {
        return m_weatherInfoRegionRepository.findById(id);
    }

    public Iterable<WeatherInfoRegion> findWeatherInfoRegionByRegion(String region)
    {
        return m_weatherInfoRegionRepository.findWeatherInfoRegionByRegion(region);
    }


    //...
}
