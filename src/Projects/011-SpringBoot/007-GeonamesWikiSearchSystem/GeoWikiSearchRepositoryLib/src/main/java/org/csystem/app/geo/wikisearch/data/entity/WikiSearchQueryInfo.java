package org.csystem.app.geo.wikisearch.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "wiki_search_query_info")
public class WikiSearchQueryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wiki_search_query")
    public long id;

    @Column(name = "query_date_time", nullable = false)
    public LocalDateTime queryDateTime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question", nullable = false)
    public WikiSearch wikiSearch;

    @Override
    public int hashCode()
    {
        return Objects.hashCode(queryDateTime);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof WikiSearchQueryInfo wqi && Objects.equals(wqi.queryDateTime, queryDateTime);
    }
}
