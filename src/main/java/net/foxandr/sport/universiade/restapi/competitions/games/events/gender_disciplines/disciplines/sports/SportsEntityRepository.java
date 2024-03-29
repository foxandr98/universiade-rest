package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SportsEntityRepository extends JpaRepository<SportsEntity, Long> {


    @Query("SELECT DISTINCT sp.id as sportId, spt.name as sportName, sp.sportCode as sportCode " +
            "FROM GamesEntity g " +
            "JOIN g.eventsEntities e " +
            "JOIN e.genderDisciplinesEntity gd " +
            "JOIN gd.disciplinesEntity d " +
            "JOIN d.sportsEntity sp " +
            "JOIN sp.sportsTEntities spt " +
            "WHERE spt.id.locale = :locale " +
            "AND g.id = :id " +
            "ORDER BY sp.id")
    List<SportsDTOProjection> findDistinctSportsByLocaleAndGameId(String locale, Long id);


}

