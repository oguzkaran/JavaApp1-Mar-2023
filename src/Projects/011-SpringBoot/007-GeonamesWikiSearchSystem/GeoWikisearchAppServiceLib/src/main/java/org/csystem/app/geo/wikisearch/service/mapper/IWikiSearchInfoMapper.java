package org.csystem.app.geo.wikisearch.service.mapper;

import org.csystem.app.geo.wikisearch.geonames.dto.WikiSearchInfo;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "WikiSearchInfoMapperImpl", componentModel = "spring")
public interface IWikiSearchInfoMapper {
    WikiSearchInfoDTO toWikiSearchInfoDTO(WikiSearchInfo wikiSearchInfo);
}
