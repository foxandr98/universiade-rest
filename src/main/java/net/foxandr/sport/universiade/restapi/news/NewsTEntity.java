package net.foxandr.sport.universiade.restapi.news;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.LanguagesEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "news_t", schema = "universiade")
@IdClass(NewsTEntityPK.class)
public class NewsTEntity {
    @Id
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;
    @Id
    @Column(name = "locale", updatable = false, insertable = false)
    private String locale;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "id")
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

    public NewsTEntity() {
    }

    public NewsTEntity(Long id, String locale, String title, String text) {
        this.id = id;
        this.locale = locale;
        this.title = title;
        this.text = text;
    }
}
