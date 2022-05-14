package net.foxandr.sport.universiade.restapi.competitions.games;

public interface TestInterfaceRepository {
    GamesEntity findParticipantsEntitiesByGameIdAndLocale(Long gameId, String locale);
}
