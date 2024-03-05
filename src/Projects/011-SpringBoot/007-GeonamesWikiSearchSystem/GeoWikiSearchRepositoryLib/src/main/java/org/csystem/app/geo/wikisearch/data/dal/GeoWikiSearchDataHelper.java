package org.csystem.app.geo.wikisearch.data.dal;

import org.csystem.app.geo.wikisearch.data.repository.IWikiSearchInfoRepository;
import org.csystem.app.geo.wikisearch.data.repository.IWikiSearchQueryInfoRepository;
import org.csystem.app.geo.wikisearch.data.repository.IWikiSearchRepository;
import org.springframework.stereotype.Component;

@Component
public class GeoWikiSearchDataHelper {
    private final IWikiSearchRepository m_wikiSearchRepository;
    private final IWikiSearchInfoRepository m_wikiSearchInfoRepository;
    private final IWikiSearchQueryInfoRepository m_wikiSearchQueryInfoRepository;

    public GeoWikiSearchDataHelper(IWikiSearchRepository wikiSearchRepository, IWikiSearchInfoRepository wikiSearchInfoRepository, IWikiSearchQueryInfoRepository wikiSearchQueryInfoRepository)
    {
        m_wikiSearchRepository = wikiSearchRepository;
        m_wikiSearchInfoRepository = wikiSearchInfoRepository;
        m_wikiSearchQueryInfoRepository = wikiSearchQueryInfoRepository;
    }

    public boolean existQuestionById(String question)
    {
        //...
        return m_wikiSearchRepository.existsById(question);
    }

    //...
}
