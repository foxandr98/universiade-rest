package net.foxandr.sport.universiade.restapi.competitions.venues;

import java.math.BigDecimal;

public interface VenuesDTOProjection {

    Long getId();
    BigDecimal getLongitude();
    BigDecimal getLatitude();
    String getName();
    String getAddress();
    Boolean getForCompetition();

}
