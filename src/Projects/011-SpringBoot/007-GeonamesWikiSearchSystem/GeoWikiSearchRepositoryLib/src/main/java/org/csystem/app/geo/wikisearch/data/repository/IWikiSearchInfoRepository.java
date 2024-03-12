package org.csystem.app.geo.wikisearch.data.repository;

import org.csystem.app.geo.wikisearch.data.entity.WikiSearchInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWikiSearchInfoRepository extends CrudRepository<WikiSearchInfo, Long> {

}
