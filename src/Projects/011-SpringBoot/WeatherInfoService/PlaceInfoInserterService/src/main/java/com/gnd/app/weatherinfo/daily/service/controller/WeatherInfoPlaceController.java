package com.gnd.app.weatherinfo.daily.service.controller;

import com.karandev.util.data.service.DataServiceException;
import com.sunny.app.weatherinfo.daily.service.WeatherInfoDailyService;
import com.sunny.app.weatherinfo.daily.service.dto.PlaceInfoRegionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather/places")
public class WeatherInfoPlaceController {
    private final WeatherInfoDailyService m_weatherInfoDailyService;

    public WeatherInfoPlaceController(WeatherInfoDailyService weatherInfoDailyService)
    {
        m_weatherInfoDailyService = weatherInfoDailyService;
    }

    @PostMapping("/region/save")
    public ResponseEntity<PlaceInfoRegionDTO> savePlaceInfoRegion(@RequestBody PlaceInfoRegionDTO placeInfoRegionDTO)
    {
        ResponseEntity<PlaceInfoRegionDTO> result;

        try {
            result = m_weatherInfoDailyService.savePlaceInfoRegion(placeInfoRegionDTO)
                    ? ResponseEntity.ok(placeInfoRegionDTO) : ResponseEntity.badRequest().build();
        }
        catch (DataServiceException ex) {
            result = ResponseEntity.internalServerError().build();
        }

        return result;
    }

    @PostMapping("/region/update")
    public ResponseEntity<PlaceInfoRegionDTO> updatePlaceInfoRegion(@RequestBody PlaceInfoRegionDTO placeInfoRegionDTO)
    {
        ResponseEntity<PlaceInfoRegionDTO> result;

        try {
            result = m_weatherInfoDailyService.updatePlaceInfoRegion(placeInfoRegionDTO)
                    ? ResponseEntity.ok(placeInfoRegionDTO) : ResponseEntity.badRequest().build();
        }
        catch (DataServiceException ex) {
            result = ResponseEntity.internalServerError().build();
        }

        return result;
    }
}
