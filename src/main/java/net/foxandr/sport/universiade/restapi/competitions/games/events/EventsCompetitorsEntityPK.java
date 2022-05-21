package net.foxandr.sport.universiade.restapi.competitions.games.events;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EventsCompetitorsEntityPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private EventsEntity eventsEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    @JsonBackReference
    private ParticipantsEntity participantsEntity;

    public EventsEntity getEventsEntity() {
        return eventsEntity;
    }

    public void setEventsEntity(EventsEntity eventsEntity) {
        this.eventsEntity = eventsEntity;
    }

    public ParticipantsEntity getParticipantsEntity() {
        return participantsEntity;
    }

    public void setParticipantsEntity(ParticipantsEntity participantsEntity) {
        this.participantsEntity = participantsEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsCompetitorsEntityPK that = (EventsCompetitorsEntityPK) o;
        return Objects.equals(eventsEntity, that.eventsEntity) && Objects.equals(participantsEntity, that.participantsEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventsEntity, participantsEntity);
    }
}
