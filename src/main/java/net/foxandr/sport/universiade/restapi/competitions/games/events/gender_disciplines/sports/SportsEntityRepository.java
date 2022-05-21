package net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.sports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SportsEntityRepository extends JpaRepository<SportsEntity, Long> {

}
