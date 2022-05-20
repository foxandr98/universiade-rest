package net.foxandr.sport.universiade.restapi.news;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "news_t", schema = "universiade")
public class NewsTEntity {

    @EmbeddedId
    @JsonIgnore
    private NewsTEntityPK id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

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

    public String getLocale() {
        return id.getLocale();
    }

    public NewsTEntityPK getId() {
        return id;
    }

    public void setId(NewsTEntityPK id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsTEntity that = (NewsTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text);
    }

    public NewsTEntity() {
    }

    public NewsTEntity(NewsTEntityPK id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
}
