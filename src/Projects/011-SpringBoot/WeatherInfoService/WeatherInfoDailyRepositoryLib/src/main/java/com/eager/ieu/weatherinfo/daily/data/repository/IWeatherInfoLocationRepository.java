package com.eager.ieu.weatherinfo.daily.data.repository;

import com.eager.ieu.weatherinfo.daily.data.entity.WeatherInfoLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWeatherInfoLocationRepository extends CrudRepository<WeatherInfoLocation, Long> {
    Optional<WeatherInfoLocation> findByLatAndLng(@Param("latitude") double latitude,
                                                  @Param("longitude") double longitude);

    @Query("From WeatherInfoLocation w where w.placeInfoLocation.placeName = :placeName")
    Optional<WeatherInfoLocation> findByPlaceName(@Param("placeName") String placeName);
}
