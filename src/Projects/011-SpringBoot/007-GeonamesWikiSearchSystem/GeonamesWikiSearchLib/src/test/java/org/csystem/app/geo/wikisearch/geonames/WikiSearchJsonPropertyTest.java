package org.csystem.app.geo.wikisearch.geonames;

import org.csystem.app.geo.wikisearch.geonames.dto.WikiSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class WikiSearchJsonPropertyTest {
    private final RestTemplate m_restTemplate = new RestTemplate();
    private final String m_url = "http://api.geonames.org/wikipediaSearchJSON?&q=ankara&maxRows=10&username=csystem";

    @Test
    public void test_latitude()
    {
        var expectedLatitude = 39.9272222;
        var ws = m_restTemplate.getForObject(m_url, WikiSearch.class);

        Assertions.assertNotNull(ws);
        Assertions.assertEquals(expectedLatitude, ws.geonames.get(1).latitude, 0.00001);
    }

    @Test
    public void test_longitude()
    {
        var expectedLongitude = 32.8644444;
        var ws = m_restTemplate.getForObject(m_url, WikiSearch.class);

        Assertions.assertNotNull(ws);
        Assertions.assertEquals(expectedLongitude, ws.geonames.get(1).longitude, 0.00001);
    }

    @Test
    public void test_language()
    {
        var expectedLanguage = "en";
        var ws = m_restTemplate.getForObject(m_url, WikiSearch.class);

        Assertions.assertNotNull(ws);
        Assertions.assertEquals(expectedLanguage, ws.geonames.get(1).language);
    }
}
