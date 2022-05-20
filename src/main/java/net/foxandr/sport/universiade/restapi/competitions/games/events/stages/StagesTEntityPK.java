package net.foxandr.sport.universiade.restapi.competitions.games.events.stages;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StagesTEntityPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonBackReference
    private StagesEntity stagesEntity;
    @Column(name = "locale")
    private String locale;

    public StagesEntity getStagesEntity() {
        return stagesEntity;
    }

    public void setStagesEntity(StagesEntity stagesEntity) {
        this.stagesEntity = stagesEntity;
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
        StagesTEntityPK that = (StagesTEntityPK) o;
        return Objects.equals(stagesEntity, that.stagesEntity) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stagesEntity, locale);
    }
}
