package net.foxandr.sport.universiade.restapi.competitions.games.events;

import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesDTOProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface EventsEntityRepository extends JpaRepository<EventsEntity, Long> {

    @Query("SELECT e.id as id, stt.name as stageName, v.id as venueId,  " +
            "dt.name as disciplineName, d.isIndividual as isIndividual, gd.genderType as genderType, " +
            "e.utcEventTime as utcEventTime, e.isFinished as isFinished " +
            "FROM EventsEntity e " +
            "JOIN e.gamesEntity g " +
            "JOIN e.venuesEntity v " +
            "JOIN e.stagesEntity st " +
            "JOIN st.stagesTEntities stt " +
            "JOIN e.genderDisciplinesEntity gd " +
            "JOIN gd.disciplinesEntity d " +
            "JOIN d.disciplinesTEntities dt " +
            "WHERE stt.id.locale = :locale AND dt.id.locale = :locale " +
            "AND g.id = :id")
    List<EventsDTOProjection> findAllEventsByLocaleAndGameId(String locale, Long id);


    @Query("SELECT e " +
            "FROM EventsEntity e " +
            "JOIN FETCH e.gamesEntity g " +
            "JOIN FETCH e.venuesEntity v " +
            "JOIN FETCH v.venuesTEntities vt " +
            "JOIN FETCH e.stagesEntity st " +
            "JOIN FETCH st.stagesTEntities stt " +
            "JOIN FETCH e.genderDisciplinesEntity gd " +
            "JOIN FETCH gd.disciplinesEntity d " +
            "JOIN FETCH d.disciplinesTEntities dt " +
            "JOIN FETCH d.sportsEntity sp " +
            "JOIN FETCH sp.sportsTEntities spt " +
            "WHERE stt.id.locale = :locale AND dt.id.locale = :locale " +
            "AND spt.id.locale = :locale AND vt.id.locale = :locale " +
            "AND g.id = :gameId AND d.sportsEntity.id = :sportId")
    List<EventsEntity> findAllEventsByLocaleAndGameIdAndSportId(String locale, Long gameId, Long sportId);


}
