package org.csystem.weatherinfo.data.backup.repository;

import org.csystem.weatherinfo.data.backup.entity.PlaceInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoRegionRepository extends CrudRepository<PlaceInfoRegion, String> {
}
