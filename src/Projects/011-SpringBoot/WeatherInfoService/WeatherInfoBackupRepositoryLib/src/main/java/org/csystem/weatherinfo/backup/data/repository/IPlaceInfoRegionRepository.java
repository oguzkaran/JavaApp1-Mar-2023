package org.csystem.weatherinfo.backup.data.repository;

import org.csystem.weatherinfo.backup.data.entity.PlaceInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoRegionRepository extends CrudRepository<PlaceInfoRegion, String> {
}
