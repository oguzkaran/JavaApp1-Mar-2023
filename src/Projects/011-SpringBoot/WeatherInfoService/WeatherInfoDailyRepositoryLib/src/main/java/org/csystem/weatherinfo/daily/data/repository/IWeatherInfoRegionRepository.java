package org.csystem.weatherinfo.daily.data.repository;

import org.csystem.weatherinfo.daily.data.entity.WeatherInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherInfoRegionRepository extends CrudRepository<WeatherInfoRegion, Long> {
}
