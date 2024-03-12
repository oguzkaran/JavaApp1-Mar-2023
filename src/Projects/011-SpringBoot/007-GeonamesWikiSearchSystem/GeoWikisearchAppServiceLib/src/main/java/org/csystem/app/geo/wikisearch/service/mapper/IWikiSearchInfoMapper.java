package org.csystem.app.geo.wikisearch.service.mapper;

import org.csystem.app.geo.wikisearch.data.entity.WikiSearch;
import org.csystem.app.geo.wikisearch.data.entity.WikiSearchInfo;
import org.csystem.app.geo.wikisearch.geonames.dto.GeoWikiSearch;
import org.csystem.app.geo.wikisearch.geonames.dto.GeoWikiSearchInfo;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchDTO;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "WikiSearchInfoMapperImpl", componentModel = "spring")
public interface IWikiSearchInfoMapper {
    WikiSearchInfoDTO toWikiSearchInfoDTO(GeoWikiSearchInfo geoWikiSearchInfo);

    @Mapping(source = "geonames", target = "geoWikiSearch")
    WikiSearchDTO toWikiSearchDTO(GeoWikiSearch geoWikiSearch);

    WikiSearchInfoDTO toWikiSearchInfoDTO(WikiSearchInfo wikiSearchInfo);

    WikiSearchDTO toWikiSearchDTO(WikiSearch WikiSearch);

    //...
    WikiSearch toWikiSearch(GeoWikiSearch geoWikiSearch);
}
