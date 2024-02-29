package org.csystem.app.geo.wikisearch.service;

import com.karandev.util.data.service.DataServiceException;
import org.csystem.app.geo.wikisearch.geonames.GeonamesWikiSearchHelper;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchDTO;
import org.csystem.app.geo.wikisearch.service.mapper.IWikiSearchInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class GeoWikiSearchAppService {
    private final GeonamesWikiSearchHelper m_geonamesWikiSearchHelper;
    private final IWikiSearchInfoMapper m_wikiSearchInfoMapper;

    public GeoWikiSearchAppService(GeonamesWikiSearchHelper geonamesWikiSearchHelper, IWikiSearchInfoMapper wikiSearchInfoMapper)
    {
        m_geonamesWikiSearchHelper = geonamesWikiSearchHelper;
        m_wikiSearchInfoMapper = wikiSearchInfoMapper;
    }

    public WikiSearchDTO findWikiSearchInfo(String question)
    {
        try {
            return m_wikiSearchInfoMapper.toWikiSearchDTO(m_geonamesWikiSearchHelper.findWikiSearch(question));
        }
        catch (Throwable ex) {
            throw new DataServiceException("GeoWikiSearchAppService.findWikiSearchInfo", ex);
        }
    }
}
