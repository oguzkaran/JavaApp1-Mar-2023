package org.csystem.app.geo.wikisearch.service.mapper;

import org.csystem.app.geo.wikisearch.geonames.dto.WikiSearch;
import org.csystem.app.geo.wikisearch.geonames.dto.WikiSearchInfo;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchDTO;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "WikiSearchInfoMapperImpl", componentModel = "spring")
public interface IWikiSearchInfoMapper {
    WikiSearchInfoDTO toWikiSearchInfoDTO(WikiSearchInfo wikiSearchInfo);

    @Mapping(source = "geonames", target = "geoWikiSearch")
    WikiSearchDTO toWikiSearchDTO(WikiSearch wikiSearch);
}
