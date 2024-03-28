package org.csystem.weatherinfo.daily.data.repository;

import org.csystem.weatherinfo.daily.data.entity.PlaceInfoByLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoByLocationRepository extends CrudRepository<PlaceInfoByLocation, String> {
}
