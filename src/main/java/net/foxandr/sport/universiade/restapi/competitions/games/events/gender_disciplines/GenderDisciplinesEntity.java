package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.DisciplinesEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gender_disciplines", schema = "universiade")
public class GenderDisciplinesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    @JsonManagedReference
    private DisciplinesEntity disciplinesEntity;

    @Column(name = "gender_type")
    private String genderType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DisciplinesEntity getDisciplinesEntity() {
        return disciplinesEntity;
    }

    public void setDisciplinesEntity(DisciplinesEntity disciplinesEntity) {
        this.disciplinesEntity = disciplinesEntity;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenderDisciplinesEntity that = (GenderDisciplinesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(disciplinesEntity, that.disciplinesEntity) && Objects.equals(genderType, that.genderType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplinesEntity, genderType);
    }
}
