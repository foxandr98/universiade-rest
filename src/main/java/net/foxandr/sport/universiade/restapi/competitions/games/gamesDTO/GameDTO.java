package net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO;

import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;
import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesTEntity;

import java.util.Set;

public class GameDTO {
    String codeName;
    String countryName;

    Set<CountriesTEntity> countries;

    public GameDTO(String codeName, String countryName, Set<CountriesTEntity> count) {
        this.codeName = codeName;
        this.countryName = countryName;
        this.countries = count;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getIocName() {
        return countryName;
    }

    public void setIocName(String countryName) {
        this.countryName = countryName;
    }


    public Set<CountriesTEntity> getCountries() {
        return countries;
    }

    public void setCountries(Set<CountriesTEntity> countries) {
        this.countries = countries;
    }
}
