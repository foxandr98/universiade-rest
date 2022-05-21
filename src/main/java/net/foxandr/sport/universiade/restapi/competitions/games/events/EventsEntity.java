package net.foxandr.sport.universiade.restapi.competitions.games.events;

import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.GenderDisciplinesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.events.stages.StagesEntity;
import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "events", schema = "universiade")
public class EventsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private StagesEntity stagesEntity;

    @ManyToOne
    @JoinColumn(name = "gender_discipline_id")
    private GenderDisciplinesEntity genderDisciplinesEntity;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private VenuesEntity venuesEntity;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GamesEntity gamesEntity;

    @Column(name = "utc_event_time")
    private Instant utcEventTime;

    @Column(name = "is_finished")
    private Boolean isFinished;

}
