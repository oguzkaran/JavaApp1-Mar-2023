package com.gnd.app.weatherinfo.daily.service.controller;

import com.sunny.app.weatherinfo.daily.service.WeatherInfoDailyService;
import com.sunny.app.weatherinfo.daily.service.dto.PlaceInfoLocationSaveDTO;
import com.sunny.app.weatherinfo.daily.service.dto.PlaceInfoRegionSaveDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
public class WeatherServiceController
{
    private final WeatherInfoDailyService m_weatherInfoDailyService;

    public WeatherServiceController (WeatherInfoDailyService weatherInfoDailyService) {
        m_weatherInfoDailyService = weatherInfoDailyService;
    }

    @PostMapping("/save/location")
    public PlaceInfoLocationSaveDTO savePlaceInfoLocation (@RequestBody PlaceInfoLocationSaveDTO placeInfoLocationSaveDTO)
    {
        m_weatherInfoDailyService.savePlaceInfoLocation(placeInfoLocationSaveDTO);
        return placeInfoLocationSaveDTO;
    }

    @PostMapping("/save/region")
    public PlaceInfoRegionSaveDTO savePlaceInfoRegion (@RequestBody PlaceInfoRegionSaveDTO placeInfoRegionSaveDTO)
    {
        m_weatherInfoDailyService.savePlaceInfoRegion(placeInfoRegionSaveDTO);
        return placeInfoRegionSaveDTO;
    }
}
