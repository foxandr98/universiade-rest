package net.foxandr.sport.universiade.restapi.competitions.games;

import java.util.List;

public interface GamesEntityService {
    GamesEntityInfoDTO findGamesEntityByLocaleAndId(String locale, Long id);
    List<GamesEntityInfoDTO> findGamesEntitiesByLocale(String locale);

    List<GamesEntity> findParticipantsEntitiesByGameIdAndLocale(Long gameId, String locale);

}
