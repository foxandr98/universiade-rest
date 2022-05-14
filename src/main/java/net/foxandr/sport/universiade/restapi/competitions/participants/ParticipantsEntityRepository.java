package net.foxandr.sport.universiade.restapi.competitions.participants;

import net.foxandr.sport.universiade.restapi.competitions.athletes.AthletesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantsEntityRepository extends JpaRepository<ParticipantsEntity, Long> {

    @Query("SELECT p " +
            "FROM ParticipantsEntity p " +
            "JOIN FETCH p.athletesEntity a " +
            "JOIN FETCH a.athletesTEntities at " +
            "WHERE at.locale = :locale AND at.id = :id")
    ParticipantsEntity findParticipantsEntityByLocaleAndId(String locale, Long id);

    @Query("SELECT p " +
            "FROM ParticipantsEntity p " +
            "JOIN FETCH p.athletesEntity a " +
            "JOIN FETCH a.athletesTEntities at " +
            "WHERE at.locale = :locale")
    List<ParticipantsEntity> findParticipantsEntitiesByLocale(String locale);

    @Query("SELECT p " +
            "FROM ParticipantsEntity p " +
            "JOIN FETCH p.athletesEntity a " +
            "JOIN FETCH a.athletesTEntities at " +
            "JOIN FETCH p.gamesEntity g " +
            "WHERE at.locale = :locale AND g.id = :gameId")
    List<ParticipantsEntity> findParticipantsEntitiesByGameIdAndLocale(Long gameId, String locale);


}
