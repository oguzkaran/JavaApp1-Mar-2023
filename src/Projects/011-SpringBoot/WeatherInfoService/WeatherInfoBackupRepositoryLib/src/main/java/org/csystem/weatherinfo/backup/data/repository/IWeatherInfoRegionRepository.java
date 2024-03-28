package org.csystem.weatherinfo.backup.data.repository;

import org.csystem.weatherinfo.backup.data.entity.WeatherInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherInfoRegionRepository extends CrudRepository<WeatherInfoRegion, Long> {
}
