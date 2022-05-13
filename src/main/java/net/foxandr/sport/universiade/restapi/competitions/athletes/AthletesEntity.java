package net.foxandr.sport.universiade.restapi.competitions.athletes;

import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
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
    @OneToMany(mappedBy = "athletesById")
    private Collection<AthletesTEntity> athletesTSById;
    @OneToMany(mappedBy = "athletesByAthleteId")
    private Collection<ParticipantsEntity> participantsById;

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

    public Date getBirhdayDate() {
        return birthdayDate;
    }

    public void setBirhdayDate(Date birhdayDate) {
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

    public Collection<AthletesTEntity> getAthletesTSById() {
        return athletesTSById;
    }

    public void setAthletesTSById(Collection<AthletesTEntity> athletesTSById) {
        this.athletesTSById = athletesTSById;
    }

    public Collection<ParticipantsEntity> getParticipantsById() {
        return participantsById;
    }

    public void setParticipantsById(Collection<ParticipantsEntity> participantsById) {
        this.participantsById = participantsById;
    }
}
