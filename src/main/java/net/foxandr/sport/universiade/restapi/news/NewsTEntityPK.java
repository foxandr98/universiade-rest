package net.foxandr.sport.universiade.restapi.news;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NewsTEntityPK implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    private NewsEntity newsEntity;
    @Column(name = "locale")
    private String locale;

    public NewsTEntityPK(NewsEntity newsEntity, String locale) {
        this.newsEntity = newsEntity;
        this.locale = locale;
    }
    public NewsTEntityPK() {
    }

    public NewsEntity getNewsEntity() {
        return newsEntity;
    }

    public void setNewsEntity(NewsEntity newsEntity) {
        this.newsEntity = newsEntity;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsTEntityPK that = (NewsTEntityPK) o;
        return newsEntity.equals(that.newsEntity) && locale.equals(that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsEntity, locale);
    }


}
