package com.eager.ieu.weatherinfo.backup.data.repository;

import com.eager.ieu.weatherinfo.backup.data.entity.PlaceInfoRegion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoRegionRepository extends CrudRepository<PlaceInfoRegion, String> {
}
