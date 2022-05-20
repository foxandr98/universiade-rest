package net.foxandr.sport.universiade.restapi.competitions.games.events.stages;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stages_t", schema = "universiade")
public class StagesTEntity {

    @EmbeddedId
    @JsonIgnore
    private StagesTEntityPK id;

    @Column(name = "name")
    private String name;

    public StagesTEntityPK getId() {
        return id;
    }

    public void setId(StagesTEntityPK id) {
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
        StagesTEntity that = (StagesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
