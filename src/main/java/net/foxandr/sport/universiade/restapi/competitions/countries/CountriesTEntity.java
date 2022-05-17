package net.foxandr.sport.universiade.restapi.competitions.countries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.foxandr.sport.universiade.restapi.LanguagesEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "countries_t", schema = "universiade")
public class CountriesTEntity {
    @EmbeddedId
    @JsonIgnore
    private CountriesTEntityPK id;

    @Column(name = "name")
    private String name;

    public CountriesTEntityPK getId() {
        return id;
    }

    public void setId(CountriesTEntityPK id) {
        this.id = id;
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
        CountriesTEntity that = (CountriesTEntity) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
