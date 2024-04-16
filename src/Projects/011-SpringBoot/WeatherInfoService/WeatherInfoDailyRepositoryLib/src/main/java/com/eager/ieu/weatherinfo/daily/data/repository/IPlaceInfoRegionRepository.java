package com.eager.ieu.weatherinfo.daily.data.repository;

import com.eager.ieu.weatherinfo.daily.data.entity.PlaceInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlaceInfoRegionRepository extends CrudRepository<PlaceInfoRegion, String> {
    Optional<PlaceInfoRegion> findByEastAndWestAndNorthAndSouth(@Param("east") double east,
                                                                @Param("west") double west,
                                                                @Param("north") double north,
                                                                @Param("south") double south);
}
