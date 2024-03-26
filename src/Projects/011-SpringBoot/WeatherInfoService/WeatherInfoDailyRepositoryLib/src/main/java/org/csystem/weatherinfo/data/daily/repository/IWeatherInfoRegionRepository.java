package org.csystem.weatherinfo.data.daily.repository;

import org.csystem.weatherinfo.data.daily.entity.WeatherInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherInfoRegionRepository extends CrudRepository<WeatherInfoRegion, Long> {
}
