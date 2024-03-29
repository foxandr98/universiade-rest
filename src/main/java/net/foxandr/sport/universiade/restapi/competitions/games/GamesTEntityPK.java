package net.foxandr.sport.universiade.restapi.competitions.games;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GamesTEntityPK implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonBackReference
    private GamesEntity gamesEntity;
    private String locale;

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
        GamesTEntityPK that = (GamesTEntityPK) o;
        return gamesEntity == that.gamesEntity && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamesEntity, locale);
    }

    public GamesEntity getGamesEntity() {
        return gamesEntity;
    }

    public void setGamesEntity(GamesEntity gamesEntity) {
        this.gamesEntity = gamesEntity;
    }
}
