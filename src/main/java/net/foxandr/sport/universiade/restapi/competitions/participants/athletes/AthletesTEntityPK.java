package net.foxandr.sport.universiade.restapi.competitions.participants.athletes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AthletesTEntityPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    private AthletesEntity athletesEntity;
    private String locale;


    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public AthletesEntity getAthletesEntity() {
        return athletesEntity;
    }

    public void setAthletesEntity(AthletesEntity athletesEntity) {
        this.athletesEntity = athletesEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthletesTEntityPK that = (AthletesTEntityPK) o;
        return athletesEntity.equals(that.athletesEntity) && locale.equals(that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(athletesEntity, locale);
    }
}
