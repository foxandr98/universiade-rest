package net.foxandr.sport.universiade.restapi.competitions.games.events.results;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "result_types_t", schema = "universiade")
public class ResultTypesTEntity {

    @EmbeddedId
    @JsonIgnore
    private ResultTypesTEntityPK id;

    @Column(name = "name")
    private String name;


    public ResultTypesTEntityPK getId() {
        return id;
    }

    public void setId(ResultTypesTEntityPK id) {
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
        ResultTypesTEntity that = (ResultTypesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
