package net.foxandr.sport.universiade.restapi.competitions.games.events.disciplines.sports;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sports_t", schema = "universiade")
public class SportsTEntity {

    @EmbeddedId
    @JsonIgnore
    private SportsTEntityPK id;

    @Column(name = "name")
    private String name;

    public SportsTEntityPK getId() {
        return id;
    }

    public void setId(SportsTEntityPK id) {
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
        SportsTEntity that = (SportsTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
