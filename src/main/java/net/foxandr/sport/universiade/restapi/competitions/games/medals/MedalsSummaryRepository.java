package net.foxandr.sport.universiade.restapi.competitions.games.medals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedalsSummaryRepository extends JpaRepository<MedalsSummaryEntity, Long> {
    @Query(value = "CALL SP_GET_MEDALS_BY_LOCALE_AND_GAME_ID(:locale, :gameId);", nativeQuery = true)
    List<MedalsSummaryEntity> getMedalsSummaryByLocaleAndGameId(@Param("locale") String locale,
                                                                @Param("gameId") Long gameId);

}
