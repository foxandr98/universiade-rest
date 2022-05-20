package net.foxandr.sport.universiade.restapi.competitions.universities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.foxandr.sport.universiade.restapi.LanguagesEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "universities_t", schema = "universiade")
public class UniversitiesTEntity {

    @EmbeddedId
    @JsonIgnore
    private UniversitiesTEntityPK id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;


    public UniversitiesTEntityPK getId() {
        return id;
    }

    public void setId(UniversitiesTEntityPK id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversitiesTEntity that = (UniversitiesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(abbreviation, that.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbreviation);
    }

}
