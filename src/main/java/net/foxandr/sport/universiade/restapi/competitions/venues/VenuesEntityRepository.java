package net.foxandr.sport.universiade.restapi.competitions.venues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VenuesEntityRepository extends JpaRepository<VenuesEntity, Long> {
    @Query("SELECT DISTINCT v.id as id, v.longitude as longitude, v.latitude as latitude, " +
            "vt.name as name, vt.address as address, v.forCompetitions as forCompetition " +
            "FROM VenuesEntity v " +
            "LEFT JOIN v.eventsEntities e " +
            "LEFT JOIN v.venuesTEntities vt " +
            "LEFT JOIN e.gamesEntity g " +
            "WHERE vt.id.locale = :locale " +
            "AND (g.id = :id OR v.forCompetitions = false)")
    List<VenuesDTOProjection> findDistinctVenuesByLocaleAndGameId(String locale, Long id);

}
