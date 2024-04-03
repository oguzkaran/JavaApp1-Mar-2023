package org.csystem.app.geo.wikisearch.data.repository;

import org.csystem.app.geo.wikisearch.data.entity.WikiSearchQueryInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWikiSearchQueryInfoRepository extends CrudRepository<WikiSearchQueryInfo, Long> {

}
