package com.sunny.app.weatherinfo.daily.service.mapper;

import com.eager.ieu.weatherinfo.daily.data.entity.*;
import com.sunny.app.weatherinfo.daily.service.dto.*;
import com.sunny.app.weatherinfo.geonames.dto.GeoWeatherLocationInfo;
import com.sunny.app.weatherinfo.geonames.dto.GeoWeatherRegionInfo;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(implementationName = "WeatherInfoMapperImpl", componentModel = "spring")
public interface IWeatherInfoDailyMapper {
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    PlaceInfoLocation toPlaceInfoLocation(PlaceInfoLocationSaveDTO placeInfoLocationSaveDTO);

    PlaceInfoLocationSaveDTO toPlaceInfoLocationSaveDTO(PlaceInfoLocation placeInfoLocation);

    PlaceInfoRegion toPlaceInfoRegion(PlaceInfoRegionSaveDTO placeInfoRegionSaveDTO);

    PlaceInfoRegionSaveDTO toPlaceInfoRegionSaveDTO(PlaceInfoRegion placeInfoRegion);

    @Mapping(source = "icao", target = "iCAO")
    @Mapping(source = "dateTime", target = "dateTime", qualifiedByName = "stringToLocalDateTime")
    WeatherInfoLocation toWeatherInfoLocation(WeatherLocationInfoDTO weatherLocationInfoDTO);

    @InheritInverseConfiguration(name = "toWeatherInfoLocation")
    @Mapping(source = "dateTime", target = "dateTime", qualifiedByName = "localDateTimeToString")
    WeatherLocationInfoDTO toWeatherLocationInfoDTO(WeatherInfoLocation weatherInfoLocation);

    @Mapping(source = "icao", target = "iCAO")
    @Mapping(source = "latitude", target = "lat")
    @Mapping(source = "longitude", target = "lng")
    @Mapping(source = "dateTime", target = "dateTime", qualifiedByName = "stringToLocalDateTime")
    WeatherInfoRegion toWeatherInfoRegion(WeatherRegionInfoDTO weatherRegionInfoDTO);

    @InheritInverseConfiguration(name = "toWeatherInfoRegion")
    @Mapping(source = "dateTime", target = "dateTime", qualifiedByName = "localDateTimeToString")
    WeatherRegionInfoDTO toWeatherRegionInfoDTO(WeatherInfoRegion weatherInfoRegion);

    @Mapping(source = "latitude", target = "lat")
    @Mapping(source = "longitude", target = "lng")
    WeatherLocationInfoDTO toWeatherLocationInfoDTO(GeoWeatherLocationInfo geoWeatherInfoLocation);

    List<WeatherRegionInfoDTO> toWeatherRegionInfoDTOList(List<GeoWeatherRegionInfo> geoWeatherInfoRegionList);

    @Named("localDateTimeToString")
    default String localDateTimeToString(LocalDateTime dateTime)
    {
        return dateTime.format(DATE_TIME_FORMATTER);
    }

    @Named("stringToLocalDateTime")
    default LocalDateTime stringToLocalDateTime(String dateTime)
    {
        return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
    }
}
