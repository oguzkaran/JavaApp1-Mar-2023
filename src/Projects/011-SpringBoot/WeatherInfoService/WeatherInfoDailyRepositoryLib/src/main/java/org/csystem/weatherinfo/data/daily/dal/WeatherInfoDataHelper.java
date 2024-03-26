package org.csystem.weatherinfo.data.daily.dal;

import org.csystem.weatherinfo.data.daily.repository.IPlaceInfoByLocationRepository;
import org.csystem.weatherinfo.data.daily.repository.IPlaceInfoRegionRepository;
import org.csystem.weatherinfo.data.daily.repository.IWeatherInfoLocationRepository;
import org.csystem.weatherinfo.data.daily.repository.IWeatherInfoRegionRepository;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoDataHelper {
    private final IWeatherInfoLocationRepository m_weatherInfoLocationRepository;

    private final IPlaceInfoRegionRepository m_placeInfoRegionRepository;

    private final IPlaceInfoByLocationRepository m_placeInfoByLocationRepository;

    private final IWeatherInfoRegionRepository m_weatherInfoRegionRepository;

    public WeatherInfoDataHelper(IWeatherInfoLocationRepository weatherInfoLocationRepository,
                                 IPlaceInfoRegionRepository placeInfoRegionRepository,
                                 IPlaceInfoByLocationRepository placeInfoByLocationRepository,
                                 IWeatherInfoRegionRepository weatherInfoRegionRepository)
    {
        m_weatherInfoLocationRepository = weatherInfoLocationRepository;
        m_placeInfoRegionRepository = placeInfoRegionRepository;
        m_placeInfoByLocationRepository = placeInfoByLocationRepository;
        m_weatherInfoRegionRepository = weatherInfoRegionRepository;
    }

    //...
}
