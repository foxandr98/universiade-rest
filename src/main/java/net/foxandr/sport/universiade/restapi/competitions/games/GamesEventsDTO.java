package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsEntity;

import java.util.Set;

public interface GamesEventsDTO {

    GamesEntity getGamesEntity();
    Set<EventsEntity> getEventsEntities();

}
