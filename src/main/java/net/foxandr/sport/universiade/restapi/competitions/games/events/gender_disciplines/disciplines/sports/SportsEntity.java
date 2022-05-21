package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.DisciplinesEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sports", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SportsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "sport_code")
    private String sportCode;

    @OneToMany(mappedBy = "id.sportsEntity")
    @JsonManagedReference
    private Set<SportsTEntity> sportsTEntities;

    @OneToMany(mappedBy = "sportsEntity")
    @JsonBackReference
    private Set<DisciplinesEntity> disciplinesEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSportCode() {
        return sportCode;
    }

    public void setSportCode(String sportCode) {
        this.sportCode = sportCode;
    }

    public Set<SportsTEntity> getSportsTEntities() {
        return sportsTEntities;
    }

    public void setSportsTEntities(Set<SportsTEntity> sportsTEntities) {
        this.sportsTEntities = sportsTEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsEntity that = (SportsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(sportCode, that.sportCode) && Objects.equals(sportsTEntities, that.sportsTEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sportCode, sportsTEntities);
    }

    public Set<DisciplinesEntity> getDisciplinesEntities() {
        return disciplinesEntities;
    }

    public void setDisciplinesEntities(Set<DisciplinesEntity> disciplinesEntities) {
        this.disciplinesEntities = disciplinesEntities;
    }
}
