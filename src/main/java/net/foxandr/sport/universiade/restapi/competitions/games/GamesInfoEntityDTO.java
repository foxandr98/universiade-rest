package net.foxandr.sport.universiade.restapi.competitions.games;

public class GamesInfoEntityDTO {

    private final GamesEntity gamesEntity;
    private final GamesTEntity gamesTEntity;

    public GamesInfoEntityDTO(GamesEntity gamesEntity, GamesTEntity gamesTEntity) {
        this.gamesEntity = gamesEntity;
        this.gamesTEntity = gamesTEntity;
    }

    public Long getId(){
        return gamesEntity.getId();
    }

    public String getLocaledCodeName(){
        return gamesEntity.getCodeName();
    }

    public Short getGameYear(){
        return gamesEntity.getGameYear();
    }

    public Boolean getIsSummer(){
        return gamesEntity.getIsSummer();
    }

    public String getLocaledGameName(){
        return gamesTEntity.getName();
    }

    public String getLocaledCityName(){
        return gamesTEntity.getCityName();
    }
}
