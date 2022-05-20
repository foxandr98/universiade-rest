package net.foxandr.sport.universiade.restapi.competitions.games.events.disciplines.sports;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SportsTEntityPK implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonBackReference
    private SportsEntity sportsEntity;
    @Column(name = "locale")
    private String locale;

    public SportsEntity getSportsEntity() {
        return sportsEntity;
    }

    public void setSportsEntity(SportsEntity sportsEntity) {
        this.sportsEntity = sportsEntity;
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
        SportsTEntityPK that = (SportsTEntityPK) o;
        return Objects.equals(sportsEntity, that.sportsEntity) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportsEntity, locale);
    }
}
