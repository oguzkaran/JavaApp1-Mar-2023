package com.sunny.app.weatherinfo.daily.service;

import com.eager.ieu.weatherinfo.daily.data.dal.WeatherInfoDailyDataHelper;
import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoLocation;
import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoRegion;
import com.karandev.util.data.service.DataServiceException;
import com.sunny.app.weatherinfo.daily.service.dto.*;
import com.sunny.app.weatherinfo.daily.service.mapper.IWeatherInfoDailyMapper;
import com.sunny.app.weatherinfo.geonames.GeoWeatherInfoSearchHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class WeatherInfoDailyService {
    private final WeatherInfoDailyDataHelper m_weatherInfoDailyDataHelper;
    private final IWeatherInfoDailyMapper m_weatherInfoDailyMapper;
    private final GeoWeatherInfoSearchHelper m_geoWeatherInfoSearchHelper;

    public WeatherInfoDailyService(WeatherInfoDailyDataHelper weatherInfoDailyDataHelper,
                                   IWeatherInfoDailyMapper weatherInfoDailyMapper,
                                   GeoWeatherInfoSearchHelper geoWeatherInfoSearchHelper)
    {
        m_weatherInfoDailyDataHelper = weatherInfoDailyDataHelper;
        m_weatherInfoDailyMapper = weatherInfoDailyMapper;
        m_geoWeatherInfoSearchHelper = geoWeatherInfoSearchHelper;
    }

    private void collectWeatherInfoLocationWeatherDataCallback(PlaceInfoLocation placeInfoLocation)
    {
        var geoWeatherLocationInfoOpt = m_geoWeatherInfoSearchHelper
                .findWeatherLocationInfo(placeInfoLocation.latitude, placeInfoLocation.longitude);

        geoWeatherLocationInfoOpt.ifPresent(geoWeatherLocationInfo -> {
            var wil = m_weatherInfoDailyMapper.toWeatherInfoLocationSaveDTO(geoWeatherLocationInfo);

            wil.setPlaceInfoLocation(placeInfoLocation);
            saveWeatherInfoLocation(wil, m_weatherInfoDailyMapper.toPlaceInfoLocationDTO(placeInfoLocation));
        });
    }

    private void collectPlaceInfoRegionWeatherDataCallback(PlaceInfoRegion placeInfoRegion) {
        var geoWeatherRegionList = m_geoWeatherInfoSearchHelper.findWeatherRegionInfo(
                placeInfoRegion.north, placeInfoRegion.south, placeInfoRegion.east, placeInfoRegion.west);

        StreamSupport.stream(geoWeatherRegionList.spliterator(), false).forEach(
                geoWeatherRegionInfo -> {
                    var wir = m_weatherInfoDailyMapper.toWeatherInfoRegionSaveDTO(geoWeatherRegionInfo);
                    wir.setPlaceInfoRegion(placeInfoRegion);
                    saveWeatherInfoRegion(wir, m_weatherInfoDailyMapper.toPlaceInfoRegionDTO(placeInfoRegion));
                });
    }
    public void deleteAllPlaceInfoLocation()
    {
        try {
            m_weatherInfoDailyDataHelper.deleteAllPlaceInfoLocation();
            log.info("deleteAllPlaceInfoLocation succeeded");
        }
        catch (Throwable ex) {
            log.error("error occurred in deleteAllPlaceInfoLocation:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.deleteAllPlaceInfoLocation", ex);
        }
    }

    public Iterable<PlaceInfoLocationDTO> findAllPlaceInfoLocation()
    {
        try {
            return m_weatherInfoDailyMapper.toIterablePlaceInfoLocationDTO(m_weatherInfoDailyDataHelper.findAllPlaceInfoLocation());
        }
        catch (Throwable ex) {
            log.error("error occurred in findAllPlaceInfoLocation:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
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
            log.error("error occurred in findPlaceInfoLocation:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.findPlaceInfoLocation", ex);
        }
    }

    public void savePlaceInfoLocation(PlaceInfoLocationDTO placeInfoLocationDTO)
    {
        try {
            m_weatherInfoDailyDataHelper.savePlaceInfoLocation(m_weatherInfoDailyMapper.toPlaceInfoLocation(placeInfoLocationDTO));
            log.info("PlaceInfoLocation: {} saved successfully", placeInfoLocationDTO.toString());
        }
        catch (Throwable ex) {
            log.error("error occurred in savePlaceInfoLocation:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.savePlaceInfoLocation", ex);
        }
    }

    public void deleteAllPlaceInfoRegion()
    {
        try {
            m_weatherInfoDailyDataHelper.deleteAllPlaceInfoRegion();
            log.info("deleteAllPlaceInfoRegion succeeded");
        }
        catch (Throwable ex) {
            log.error("error occurred in deleteAllPlaceInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.deleteAllPlaceInfoRegion", ex);
        }
    }

    public Iterable<PlaceInfoRegionDTO> findAllPlaceInfoRegion()
    {
        try {
            return m_weatherInfoDailyMapper.toIterablePlaceInfoRegionDTO(m_weatherInfoDailyDataHelper.findAllPlaceInfoRegion());
        }
        catch (Throwable ex) {
            log.error("error occurred in findAllPlaceInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
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
            log.error("error occurred in findPlaceInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.findPlaceInfoRegion", ex);
        }
    }

    public boolean savePlaceInfoRegion(PlaceInfoRegionDTO placeInfoRegionDTO)
    {
        try {
            return m_weatherInfoDailyDataHelper.savePlaceInfoRegion(m_weatherInfoDailyMapper.toPlaceInfoRegion(placeInfoRegionDTO));

        }
        catch (Throwable ex) {
            log.error("error occurred in savePlaceInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.savePlaceInfoRegion", ex);
        }
    }

    public boolean updatePlaceInfoRegion(PlaceInfoRegionDTO placeInfoRegionDTO)
    {
        try {
            return m_weatherInfoDailyDataHelper.updatePlaceInfoRegion(m_weatherInfoDailyMapper.toPlaceInfoRegion(placeInfoRegionDTO));
        }
        catch (Throwable ex) {
            log.error("error occurred in updatePlaceInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.updatePlaceInfoRegion", ex);
        }
    }

    public void deleteAllWeatherInfoLocation()
    {
        try {
            m_weatherInfoDailyDataHelper.deleteAllWeatherInfoLocation();
            log.info("deleteAllWeatherInfoLocation succeeded");
        }
        catch (Throwable ex) {
            log.error("error occurred in deleteAllWeatherInfoLocation:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.deleteAllWeatherInfoLocation", ex);
        }
    }

    public Iterable<WeatherInfoLocationDTO> findAllWeatherInfoLocation()
    {
        try {
            return m_weatherInfoDailyMapper.toIterableWeatherInfoLocationDTO(m_weatherInfoDailyDataHelper.findAllWeatherInfoLocation());
        }
        catch (Throwable ex) {
            log.error("error occurred in findAllWeatherInfoLocation:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
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
            log.error("error occurred in findWeatherInfoLocation:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
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

            log.info("WeatherInfoLocation: {} saved successfully", weatherInfoLocationSaveDTO.toString());
        }
        catch (Throwable ex) {
            log.error("error occurred in saveWeatherInfoLocation:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.saveWeatherInfoLocation", ex);
        }
    }

    public void deleteAllWeatherInfoRegion()
    {
        try {
            m_weatherInfoDailyDataHelper.deleteAllWeatherInfoRegion();
            log.info("deleteAllWeatherInfoRegion succeeded");
        }
        catch (Throwable ex) {
            log.error("error occurred in deleteAllWeatherInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.deleteAllWeatherInfoRegion", ex);
        }
    }

    public Iterable<WeatherInfoRegionDTO> findAllWeatherInfoRegion()
    {
        try {
            return m_weatherInfoDailyMapper.toIterableWeatherInfoRegionDTO(m_weatherInfoDailyDataHelper.findAllWeatherInfoRegion());
        }
        catch (Throwable ex) {
            log.error("error occurred in findAllWeatherInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.findAllWeatherInfoRegion", ex);
        }
    }

    public Iterable<WeatherInfoRegionDTO> findWeatherInfoRegion(String region)
    {
        try {
            return m_weatherInfoDailyMapper.toIterableWeatherInfoRegionDTO(m_weatherInfoDailyDataHelper.findWeatherInfoRegionByRegion(region));
        }
        catch (Throwable ex) {
            log.error("error occurred in findWeatherInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
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
            log.info("WeatherInfoRegion: {} saved successfully", weatherInfoRegionSaveDTO.toString());
        }
        catch (Throwable ex) {
            log.error("error occurred in saveWeatherInfoRegion:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.saveWeatherInfoRegion", ex);
        }
    }

    @Transactional
    public void collectPlaceInfoLocationWeatherData()
    {
        try {
            m_weatherInfoDailyDataHelper.findAllPlaceInfoLocation()
                    .forEach(this::collectWeatherInfoLocationWeatherDataCallback);
        }
        catch (Throwable ex) {
            log.error("error occurred in collectPlaceInfoLocationWeatherData:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.collectPlaceInfoLocationWeatherData", ex);
        }
    }

    @Transactional
    public void collectPlaceInfoRegionWeatherData()
    {
        try {
            m_weatherInfoDailyDataHelper.findAllPlaceInfoRegion()
                    .forEach(this::collectPlaceInfoRegionWeatherDataCallback);

        }
        catch (Throwable ex) {
            log.error("error occurred in collectPlaceInfoRegionWeatherData:Exception:{}, Message:{}",
                    ex.getClass().getName(), ex.getMessage());
            throw new DataServiceException("WeatherInfoDailyService.collectPlaceInfoRegionWeatherData", ex);
        }
    }

    @Transactional
    public void backupPlaceInfoLocationWeatherData()
    {
        throw new UnsupportedOperationException("Not yet implemented. Will be implemented by Oğuz Karan");
    }

    @Transactional
    public void backupPlaceInfoRegionWeatherData()
    {
        throw new UnsupportedOperationException("Not yet implemented. Will be implemented by Oğuz Karan");
    }
}


