package net.foxandr.sport.universiade.restapi.competitions.games;

public interface GamesDTOProjection {
    Long getId();
    String getCodeName();
    String getGameName();
    String getCountryName();
    Short getGameYear();
    Boolean getIsSummer();
}
