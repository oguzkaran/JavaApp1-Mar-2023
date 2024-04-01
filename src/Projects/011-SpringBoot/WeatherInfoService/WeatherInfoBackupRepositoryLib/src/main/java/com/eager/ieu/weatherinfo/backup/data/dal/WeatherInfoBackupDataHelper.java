package com.eager.ieu.weatherinfo.backup.data.dal;

import com.eager.ieu.weatherinfo.backup.data.entity.PlaceInfoLocation;
import com.eager.ieu.weatherinfo.backup.data.entity.PlaceInfoRegion;
import com.eager.ieu.weatherinfo.backup.data.entity.WeatherInfoLocation;
import com.eager.ieu.weatherinfo.backup.data.entity.WeatherInfoRegion;
import com.eager.ieu.weatherinfo.backup.data.repository.IPlaceInfoLocationRepository;
import com.eager.ieu.weatherinfo.backup.data.repository.IPlaceInfoRegionRepository;
import com.eager.ieu.weatherinfo.backup.data.repository.IWeatherInfoLocationRepository;
import com.eager.ieu.weatherinfo.backup.data.repository.IWeatherInfoRegionRepository;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoBackupDataHelper {
    private final IWeatherInfoLocationRepository m_weatherInfoLocationRepository;

    private final IPlaceInfoRegionRepository m_placeInfoRegionRepository;

    private final IPlaceInfoLocationRepository m_placeInfoByLocationRepository;

    private final IWeatherInfoRegionRepository m_weatherInfoRegionRepository;

    public WeatherInfoBackupDataHelper(IWeatherInfoLocationRepository weatherInfoLocationRepository,
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
