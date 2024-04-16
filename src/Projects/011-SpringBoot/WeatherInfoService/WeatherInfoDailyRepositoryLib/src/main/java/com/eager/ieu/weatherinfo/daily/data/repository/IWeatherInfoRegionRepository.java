package com.eager.ieu.weatherinfo.daily.data.repository;

import com.eager.ieu.weatherinfo.daily.data.entity.WeatherInfoRegion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWeatherInfoRegionRepository extends CrudRepository<WeatherInfoRegion, Long> {
    @Query("From WeatherInfoRegion w where w.placeInfoRegion.east = :east and w.placeInfoRegion.west = :west " +
            "and w.placeInfoRegion.north = :north and w.placeInfoRegion.south = :south")
    Iterable<WeatherInfoRegion> findWeatherInfoRegionByEastAndWestAndNorthAndSouth(@Param("east") double east,
                                                                                   @Param("west") double west,
                                                                                   @Param("north") double north,
                                                                                   @Param("south") double south);

    @Query("From WeatherInfoRegion w where w.placeInfoRegion.region = :region")
    Iterable<WeatherInfoRegion> findWeatherInfoRegionByRegion(@Param("region") String region);

}
