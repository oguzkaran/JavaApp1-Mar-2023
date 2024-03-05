package org.csystem.app.geo.wikisearch.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "wiki_searches")
public class WikiSearch {
    @Id
    public String question;
    @Column(name = "first_query_time", nullable = false)
    public LocalDateTime firstQueryTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wikiSearch", cascade = CascadeType.ALL)
    public Set<WikiSearchQueryInfo> wikiSearchQueryInfo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wikiSearch", cascade = CascadeType.ALL)
    public Set<WikiSearchInfo> wikiSearchInfo;

    @Override
    public int hashCode()
    {
        return question.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof WikiSearch w && question.equals(w.question);
    }
}
