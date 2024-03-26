package org.csystem.weatherinfo.data.daily.repository;

import org.csystem.weatherinfo.data.daily.entity.PlaceInfoByLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoByLocationRepository extends CrudRepository<PlaceInfoByLocation, String> {
}
