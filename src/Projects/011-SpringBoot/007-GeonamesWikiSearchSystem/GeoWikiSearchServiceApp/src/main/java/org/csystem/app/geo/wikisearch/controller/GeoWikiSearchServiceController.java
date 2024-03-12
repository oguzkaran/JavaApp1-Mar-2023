package org.csystem.app.geo.wikisearch.controller;

import org.csystem.app.geo.wikisearch.service.GeoWikiSearchAppService;
import org.csystem.app.geo.wikisearch.service.dto.WikiSearchDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/geo/wikisearch")
public class GeoWikiSearchServiceController {
    private final GeoWikiSearchAppService m_geoWikiSearchAppService;

    public GeoWikiSearchServiceController(GeoWikiSearchAppService geoWikiSearchAppService)
    {
        m_geoWikiSearchAppService = geoWikiSearchAppService;
    }

    @GetMapping("question")
    public WikiSearchDTO findWikiSearch(@RequestParam(name = "q") String question)
    {
        return m_geoWikiSearchAppService.findWikiSearchByQuestion(question);
    }
}
