package net.foxandr.sport.universiade.restapi.competitions.games.gamesDTO;

import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

public interface GameEventsProjection {

    String getCodeName();
    Short getGameYear();
    Set<EventProjection> getEventsEntities();

    interface EventProjection {

        //        StageProjection getStage();
//        GenderDisciplineProjection getGenderDiscipline();
//        VenueProjection getVenue();
        Instant getUtcEventTime();
        Boolean getIsFinished();
//
//        interface StageProjection{
//            String getStageCode();
//        }
//
//        interface GenderDisciplineProjection{
//            Long getDisciplineId();
//            String getGenderType();
//        }
//
//        interface VenueProjection{
//            BigDecimal getLongitude();
//            BigDecimal getLatitude();
//        }

    }


}







