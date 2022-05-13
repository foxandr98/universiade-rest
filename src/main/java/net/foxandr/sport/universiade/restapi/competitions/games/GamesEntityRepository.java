package net.foxandr.sport.universiade.restapi.competitions.games;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GamesEntityRepository extends JpaRepository<GamesEntity, Long> {
//    @Query("SELECT g FROM GamesTEntity gt JOIN FETCH gt.gamesById g WHERE g.id = :id")
//    GamesEntity findGamesEntitiesById(Long id);

    @Query("SELECT g FROM GamesEntity g JOIN FETCH g.gamesTSById gt WHERE gt.gamesTEntityPK.locale = :locale")
    List<GamesEntity> findAllByLocale(String locale);
}
