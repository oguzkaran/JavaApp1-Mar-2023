package com.eager.ieu.weatherinfo.daily.data.dal;

import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoLocation;
import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoRegion;
import com.eager.ieu.weatherinfo.daily.data.repository.IPlaceInfoLocationRepository;
import com.eager.ieu.weatherinfo.daily.data.repository.IPlaceInfoRegionRepository;
import com.eager.ieu.weatherinfo.daily.data.repository.IWeatherInfoLocationRepository;
import com.eager.ieu.weatherinfo.daily.data.repository.IWeatherInfoRegionRepository;
import com.eager.ieu.weatherinfo.daily.data.entity.WeatherInfoLocation;
import com.eager.ieu.weatherinfo.daily.data.entity.WeatherInfoRegion;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoDailyDataHelper {
    private final IWeatherInfoLocationRepository m_weatherInfoLocationRepository;

    private final IPlaceInfoRegionRepository m_placeInfoRegionRepository;

    private final IPlaceInfoLocationRepository m_placeInfoByLocationRepository;

    private final IWeatherInfoRegionRepository m_weatherInfoRegionRepository;

    public WeatherInfoDailyDataHelper(IWeatherInfoLocationRepository weatherInfoLocationRepository,
                                      IPlaceInfoRegionRepository placeInfoRegionRepository,
                                      IPlaceInfoLocationRepository placeInfoByLocationRepository,
                                      IWeatherInfoRegionRepository weatherInfoRegionRepository)
    {
        m_weatherInfoLocationRepository = weatherInfoLocationRepository;
        m_placeInfoRegionRepository = placeInfoRegionRepository;
        m_placeInfoByLocationRepository = placeInfoByLocationRepository;
        m_weatherInfoRegionRepository = weatherInfoRegionRepository;
    }

    public PlaceInfoRegion savePlaceInfoRegion(PlaceInfoRegion placeInfoRegion)
    {
        return m_placeInfoRegionRepository.save(placeInfoRegion);
    }

    public PlaceInfoLocation savePlaceInfoLocation(PlaceInfoLocation placeInfoLocation)
    {
        return m_placeInfoByLocationRepository.save(placeInfoLocation);
    }

    public WeatherInfoRegion saveWeatherInfoRegion(WeatherInfoRegion weatherInfoRegion)
    {
        return m_weatherInfoRegionRepository.save(weatherInfoRegion);
    }

    public WeatherInfoLocation saveWeatherInfoLocation(WeatherInfoLocation weatherInfoLocation)
    {
        return m_weatherInfoLocationRepository.save(weatherInfoLocation);
    }

    //...
}
