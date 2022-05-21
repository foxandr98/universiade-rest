package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.DisciplinesEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "gender_disciplines", schema = "universiade")
public class GenderDisciplinesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discipline_id")
    @JsonManagedReference
    private DisciplinesEntity disciplinesEntity;

    @OneToMany(mappedBy = "genderDisciplinesEntity", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<EventsEntity> eventsEntities;

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

    public Set<EventsEntity> getEventsEntities() {
        return eventsEntities;
    }

    public void setEventsEntities(Set<EventsEntity> eventsEntities) {
        this.eventsEntities = eventsEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenderDisciplinesEntity that = (GenderDisciplinesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(genderType, that.genderType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genderType);
    }
}
