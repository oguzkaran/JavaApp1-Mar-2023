package org.csystem.app.geo.wikisearch.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "wiki_search_info")
public class WikiSearchInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wiki_search_info_id")
    public long id;

    @Column(length = 1024)
    public String summary;

    public int elevation;

    public double longitude;

    public int rank;

    @Column(name = "thumbnail_image")
    public String thumbnailImage;

    public String language;

    public String title;

    public double latitude;

    @Column(name = "wikipedia_url")
    public String wikipediaUrl;

    @Column(name = "geoname_id")
    public int geoNameId;

    @Column(name = "country_code")
    public String countryCode;

    public String feature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question", nullable = false)
    public WikiSearch wikiSearch;

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof WikiSearchInfo wi && id == wi.id;
    }
}
