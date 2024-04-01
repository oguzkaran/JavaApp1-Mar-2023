package com.eager.ieu.weatherinfo.backup.data.repository;

import com.eager.ieu.weatherinfo.backup.data.entity.PlaceInfoLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoLocationRepository extends CrudRepository<PlaceInfoLocation, String> {
}
