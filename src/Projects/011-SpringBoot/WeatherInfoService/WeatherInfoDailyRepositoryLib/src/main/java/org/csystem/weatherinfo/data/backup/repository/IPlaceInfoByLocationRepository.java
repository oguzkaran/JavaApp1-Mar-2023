package org.csystem.weatherinfo.data.backup.repository;

import org.csystem.weatherinfo.data.backup.entity.PlaceInfoByLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoByLocationRepository extends CrudRepository<PlaceInfoByLocation, String> {
}
