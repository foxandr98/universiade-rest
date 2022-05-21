package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DisciplinesTEntityPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id")
    @JsonBackReference
    private DisciplinesEntity disciplinesEntity;
    @Column(name = "locale")
    private String locale;

    public DisciplinesEntity getDisciplinesEntity() {
        return disciplinesEntity;
    }

    public void setDisciplinesEntity(DisciplinesEntity disciplinesEntity) {
        this.disciplinesEntity = disciplinesEntity;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinesTEntityPK that = (DisciplinesTEntityPK) o;
        return Objects.equals(disciplinesEntity, that.disciplinesEntity) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplinesEntity, locale);
    }
}
