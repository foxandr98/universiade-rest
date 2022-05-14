package net.foxandr.sport.universiade.restapi;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.foxandr.sport.universiade.restapi.competitions.athletes.AthletesTEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesTEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "languages", schema = "universiade")
public class LanguagesEntity {
    @Id
    @Column(name = "locale")
    private String locale;

    @Column(name = "name")
    private String name;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguagesEntity that = (LanguagesEntity) o;
        return Objects.equals(locale, that.locale) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, name);
    }
}
