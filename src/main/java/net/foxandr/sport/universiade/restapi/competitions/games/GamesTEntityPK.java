package net.foxandr.sport.universiade.restapi.competitions.games;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GamesTEntityPK implements Serializable {
    private Long gameId;
    private String locale;

    public Long getId() {
        return gameId;
    }

    public void setId(Long id) {
        this.gameId = id;
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
        GamesTEntityPK that = (GamesTEntityPK) o;
        return gameId == that.gameId && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, locale);
    }
}
