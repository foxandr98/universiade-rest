package net.foxandr.sport.universiade.restapi.competitions.games.events;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;

public interface EventsDTOProjection {

    Long getId();

    String getStageName();

    Long getVenueId();

    String getDisciplineName();

    Boolean getIsIndividual();

    String getGenderType();

    Instant getUtcEventTime();

    Boolean getIsFinished();

}
