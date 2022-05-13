package net.foxandr.sport.universiade.restapi.competitions.games;

import java.util.List;

public interface GamesEntityService {
    GamesInfoEntityDTO findGamesEntityByLocaleAndId(String locale, Long id);
    List<GamesInfoEntityDTO> findGamesEntitiesByLocale(String locale);

}
