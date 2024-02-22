package org.csystem.app.geo.wikisearch.service;

import com.karandev.util.data.service.DataServiceException;
import org.csystem.app.geo.wikisearch.geonames.GeonamesWikiSearchHelper;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchInfoDTO;
import org.csystem.app.geo.wikisearch.service.mapper.IWikiSearchInfoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class GeoWikiSearchAppService {
    private final GeonamesWikiSearchHelper m_geonamesWikiSearchHelper;
    private final IWikiSearchInfoMapper m_wikiSearchInfoMapper;

    public GeoWikiSearchAppService(GeonamesWikiSearchHelper geonamesWikiSearchHelper, IWikiSearchInfoMapper wikiSearchInfoMapper)
    {
        m_geonamesWikiSearchHelper = geonamesWikiSearchHelper;
        m_wikiSearchInfoMapper = wikiSearchInfoMapper;
    }

    public Iterable<WikiSearchInfoDTO> findWikiSearchInfo(String question)
    {
        try {
            return StreamSupport.stream(m_geonamesWikiSearchHelper.findWikiSearchInfo(question).spliterator(), false)
                    .map(m_wikiSearchInfoMapper::toWikiSearchInfoDTO).toList();
        }
        catch (Throwable ex) {
            throw new DataServiceException("GeoWikiSearchAppService.findWikiSearchInfo", ex);
        }
    }
}
