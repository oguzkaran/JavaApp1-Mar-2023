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

    public Iterable<PlaceInfoLocation> findAllPlaceInfoLocation()
    {
        return m_placeInfoLocationRepository.findAll();
    }

    public Iterable<PlaceInfoLocation> findAllPlaceInfoLocationById(Iterable<String> placeNames)
    {
        return m_placeInfoLocationRepository.findAllById(placeNames);
    }

    public Iterable<PlaceInfoRegion> findAllPlaceInfoRegion()
    {
        return m_placeInfoRegionRepository.findAll();
    }

    public Iterable<PlaceInfoRegion> findAllPlaceInfoRegionById(Iterable<String> regions)
    {
        return m_placeInfoRegionRepository.findAllById(regions);
    }

    public Iterable<WeatherInfoLocation> findAllWeatherInfoLocation()
    {
        return m_weatherInfoLocationRepository.findAll();
    }

    public Iterable<WeatherInfoLocation> findAllWeatherInfoLocationById(Iterable<Long> ids)
    {
        return m_weatherInfoLocationRepository.findAllById(ids);
    }

    public Iterable<WeatherInfoRegion> findAllWeatherInfoRegion()
    {
        return m_weatherInfoRegionRepository.findAll();
    }

    public Iterable<WeatherInfoRegion> findAllWeatherInfoRegionById(Iterable<Long> ids)
    {
        return m_weatherInfoRegionRepository.findAllById(ids);
    }

    public Iterable<PlaceInfoLocation> saveAllPlaceInfoLocation(Iterable<PlaceInfoLocation>  placeInfoLocations)
    {
        return m_placeInfoLocationRepository.saveAll(placeInfoLocations);
    }

    public Iterable<PlaceInfoRegion> saveAllPlaceInfoRegion(Iterable<PlaceInfoRegion>  placeInfoRegions)
    {
        return m_placeInfoRegionRepository.saveAll(placeInfoRegions);
    }

    public Iterable<WeatherInfoLocation> saveAllWeatherInfoLocation(Iterable<WeatherInfoLocation>  weatherInfoLocations)
    {
        return m_weatherInfoLocationRepository.saveAll(weatherInfoLocations);
    }

    public Iterable<WeatherInfoRegion> saveAllWeatherInfoRegion(Iterable<WeatherInfoRegion>  weatherInfoRegions)
    {
        return m_weatherInfoRegionRepository.saveAll(weatherInfoRegions);
    }

    public void deleteAllPlaceInfoLocation()
    {
        m_placeInfoLocationRepository.deleteAll();
    }

    public void deletePlaceInfoLocation(PlaceInfoLocation placeInfoLocation)
    {
        m_placeInfoLocationRepository.delete(placeInfoLocation);
    }

    public void deleteAllPlaceInfoLocation(Iterable<PlaceInfoLocation> placeInfoLocations)
    {
        m_placeInfoLocationRepository.deleteAll(placeInfoLocations);
    }

    public void deleteAllByIdPlaceInfoLocation(Iterable<String> ids)
    {
        m_placeInfoLocationRepository.deleteAllById(ids);
    }

    public void deleteByIdPlaceInfoLocation(String id)
    {
        m_placeInfoLocationRepository.deleteById(id);
    }

    public void deleteAllPlaceInfoRegion()
    {
        m_placeInfoRegionRepository.deleteAll();
    }

    public void deletePlaceInfoRegion(PlaceInfoRegion placeInfoRegion)
    {
        m_placeInfoRegionRepository.delete(placeInfoRegion);
    }

    public void deleteAllPlaceInfoRegion(Iterable<PlaceInfoRegion> placeInfoRegions)
    {
        m_placeInfoRegionRepository.deleteAll(placeInfoRegions);
    }

    public void deleteAllByIdPlaceInfoRegion(Iterable<String> ids)
    {
        m_placeInfoRegionRepository.deleteAllById(ids);
    }

    public void deleteByIdPlaceInfoRegion(String id)
    {
        m_placeInfoRegionRepository.deleteById(id);
    }

    public void deleteAllWeatherInfoLocation()
    {
        m_weatherInfoLocationRepository.deleteAll();
    }

    public void deleteWeatherInfoLocation(WeatherInfoLocation weatherInfoLocation)
    {
        m_weatherInfoLocationRepository.delete(weatherInfoLocation);
    }

    public void deleteAllWeatherInfoLocation(Iterable<WeatherInfoLocation> weatherInfoLocations)
    {
        m_weatherInfoLocationRepository.deleteAll(weatherInfoLocations);
    }

    public void deleteAllByIdWeatherInfoLocation(Iterable<Long> ids)
    {
        m_weatherInfoLocationRepository.deleteAllById(ids);
    }

    public void deleteByIdWeatherInfoLocation(Long id)
    {
        m_weatherInfoLocationRepository.deleteById(id);
    }

    public void deleteAllWeatherInfoRegion()
    {
        m_weatherInfoRegionRepository.deleteAll();
    }

    public void deleteWeatherInfoRegion(WeatherInfoRegion weatherInfoRegion)
    {
        m_weatherInfoRegionRepository.delete(weatherInfoRegion);
    }

    public void deleteAllWeatherInfoRegion(Iterable<WeatherInfoRegion> weatherInfoRegions)
    {
        m_weatherInfoRegionRepository.deleteAll(weatherInfoRegions);
    }

    public void deleteAllByIdWeatherInfoRegion(Iterable<Long> ids)
    {
        m_weatherInfoRegionRepository.deleteAllById(ids);
    }

    public void deleteByIdWeatherInfoRegion(Long id)
    {
        m_weatherInfoRegionRepository.deleteById(id);
    }

}
