package org.csystem.app.geo.wikisearch.geonames;

import org.csystem.app.geo.wikisearch.geonames.dto.GeoWikiSearch;
import org.csystem.app.geo.wikisearch.geonames.dto.GeoWikiSearchInfo;
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

    public GeoWikiSearch findWikiSearch(String question)
    {
        return m_restTemplate.getForObject(String.format(m_urlTemplate, question), GeoWikiSearch.class);
    }

    public Iterable<GeoWikiSearchInfo> findWikiSearchInfo(String question)
    {
        return findWikiSearch(question).geonames;
    }
}
