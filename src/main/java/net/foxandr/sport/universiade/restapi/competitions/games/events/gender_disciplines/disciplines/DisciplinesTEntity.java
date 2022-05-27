package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disciplines_t", schema = "universiade")
public class DisciplinesTEntity {

    @EmbeddedId
    @JsonIgnore
    private DisciplinesTEntityPK id;

    @Column(name = "name")
    private String name;

    public DisciplinesTEntityPK getId() {
        return id;
    }

    public void setId(DisciplinesTEntityPK id) {
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
        DisciplinesTEntity that = (DisciplinesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
