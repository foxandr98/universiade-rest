package net.foxandr.sport.universiade.restapi.competitions.games;

import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GamesEntityRepository extends JpaRepository<GamesEntity, Long> {

    @Query("SELECT g FROM GamesEntity g JOIN FETCH g.gamesTEntities gt " +
            "WHERE gt.id.locale = :locale AND g.id = :id")
    GamesEntity findGamesEntityByLocaleAndId(String locale, Long id);

    @Query("SELECT g FROM GamesEntity g " +
            "JOIN FETCH g.gamesTEntities gt " +
            "JOIN FETCH g.countriesEntity c " +
            "JOIN FETCH c.countriesTEntities ct " +
            "WHERE gt.id.locale = :locale AND ct.id.locale = :locale")
    List<GamesEntity> findGamesEntitiesByLocale(String locale);

//    @Query("SELECT g " +
//            "FROM GamesEntity g " +
//            "JOIN FETCH g.participantsEntities p " +
//            "JOIN FETCH p.athletesEntity a " +
//            "JOIN FETCH a.athletesTEntities at " +
//            "WHERE at.locale = :locale AND g.id = :gameId")
//    List<GamesEntity> findParticipantsEntitiesByGameIdAndLocale(Long gameId, String locale);


}
