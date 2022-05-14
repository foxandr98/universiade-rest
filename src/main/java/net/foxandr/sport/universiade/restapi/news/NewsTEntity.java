package net.foxandr.sport.universiade.restapi.news;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.LanguagesEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "news_t", schema = "universiade")
@IdClass(NewsTEntityPK.class)
public class NewsTEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Id
    @Column(name = "locale")
    private String locale;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "text")
    private String text;

    @ManyToOne
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private NewsEntity newsEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsTEntity that = (NewsTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(locale, that.locale) && Objects.equals(title, that.title) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locale, title, text);
    }

    public NewsEntity getNewsEntity() {
        return newsEntity;
    }

    public void setNewsEntity(NewsEntity newsEntity) {
        this.newsEntity = newsEntity;
    }
}
