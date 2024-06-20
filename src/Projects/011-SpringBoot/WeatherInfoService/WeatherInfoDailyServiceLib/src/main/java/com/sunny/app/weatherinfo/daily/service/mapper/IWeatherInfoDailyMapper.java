package com.sunny.app.weatherinfo.daily.service.mapper;

import com.eager.ieu.weatherinfo.daily.data.entity.*;
import com.sunny.app.weatherinfo.daily.service.dto.*;
import org.mapstruct.*;

@Mapper(implementationName = "WeatherInfoMapperImpl", componentModel = "spring")
public interface IWeatherInfoDailyMapper {
    PlaceInfoLocation toPlaceInfoLocation(PlaceInfoLocationDTO placeInfoLocationDTO);

    PlaceInfoLocationDTO toPlaceInfoLocationDTO(PlaceInfoLocation placeInfoLocation);

    PlaceInfoRegion toPlaceInfoRegion(PlaceInfoRegionDTO placeInfoRegionDTO);

    PlaceInfoRegionDTO toPlaceInfoRegionDTO(PlaceInfoRegion placeInfoRegion);

    Iterable<PlaceInfoLocationDTO> toIterablePlaceInfoLocationDTO(Iterable<PlaceInfoLocation> placeInfoLocationIterable);

    Iterable<PlaceInfoRegionDTO> toIterablePlaceInfoRegionDTO(Iterable<PlaceInfoRegion> placeInfoRegionIterable);

    @Mapping(source = "dateTime", target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    WeatherInfoLocation toWeatherInfoLocation(WeatherInfoLocationSaveDTO weatherInfoLocationSaveDTO);

    @Mapping(source = "dateTime", target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    WeatherInfoLocationDTO toWeatherInfoLocationDTO(WeatherInfoLocation weatherInfoLocation);

    Iterable<WeatherInfoLocationDTO> toIterableWeatherInfoLocationDTO(Iterable<WeatherInfoLocation> weatherInfoLocationIterable);

    @Mapping(source = "dateTime", target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    WeatherInfoRegion toWeatherInfoRegion(WeatherInfoRegionSaveDTO weatherInfoRegionSaveDTO);

    @Mapping(source = "dateTime", target = "dateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    WeatherInfoRegionDTO toWeatherInfoRegionDTO(WeatherInfoRegion weatherInfoRegion);

    Iterable<WeatherInfoRegionDTO> toIterableWeatherInfoRegionDTO(Iterable<WeatherInfoRegion> weatherInfoRegionIterable);
}
