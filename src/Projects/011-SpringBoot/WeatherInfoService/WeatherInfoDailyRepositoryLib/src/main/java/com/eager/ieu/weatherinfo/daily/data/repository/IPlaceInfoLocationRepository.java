package com.eager.ieu.weatherinfo.daily.data.repository;

import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoLocation;
import com.eager.ieu.weatherinfo.daily.data.entity.WeatherInfoRegion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlaceInfoLocationRepository extends CrudRepository<PlaceInfoLocation, String> {
    Optional<PlaceInfoLocation> findByLatitudeAndLongitude(@Param("latitude") double latitude,
                                                                  @Param("longitude") double longitude);



}
