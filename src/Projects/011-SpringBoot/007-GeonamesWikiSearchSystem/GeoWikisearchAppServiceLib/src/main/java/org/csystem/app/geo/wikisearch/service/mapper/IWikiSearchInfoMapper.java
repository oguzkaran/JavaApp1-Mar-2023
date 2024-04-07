package org.csystem.app.geo.wikisearch.service.mapper;

import org.csystem.app.geo.wikisearch.data.entity.WikiSearch;
import org.csystem.app.geo.wikisearch.data.entity.WikiSearchInfo;
import org.csystem.app.geo.wikisearch.geonames.dto.GeoWikiSearch;
import org.csystem.app.geo.wikisearch.geonames.dto.GeoWikiSearchInfo;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchDTO;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(implementationName = "WikiSearchInfoMapperImpl", componentModel = "spring")
public interface IWikiSearchInfoMapper {
    WikiSearchInfoDTO toWikiSearchInfoDTO(GeoWikiSearchInfo geoWikiSearchInfo);

    @Mapping(source = "geonames", target = "geoWikiSearch")
    WikiSearchDTO toWikiSearchDTO(GeoWikiSearch geoWikiSearch);

    @Mapping(source = "thumbnailImage", target = "thumbnailImg")
    WikiSearchInfoDTO toWikiSearchInfoDTO(WikiSearchInfo wikiSearchInfo);

    @Mapping(source = "wikiSearchInfo", target = "geoWikiSearch")
    WikiSearchDTO toWikiSearchDTO(WikiSearch WikiSearch);

    @Mapping(source = "thumbnailImg", target = "thumbnailImage")
    WikiSearchInfo toWikiSearchInfo(GeoWikiSearchInfo geoWikiSearchInfo);

    Set<WikiSearchInfo> toWikiSearchInfo(List<GeoWikiSearchInfo> geoWikiSearchInfo);
}
