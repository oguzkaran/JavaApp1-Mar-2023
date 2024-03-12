package org.csystem.app.geo.wikisearch.service;

import com.karandev.util.data.service.DataServiceException;
import org.csystem.app.geo.wikisearch.data.dal.GeoWikiSearchDataHelper;
import org.csystem.app.geo.wikisearch.geonames.GeonamesWikiSearchHelper;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchDTO;
import org.csystem.app.geo.wikisearch.service.mapper.IWikiSearchInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class GeoWikiSearchAppService {
    private final GeonamesWikiSearchHelper m_geonamesWikiSearchHelper;
    private final GeoWikiSearchDataHelper m_geoWikiSearchDataHelper;

    private final IWikiSearchInfoMapper m_wikiSearchInfoMapper;

    private WikiSearchDTO exitsInDbCallback(String question)
    {
        return m_wikiSearchInfoMapper.toWikiSearchDTO(m_geoWikiSearchDataHelper.findWikiSearchInfoByQuestion(question).get());
    }

    private WikiSearchDTO notExistsInDbCallback(String question)
    {
        var geoWikiSearch = m_geonamesWikiSearchHelper.findWikiSearch(question);

        m_geoWikiSearchDataHelper.saveWikiSearch(m_wikiSearchInfoMapper.toWikiSearch(geoWikiSearch));
        return m_wikiSearchInfoMapper.toWikiSearchDTO(geoWikiSearch);
    }


    public GeoWikiSearchAppService(GeonamesWikiSearchHelper geonamesWikiSearchHelper, GeoWikiSearchDataHelper geoWikiSearchDataHelper, IWikiSearchInfoMapper wikiSearchInfoMapper)
    {
        m_geonamesWikiSearchHelper = geonamesWikiSearchHelper;
        m_geoWikiSearchDataHelper = geoWikiSearchDataHelper;
        m_wikiSearchInfoMapper = wikiSearchInfoMapper;
    }

    public WikiSearchDTO findWikiSearchByQuestion(String question)
    {
        try {
            return m_geoWikiSearchDataHelper.existQuestionById(question) ? exitsInDbCallback(question) : notExistsInDbCallback(question);
        }
        catch (Throwable ex) {
            throw new DataServiceException("GeoWikiSearchAppService.findWikiSearchInfo", ex);
        }
    }
}
