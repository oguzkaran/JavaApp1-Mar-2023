package com.sunny.app.weatherinfo.daily.service;

import com.eager.ieu.weatherinfo.daily.data.dal.WeatherInfoDailyDataHelper;
import com.eager.ieu.weatherinfo.daily.data.entity.*;
import com.karandev.util.data.service.DataServiceException;
import com.sunny.app.weatherinfo.daily.service.dto.*;
import com.sunny.app.weatherinfo.daily.service.mapper.IWeatherInfoDailyMapper;
import com.sunny.app.weatherinfo.geonames.GeoWeatherInfoSearchHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WeatherInfoDailyService {
    private final WeatherInfoDailyDataHelper m_weatherInfoDailyDataHelper;
    private final GeoWeatherInfoSearchHelper m_geoWeatherInfoSearchHelper;
    private final IWeatherInfoDailyMapper m_weatherInfoDailyMapper;

    public WeatherInfoDailyService(WeatherInfoDailyDataHelper weatherInfoDailyDataHelper,
                                   GeoWeatherInfoSearchHelper geoWeatherInfoSearchHelper,
                                   IWeatherInfoDailyMapper weatherInfoDailyMapper)
    {
        m_weatherInfoDailyDataHelper = weatherInfoDailyDataHelper;
        m_geoWeatherInfoSearchHelper = geoWeatherInfoSearchHelper;
        m_weatherInfoDailyMapper = weatherInfoDailyMapper;
    }

    public Optional<PlaceInfoLocationSaveDTO> findPlaceInfoLocation(String placeName)
    {
        try {
            return m_weatherInfoDailyDataHelper.findPlaceInfoLocationByPlaceName(placeName)
                    .map(m_weatherInfoDailyMapper::toPlaceInfoLocationSaveDTO);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findPlaceInfoLocation", ex);
        }
    }

    public void savePlaceInfoLocation(PlaceInfoLocationSaveDTO placeInfoLocationSaveDTO)
    {
        try {
            m_weatherInfoDailyDataHelper.savePlaceInfoLocation(m_weatherInfoDailyMapper.toPlaceInfoLocation(placeInfoLocationSaveDTO));
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.savePlaceInfoLocation", ex);
        }
    }

    public Optional<PlaceInfoRegionSaveDTO> findPlaceInfoRegion(String region)
    {
        try {
            return m_weatherInfoDailyDataHelper.findPlaceInfoRegionByRegion(region)
                    .map(m_weatherInfoDailyMapper::toPlaceInfoRegionSaveDTO);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findPlaceInfoRegion", ex);
        }
    }

    public void savePlaceInfoRegion(PlaceInfoRegionSaveDTO placeInfoRegionSaveDTO)
    {
        try {
            m_weatherInfoDailyDataHelper.savePlaceInfoRegion(m_weatherInfoDailyMapper.toPlaceInfoRegion(placeInfoRegionSaveDTO));
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.savePlaceInfoRegion", ex);
        }
    }

    public Optional<WeatherLocationInfoDTO> findWeatherLocationInfo(String placeName)
    {
        try {
            var pilOpt = m_weatherInfoDailyDataHelper.findPlaceInfoLocationByPlaceName(placeName);
            var wliDTOOpt = pilOpt.flatMap(pil -> findWeatherLocationInfo(pil.latitude, pil.longitude));

            if(wliDTOOpt.isPresent()) {
                var wliDTO = wliDTOOpt.get();
                saveWeatherInfoLocation(wliDTO, pilOpt.get());
            }

            return wliDTOOpt;
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherLocationInfo", ex);
        }
    }

    private Optional<WeatherLocationInfoDTO> findWeatherLocationInfo(double latitude, double longitude)
    {
        try {
            return m_geoWeatherInfoSearchHelper.findWeatherLocationInfo(latitude, longitude)
                    .map(m_weatherInfoDailyMapper::toWeatherLocationInfoDTO);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherLocationInfo", ex);
        }
    }

    private void saveWeatherInfoLocation(WeatherLocationInfoDTO weatherLocationInfoDTO,
                                         PlaceInfoLocation placeInfoLocation)
    {
        try {
            var wil = m_weatherInfoDailyMapper.toWeatherInfoLocation(weatherLocationInfoDTO);
            wil.placeInfoLocation = placeInfoLocation;
            m_weatherInfoDailyDataHelper.saveWeatherInfoLocation(wil);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.saveWeatherInfoLocation", ex);
        }
    }

    public Optional<WeatherRegionDTO> findWeatherRegion(String region)
    {
        try {
            return findWeatherRegion(region, 10);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherRegion", ex);
        }
    }

    public Optional<WeatherRegionDTO> findWeatherRegion(String region, int maxRows)
    {
        try {
            var pirOpt = m_weatherInfoDailyDataHelper.findPlaceInfoRegionByRegion(region);
            var wrDtoOpt = pirOpt.flatMap(pir -> findWeatherRegion(pir.north, pir.south, pir.east, pir.west, maxRows));

            wrDtoOpt.ifPresent(wr -> saveWeatherInfoRegion(wr, pirOpt.get()));

            return wrDtoOpt;
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherRegion", ex);
        }
    }

    private Optional<WeatherRegionDTO> findWeatherRegion(double north, double south, double east, double west, int maxRows)
    {
        try {
            return m_geoWeatherInfoSearchHelper.findWeatherRegion(north, south, east, west, maxRows)
                    .map(gwr -> {
                        var wrDTO = new WeatherRegionDTO();
                        wrDTO.geoWeatherObservations = m_weatherInfoDailyMapper.toWeatherRegionInfoDTOList(gwr.weatherObservations);
                        return wrDTO;
                    });
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherRegion", ex);
        }
    }

    private void saveWeatherInfoRegion(WeatherRegionDTO weatherRegionDTO,
                                       PlaceInfoRegion placeInfoRegion)
    {
        try {
            weatherRegionDTO.geoWeatherObservations
                .stream().map(m_weatherInfoDailyMapper::toWeatherInfoRegion)
                .peek(wir -> wir.placeInfoRegion = placeInfoRegion)
                .forEach(m_weatherInfoDailyDataHelper::saveWeatherInfoRegion);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.saveWeatherInfoRegion", ex);
        }
    }

    public Optional<WeatherLocationInfoDTO> findWeatherLocationFromDB(String placeName)
    {
        try {
            return m_weatherInfoDailyDataHelper.findWeatherInfoLocationByPlaceName(placeName)
                    .map(m_weatherInfoDailyMapper::toWeatherLocationInfoDTO);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherLocationFromDB", ex);
        }
    }

    public Optional<WeatherRegionDTO> findWeatherRegionFromDB(String region)
    {
        try {
             var wirIter = m_weatherInfoDailyDataHelper.findWeatherInfoRegionByRegion(region);

             var wriList = new ArrayList<WeatherRegionInfoDTO>();
             wirIter.forEach(wir -> wriList.add(m_weatherInfoDailyMapper.toWeatherRegionInfoDTO(wir)));

             var wr = new WeatherRegionDTO();
             wr.geoWeatherObservations = wriList;

             return Optional.of(wr);
        }
        catch (Throwable ex) {
            throw new DataServiceException("WeatherInfoDailyService.findWeatherRegionFromDB", ex);
        }
    }
}
