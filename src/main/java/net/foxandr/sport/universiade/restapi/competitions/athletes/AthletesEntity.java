package net.foxandr.sport.universiade.restapi.competitions.athletes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "athletes", schema = "universiade")
public class AthletesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "sex")
    private String sex;
    @Basic
    @Column(name = "birhday_date")
    private Date birthdayDate;
    @OneToMany(mappedBy = "athletesEntity", fetch = FetchType.LAZY)
    private List<AthletesTEntity> athletesTEntities;

//    @OneToMany(mappedBy = "athletesEntity")
//    @JsonBackReference
//    private List<ParticipantsEntity> participantsEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birhdayDate) {
        this.birthdayDate = birhdayDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthletesEntity that = (AthletesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(sex, that.sex) && Objects.equals(birthdayDate, that.birthdayDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sex, birthdayDate);
    }

    public List<AthletesTEntity> getAthletesTEntities() {
        return athletesTEntities;
    }

    public void setAthletesTSById(List<AthletesTEntity> athletesTEntities) {
        this.athletesTEntities = athletesTEntities;
    }

//    public List<ParticipantsEntity> getParticipantsEntities() {
//        return participantsEntities;
//    }
//
//    public void setParticipantsEntities(List<ParticipantsEntity> participantsEntities) {
//        this.participantsEntities = participantsEntities;
//    }
}
