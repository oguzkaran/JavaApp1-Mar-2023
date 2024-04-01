package com.eager.ieu.weatherinfo.backup.data.repository;

import com.eager.ieu.weatherinfo.backup.data.entity.WeatherInfoLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherInfoLocationRepository extends CrudRepository<WeatherInfoLocation, Long> {
}
