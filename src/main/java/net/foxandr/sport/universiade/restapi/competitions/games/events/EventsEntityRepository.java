package net.foxandr.sport.universiade.restapi.competitions.games.events;

import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesDTOProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface EventsEntityRepository extends JpaRepository<EventsEntity, Long> {

//    Long getId();
//    String getStageName();
//    Long getVenueId();
//    String getDisciplineName();
//    Instant getUtcEventTime();
//    Boolean getIsFinished();


    @Query("SELECT e.id as id, stt.name as stageName, v.id as venueId,  " +
            "dt.categoryName as disciplineName, d.isIndividual as isIndividual, gd.genderType as genderType, " +
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



}
