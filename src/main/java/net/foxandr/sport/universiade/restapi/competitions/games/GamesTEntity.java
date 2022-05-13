package net.foxandr.sport.universiade.restapi.competitions.games;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.LanguagesEntity;

import javax.persistence.*;

@Entity
@Table(name = "games_t")
public class GamesTEntity {
    @EmbeddedId
    private GamesTEntityPK gamesTEntityPK;
    @Column(name = "name")
    private String name;
    @Column(name = "city_name")
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gameId")
    @JoinColumn(name = "id")
    @JsonBackReference
    private GamesEntity gamesById;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("locale")
    @JoinColumn(name = "locale")
    @JsonIgnore
    private LanguagesEntity languagesByLocale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public GamesTEntityPK getGamesTEntityPK() {
        return gamesTEntityPK;
    }

    public void setGamesTEntityPK(GamesTEntityPK gamesTEntityPK) {
        this.gamesTEntityPK = gamesTEntityPK;
    }

    public GamesEntity getGamesById() {
        return gamesById;
    }

    public void setGamesById(GamesEntity gamesById) {
        this.gamesById = gamesById;
    }

    public LanguagesEntity getLanguagesByLocale() {
        return languagesByLocale;
    }

    public void setLanguagesByLocale(LanguagesEntity languagesByLocale) {
        this.languagesByLocale = languagesByLocale;
    }
}
