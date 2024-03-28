package org.csystem.weatherinfo.backup.data.dal;

import org.csystem.weatherinfo.backup.data.entity.WeatherInfoRegion;
import org.csystem.weatherinfo.backup.data.repository.IPlaceInfoByLocationRepository;
import org.csystem.weatherinfo.backup.data.repository.IPlaceInfoRegionRepository;
import org.csystem.weatherinfo.backup.data.repository.IWeatherInfoLocationRepository;
import org.csystem.weatherinfo.backup.data.repository.IWeatherInfoRegionRepository;
import org.csystem.weatherinfo.backup.data.entity.PlaceInfoByLocation;
import org.csystem.weatherinfo.backup.data.entity.PlaceInfoRegion;
import org.csystem.weatherinfo.backup.data.entity.WeatherInfoLocation;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoBackupDataHelper {
    private final IWeatherInfoLocationRepository m_weatherInfoLocationRepository;

    private final IPlaceInfoRegionRepository m_placeInfoRegionRepository;

    private final IPlaceInfoByLocationRepository m_placeInfoByLocationRepository;

    private final IWeatherInfoRegionRepository m_weatherInfoRegionRepository;

    public WeatherInfoBackupDataHelper(IWeatherInfoLocationRepository weatherInfoLocationRepository,
                                       IPlaceInfoRegionRepository placeInfoRegionRepository,
                                       IPlaceInfoByLocationRepository placeInfoByLocationRepository,
                                       IWeatherInfoRegionRepository weatherInfoRegionRepository)
    {
        m_weatherInfoLocationRepository = weatherInfoLocationRepository;
        m_placeInfoRegionRepository = placeInfoRegionRepository;
        m_placeInfoByLocationRepository = placeInfoByLocationRepository;
        m_weatherInfoRegionRepository = weatherInfoRegionRepository;
    }

    public PlaceInfoRegion save(PlaceInfoRegion placeInfoRegion)
    {
        return m_placeInfoRegionRepository.save(placeInfoRegion);
    }

    public PlaceInfoByLocation save(PlaceInfoByLocation placeInfoByLocation)
    {
        return m_placeInfoByLocationRepository.save(placeInfoByLocation);
    }

    public WeatherInfoRegion save(WeatherInfoRegion weatherInfoRegion)
    {
            return m_weatherInfoRegionRepository.save(weatherInfoRegion);
    }

    public WeatherInfoLocation save(WeatherInfoLocation weatherInfoLocation)
    {
        return m_weatherInfoLocationRepository.save(weatherInfoLocation);
    }


    //...
}
