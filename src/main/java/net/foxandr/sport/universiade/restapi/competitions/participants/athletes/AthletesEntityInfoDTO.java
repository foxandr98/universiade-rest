package net.foxandr.sport.universiade.restapi.competitions.participants.athletes;

import java.sql.Date;

public class AthletesEntityInfoDTO {

    private final AthletesEntity athletesEntity;
    private final AthletesTEntity athletesTEntity;

    public AthletesEntityInfoDTO(AthletesEntity athletesEntity, AthletesTEntity athletesTEntity) {
        this.athletesEntity = athletesEntity;
        this.athletesTEntity = athletesTEntity;
    }

    public Long getId(){
        return  athletesEntity.getId();
    }

    public String getSex(){
        return  athletesEntity.getSex();
    }

    public String getLocaledFirstName(){
        return athletesTEntity.getFirstName();
    }

    public String getLocaledLastName(){
        return athletesTEntity.getLastName();
    }

    public String getLocaledMiddleName(){
        return athletesTEntity.getMiddleName();
    }

    public Date getBirthdayDate(){
        return athletesEntity.getBirthdayDate();
    }
}
