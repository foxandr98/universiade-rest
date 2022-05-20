package net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO;

import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;
import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesEntity;

import java.util.List;

public interface GameDTOList {
    String getCodeName();
    List<CountriesEntity> getCountriesEntities();
}
