package net.foxandr.sport.universiade.restapi.competitions.games.events;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.events.gender_disciplines.GenderDisciplinesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.events.stages.StagesEntity;
import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesEntity;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "events", schema = "universiade")
public class EventsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage_id")
    @JsonManagedReference
    private StagesEntity stagesEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_discipline_id")
    @JsonManagedReference
    private GenderDisciplinesEntity genderDisciplinesEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    @JsonManagedReference
    private VenuesEntity venuesEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    @JsonBackReference
    private GamesEntity gamesEntity;

    @OneToMany(mappedBy = "id.eventsEntity", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<EventsCompetitorsEntity> eventsCompetitorsEntity;


    @Column(name = "utc_event_time")
    private Instant utcEventTime;

    @Column(name = "is_finished")
    private Boolean isFinished;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StagesEntity getStagesEntity() {
        return stagesEntity;
    }

    public void setStagesEntity(StagesEntity stagesEntity) {
        this.stagesEntity = stagesEntity;
    }

    public GenderDisciplinesEntity getGenderDisciplinesEntity() {
        return genderDisciplinesEntity;
    }

    public void setGenderDisciplinesEntity(GenderDisciplinesEntity genderDisciplinesEntity) {
        this.genderDisciplinesEntity = genderDisciplinesEntity;
    }

    public VenuesEntity getVenuesEntity() {
        return venuesEntity;
    }

    public void setVenuesEntity(VenuesEntity venuesEntity) {
        this.venuesEntity = venuesEntity;
    }

    public Set<EventsCompetitorsEntity> getEventsCompetitorsEntity() {
        return eventsCompetitorsEntity;
    }

    public void setEventsCompetitorsEntity(Set<EventsCompetitorsEntity> eventsCompetitorsEntity) {
        this.eventsCompetitorsEntity = eventsCompetitorsEntity;
    }

    public Instant getUtcEventTime() {
        return utcEventTime;
    }

    public void setUtcEventTime(Instant utcEventTime) {
        this.utcEventTime = utcEventTime;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public GamesEntity getGamesEntity() {
        return gamesEntity;
    }

    public void setGamesEntity(GamesEntity gamesEntity) {
        this.gamesEntity = gamesEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsEntity that = (EventsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(utcEventTime, that.utcEventTime) && Objects.equals(isFinished, that.isFinished);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, utcEventTime, isFinished);
    }
}
