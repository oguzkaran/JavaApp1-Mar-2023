package com.gnd.app.weatherinfo.daily.service.controller;

import com.sunny.app.weatherinfo.daily.service.WeatherInfoDailyService;
import com.sunny.app.weatherinfo.daily.service.dto.PlaceInfoLocationDTO;
import com.sunny.app.weatherinfo.daily.service.dto.PlaceInfoRegionDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
public class WeatherServiceController
{
    private final WeatherInfoDailyService m_weatherInfoDailyService;

    public WeatherServiceController (WeatherInfoDailyService weatherInfoDailyService)
    {
        m_weatherInfoDailyService = weatherInfoDailyService;
    }

    @PostMapping("/save/location")
    public PlaceInfoLocationDTO savePlaceInfoLocation (@RequestBody PlaceInfoLocationDTO placeInfoLocationSaveDTO)
    {
        m_weatherInfoDailyService.savePlaceInfoLocation(placeInfoLocationSaveDTO);

        return placeInfoLocationSaveDTO;
    }

    @PostMapping("/save/region")
    public PlaceInfoRegionDTO savePlaceInfoRegion (@RequestBody PlaceInfoRegionDTO placeInfoRegionSaveDTO)
    {
        m_weatherInfoDailyService.savePlaceInfoRegion(placeInfoRegionSaveDTO);

        return placeInfoRegionSaveDTO;
    }
}
