package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports;

import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports.SportDTOProjection;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.disciplines.sports.SportsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SportsRepository extends JpaRepository<SportsEntity, Long> {


    @Query("SELECT DISTINCT sp.id as sportId, spt.name as sportName " +
            "FROM GamesEntity g " +
            "JOIN g.eventsEntities e " +
            "JOIN e.genderDisciplinesEntity gd " +
            "JOIN gd.disciplinesEntity d " +
            "JOIN d.sportsEntity sp " +
            "JOIN sp.sportsTEntities spt " +
            "WHERE spt.id.locale = :locale " +
            "AND g.id = :id")
    List<SportDTOProjection> findDistinctSportsByLocaleAndGameId(Long id, String locale);


}

