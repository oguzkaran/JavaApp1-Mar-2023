package org.csystem.weatherinfo.backup.data.repository;

import org.csystem.weatherinfo.backup.data.entity.PlaceInfoByLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoByLocationRepository extends CrudRepository<PlaceInfoByLocation, String> {
}
