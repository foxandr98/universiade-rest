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
    @JsonIgnore
    private GamesTEntityPK id;
    @Column(name = "name")
    private String name;
    @Column(name = "city_name")
    private String cityName;

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

    public GamesTEntityPK getId() {
        return id;
    }

    public void setId(GamesTEntityPK id) {
        this.id = id;
    }

    public GamesTEntity(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }
    public GamesTEntity(){}

}
