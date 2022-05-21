package net.foxandr.sport.universiade.restapi.competitions.participants;

import net.foxandr.sport.universiade.restapi.competitions.games.GamesParticipantsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ParticipantsEntityRepository extends JpaRepository<ParticipantsEntity, Long> {

    @Query("SELECT p " +
            "FROM ParticipantsEntity p " +
            "JOIN FETCH p.athletesEntity a " +
            "JOIN FETCH a.athletesTEntities at " +
            "WHERE at.id.locale = :locale")
    List<ParticipantsEntity> findParticipantsEntitiesByLocale(String locale);


    @Query("SELECT p as participantsEntity " +
            "FROM ParticipantsEntity p " +
            "JOIN FETCH p.gamesEntity g  " +
            "JOIN FETCH p.athletesEntity a " +
            "JOIN FETCH a.athletesTEntities at " +
            "JOIN FETCH p.universitiesEntity u " +
            "JOIN FETCH u.universitiesTEntities ut " +
            "JOIN FETCH u.countriesEntity uc " +
            "JOIN FETCH uc.countriesTEntities uct  " +

            "WHERE at.id.locale = :locale AND ut.id.locale = :locale " +
            "AND uct.id.locale = :locale AND g.id = :id")
    Set<ParticipantsEntity> findAllParticipantsByLocaleAndId(String locale, Long id);


}
