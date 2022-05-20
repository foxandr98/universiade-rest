package net.foxandr.sport.universiade.restapi.competitions.participants.athletes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AthletesEntityRepository extends JpaRepository<AthletesEntity, Long> {

    @Query("SELECT a FROM AthletesEntity a " +
            "JOIN FETCH a.athletesTEntities at " +
            "WHERE at.id.locale = :locale AND a.id = :id")
    AthletesEntity findAthletesEntityByLocaleAndId(String locale, Long id);

    @Query("SELECT a FROM AthletesEntity a " +
            "JOIN FETCH a.athletesTEntities at " +
            "WHERE at.id.locale = :locale")
    List<AthletesEntity> findAthletesEntityByLocale(String locale);

}
