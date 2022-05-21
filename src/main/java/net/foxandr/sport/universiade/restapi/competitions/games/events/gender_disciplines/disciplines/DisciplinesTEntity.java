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

    @Column(name = "category_name")
    private String categoryName;

    public DisciplinesTEntityPK getId() {
        return id;
    }

    public void setId(DisciplinesTEntityPK id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinesTEntity that = (DisciplinesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName);
    }
}
