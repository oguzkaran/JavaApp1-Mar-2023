package org.csystem.weatherinfo.data.daily.repository;

import org.csystem.weatherinfo.data.daily.entity.PlaceInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoRegionRepository extends CrudRepository<PlaceInfoRegion, String> {
}
