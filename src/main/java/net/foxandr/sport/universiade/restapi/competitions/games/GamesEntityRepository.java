package net.foxandr.sport.universiade.restapi.competitions.games;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface GamesEntityRepository extends JpaRepository<GamesEntity, Long> {

    @Query("SELECT g.id as id, g.codeName as codeName, gt.name as gameName, " +
            "ct.name as countryName, g.gameYear as gameYear, g.isSummer as isSummer " +
            "FROM GamesEntity g " +
            "JOIN g.gamesTEntities gt " +
            "JOIN g.countriesEntity c " +
            "JOIN c.countriesTEntities ct " +
            "WHERE gt.id.locale = :locale AND ct.id.locale = :locale " +
            "ORDER BY id DESC")
    List<GamesDTOProjection> findShortGamesInfoByLocale(String locale);


    @Query("SELECT g " +
            "FROM GamesEntity g " +
            "JOIN FETCH g.gamesTEntities gt  " +
            "JOIN FETCH g.countriesEntity c " +
            "JOIN FETCH c.countriesTEntities ct  " +
            "JOIN FETCH g.eventsEntities e " +
            "JOIN FETCH e.venuesEntity v " +
            "JOIN FETCH v.venuesTEntities vt " +
            "JOIN FETCH e.stagesEntity st " +
            "JOIN FETCH st.stagesTEntities stt " +

            "JOIN FETCH e.genderDisciplinesEntity gd " +
            "JOIN FETCH gd.disciplinesEntity d " +
            "JOIN FETCH d.disciplinesTEntities dt " +
            "JOIN FETCH d.sportsEntity sp " +
            "JOIN FETCH sp.sportsTEntities spt " +

            "WHERE gt.id.locale = :locale AND ct.id.locale = :locale " +
            "  AND vt.id.locale = :locale AND stt.id.locale = :locale " +
            "  AND dt.id.locale = :locale AND spt.id.locale = :locale " +
            "AND g.id = :id AND sp.id = 4")
    Set<GamesEntity> findFullGamesInfoByLocaleAndId(String locale, Long id);


}