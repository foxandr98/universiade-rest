package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;
import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesTEntity;

public class GamesEntityInfoDTO {

    private GamesEntity gamesEntity;
    private GamesTEntity gamesTEntity;
    private CountriesEntity countriesEntity;
    private CountriesTEntity countriesTEntity;

    public GamesEntityInfoDTO(GamesEntity gamesEntity, GamesTEntity gamesTEntity,
                              CountriesEntity countriesEntity, CountriesTEntity countriesTEntity) {
        this.gamesEntity = gamesEntity;
        this.gamesTEntity = gamesTEntity;
        this.countriesEntity = countriesEntity;
        this. countriesTEntity = countriesTEntity;
    }

    public Long getId(){
        return gamesEntity.getId();
    }

    public String getCodeName(){
        return gamesEntity.getCodeName();
    }

    public Short getGameYear(){
        return gamesEntity.getGameYear();
    }

    public Boolean getIsSummer(){
        return gamesEntity.getIsSummer();
    }

    public String getLocaledGameName(){
        return gamesTEntity.getName();
    }

    public String getLocaledCityName(){
        return gamesTEntity.getCityName();
    }

    public String getLocaledCountryName() {
        return countriesTEntity.getName();
    }

}
