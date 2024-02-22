package org.csystem.app.geo.wikisearch.geonames;

import org.csystem.app.geo.wikisearch.geonames.dto.WikiSearch;
import org.csystem.app.geo.wikisearch.geonames.dto.WikiSearchInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeonamesWikiSearchHelper {
    private final RestTemplate m_restTemplate;

    //@Value("${geonames.url.template}")
    private String m_urlTemplate = "http://api.geonames.org/wikipediaSearchJSON?&q=%s&maxRows=10&username=csystem";

    public GeonamesWikiSearchHelper(RestTemplate restTemplate)
    {
        m_restTemplate = restTemplate;
    }

    public WikiSearch findWikiSearch(String question)
    {
        return m_restTemplate.getForObject(String.format(m_urlTemplate, question), WikiSearch.class);
    }

    public Iterable<WikiSearchInfo> findWikiSearchInfo(String question)
    {
        return findWikiSearch(question).geonames;
    }
}
