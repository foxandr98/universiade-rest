package net.foxandr.sport.universiade.restapi.news;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class NewsTEntityPK implements Serializable {
    private Long id;
    private String locale;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsTEntityPK that = (NewsTEntityPK) o;
        return Objects.equals(id, that.id) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locale);
    }
}
