package org.csystem.weatherinfo.data.backup.repository;

import org.csystem.weatherinfo.data.backup.entity.WeatherInfoLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherInfoLocationRepository extends CrudRepository<WeatherInfoLocation, Long> {
}
