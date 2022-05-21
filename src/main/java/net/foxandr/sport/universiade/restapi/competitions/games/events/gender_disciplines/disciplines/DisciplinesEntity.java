package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.GenderDisciplinesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.sports.SportsEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disciplines", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DisciplinesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Short id;

    @Column(name = "discipline_code")
    private String disciplineCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport_id")
    @JsonManagedReference
    private SportsEntity sportsEntity;

    @Column(name = "score_type")
    private String scoreType;

    @Column(name = "is_individual")
    private Boolean isIndividual;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<GenderDisciplinesEntity> genderDisciplinesEntities;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDisciplineCode() {
        return disciplineCode;
    }

    public void setDisciplineCode(String disciplineCode) {
        this.disciplineCode = disciplineCode;
    }


    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }


    public Boolean getIsIndividual() {
        return isIndividual;
    }

    public void setIsIndividual(Boolean isIndividual) {
        this.isIndividual = isIndividual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinesEntity that = (DisciplinesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(disciplineCode, that.disciplineCode) && Objects.equals(sportsEntity, that.sportsEntity) && Objects.equals(scoreType, that.scoreType) && Objects.equals(isIndividual, that.isIndividual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplineCode, sportsEntity, scoreType, isIndividual);
    }

    public List<GenderDisciplinesEntity> getGenderDisciplinesEntities() {
        return genderDisciplinesEntities;
    }

    public void setGenderDisciplinesEntities(List<GenderDisciplinesEntity> genderDisciplinesEntities) {
        this.genderDisciplinesEntities = genderDisciplinesEntities;
    }
}
