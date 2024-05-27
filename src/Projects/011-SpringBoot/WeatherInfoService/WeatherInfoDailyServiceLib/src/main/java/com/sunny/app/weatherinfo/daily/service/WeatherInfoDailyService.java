package com.sunny.app.weatherinfo.daily.service;

import com.eager.ieu.weatherinfo.daily.data.dal.WeatherInfoDailyDataHelper;
import com.karandev.util.data.service.DataServiceException;
import com.sunny.app.weatherinfo.daily.service.dto.*;
import com.sunny.app.weatherinfo.daily.service.mapper.IWeatherInfoDailyMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherInfoDailyService {
    private final WeatherInfoDailyDataHelper m_weatherInfoDailyDataHelper;
    private final IWeatherInfoDailyMapper m_weatherInfoDailyMapper;

    public WeatherInfoDailyService(WeatherInfoDailyDataHelper weatherInfoDailyDataHelper,
                                   IWeatherInfoDailyMapper weatherInfoDailyMapper)
    {
        m_weatherInfoDailyDataHelper = weatherInfoDailyDataHelper;
        m_weatherInfoDailyMapper = weatherInfoDailyMapper;
    }

    public void deleteAllPlaceInfoLocation()
    {
        try {
            m_weatherInfoDailyDataHelper.deleteAllPlaceInfoLocation();
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.deleteAllPlaceInfoLocation", ex);
        }
    }

    public Iterable<PlaceInfoLocationDTO> findAllPlaceInfoLocation()
    {
        try {
            return m_weatherInfoDailyMapper.toIterablePlaceInfoLocationDTO(m_weatherInfoDailyDataHelper.findAllPlaceInfoLocation());
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findAllPlaceInfoLocation", ex);
        }
    }

    public Optional<PlaceInfoLocationDTO> findPlaceInfoLocation(String placeName)
    {
        try {
            return m_weatherInfoDailyDataHelper.findPlaceInfoLocationByPlaceName(placeName)
                    .map(m_weatherInfoDailyMapper::toPlaceInfoLocationDTO);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findPlaceInfoLocation", ex);
        }
    }

    public void savePlaceInfoLocation(PlaceInfoLocationDTO placeInfoLocationDTO)
    {
        try {
            m_weatherInfoDailyDataHelper.savePlaceInfoLocation(m_weatherInfoDailyMapper.toPlaceInfoLocation(placeInfoLocationDTO));
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.savePlaceInfoLocation", ex);
        }
    }

    public void deleteAllPlaceInfoRegion()
    {
        try {
            m_weatherInfoDailyDataHelper.deleteAllPlaceInfoRegion();
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.deleteAllPlaceInfoRegion", ex);
        }
    }

    public Iterable<PlaceInfoRegionDTO> findAllPlaceInfoRegion()
    {
        try {
            return m_weatherInfoDailyMapper.toIterablePlaceInfoRegionDTO(m_weatherInfoDailyDataHelper.findAllPlaceInfoRegion());
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findAllPlaceInfoRegion", ex);
        }
    }

    public Optional<PlaceInfoRegionDTO> findPlaceInfoRegion(String region)
    {
        try {
            return m_weatherInfoDailyDataHelper.findPlaceInfoRegionByRegion(region)
                    .map(m_weatherInfoDailyMapper::toPlaceInfoRegionDTO);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findPlaceInfoRegion", ex);
        }
    }

    public boolean savePlaceInfoRegion(PlaceInfoRegionDTO placeInfoRegionDTO)
    {
        try {
            return m_weatherInfoDailyDataHelper.savePlaceInfoRegion(m_weatherInfoDailyMapper.toPlaceInfoRegion(placeInfoRegionDTO));
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.savePlaceInfoRegion", ex);
        }
    }

    public boolean updatePlaceInfoRegion(PlaceInfoRegionDTO placeInfoRegionDTO)
    {
        try {
            return m_weatherInfoDailyDataHelper.updatePlaceInfoRegion(m_weatherInfoDailyMapper.toPlaceInfoRegion(placeInfoRegionDTO));
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.updatePlaceInfoRegion", ex);
        }
    }

    public void deleteAllWeatherInfoLocation()
    {
        try {
            m_weatherInfoDailyDataHelper.deleteAllWeatherInfoLocation();
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.deleteAllWeatherInfoLocation", ex);
        }
    }

    public Iterable<WeatherInfoLocationDTO> findAllWeatherInfoLocation()
    {
        try {
            return m_weatherInfoDailyMapper.toIterableWeatherInfoLocationDTO(m_weatherInfoDailyDataHelper.findAllWeatherInfoLocation());
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findAllWeatherInfoLocation", ex);
        }
    }

    public Optional<WeatherInfoLocationDTO> findWeatherInfoLocation(String placename)
    {
        try {
            return m_weatherInfoDailyDataHelper.findWeatherInfoLocationByPlaceName(placename)
                    .map(m_weatherInfoDailyMapper::toWeatherInfoLocationDTO);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherInfoLocation", ex);
        }
    }

    public void saveWeatherInfoLocation(WeatherInfoLocationSaveDTO weatherInfoLocationSaveDTO,
                                        PlaceInfoLocationDTO placeInfoLocationDTO)
    {
        try {
            var wil = m_weatherInfoDailyMapper.toWeatherInfoLocation(weatherInfoLocationSaveDTO);
            wil.placeInfoLocation = m_weatherInfoDailyMapper.toPlaceInfoLocation(placeInfoLocationDTO);

            m_weatherInfoDailyDataHelper.saveWeatherInfoLocation(wil);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.saveWeatherInfoLocation", ex);
        }
    }

    public void deleteAllWeatherInfoRegion()
    {
        try {
            m_weatherInfoDailyDataHelper.deleteAllWeatherInfoRegion();
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.deleteAllWeatherInfoRegion", ex);
        }
    }

    public Iterable<WeatherInfoRegionDTO> findAllWeatherInfoRegion()
    {
        try {
            return m_weatherInfoDailyMapper.toIterableWeatherInfoRegionDTO(m_weatherInfoDailyDataHelper.findAllWeatherInfoRegion());
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findAllWeatherInfoRegion", ex);
        }
    }

    public Iterable<WeatherInfoRegionDTO> findWeatherInfoRegion(String region)
    {
        try {
            return m_weatherInfoDailyMapper.toIterableWeatherInfoRegionDTO(m_weatherInfoDailyDataHelper.findWeatherInfoRegionByRegion(region));
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherInfoRegion", ex);
        }
    }

    public void saveWeatherInfoRegion(WeatherInfoRegionSaveDTO weatherInfoRegionSaveDTO,
                                      PlaceInfoRegionDTO placeInfoRegionDTO)
    {
        try {
            var wir = m_weatherInfoDailyMapper.toWeatherInfoRegion(weatherInfoRegionSaveDTO);
            wir.placeInfoRegion = m_weatherInfoDailyMapper.toPlaceInfoRegion(placeInfoRegionDTO);

            m_weatherInfoDailyDataHelper.saveWeatherInfoRegion(wir);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.saveWeatherInfoRegion", ex);
        }
    }
}
