package org.csystem.weatherinfo.daily.data.repository;

import org.csystem.weatherinfo.daily.data.entity.PlaceInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoRegionRepository extends CrudRepository<PlaceInfoRegion, String> {
}
