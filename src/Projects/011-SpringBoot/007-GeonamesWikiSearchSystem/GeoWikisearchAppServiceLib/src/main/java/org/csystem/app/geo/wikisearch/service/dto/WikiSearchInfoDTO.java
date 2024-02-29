package org.csystem.app.geo.wikisearch.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class WikiSearchInfoDTO {
    public String summary;
    public int elevation;
    public double longitude;
    public int rank;
    public String thumbnailImg;

    public String language;
    public String title;
    public double latitude;
    public String wikipediaUrl;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String feature;
}