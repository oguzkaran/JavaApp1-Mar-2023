package com.sunny.app.weatherinfo.geonames;

import com.sunny.app.weatherinfo.geonames.dto.GeoWeatherLocation;
import com.sunny.app.weatherinfo.geonames.dto.GeoWeatherRegion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

@Disabled
class GeoWeatherInfoSearchTests {
    private final RestTemplate m_restTemplate = new RestTemplate();
    private final String m_locationUrl = "http://api.geonames.org/findNearByWeatherJSON?lat=41&lng=29&username=csystem";
    private final String m_regionUrl = "http://api.geonames.org/weatherJSON?north=41&south=36&east=44&west=26&username=csystem";

    @Test
    void testLocationElevation() {
        var gwl = m_restTemplate.getForObject(m_locationUrl, GeoWeatherLocation.class);
        var expectedElevation = 37;

        Assertions.assertNotNull(gwl);
        Assertions.assertEquals(expectedElevation, gwl.weatherObservation.elevation);
    }

    @Test
    void testRegionListSize() {
        var gwr = m_restTemplate.getForObject(m_regionUrl, GeoWeatherRegion.class);
        var expectedListSize = 10;

        Assertions.assertNotNull(gwr);
        Assertions.assertEquals(expectedListSize, gwr.weatherObservations.size());
    }
}
