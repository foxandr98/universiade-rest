package net.foxandr.sport.universiade.restapi.competitions.participants.athletes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "athletes", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AthletesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birhday_date")
    private Date birthdayDate;
    @OneToMany(mappedBy = "id.athletesEntity", fetch = FetchType.LAZY)
    private Set<AthletesTEntity> athletesTEntities;

    @OneToMany(mappedBy = "athletesEntity", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<ParticipantsEntity> participantsEntities;

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

    public Set<AthletesTEntity> getAthletesTEntities() {
        return athletesTEntities;
    }

    public void setAthletesTSById(Set<AthletesTEntity> athletesTEntities) {
        this.athletesTEntities = athletesTEntities;
    }

    public Set<ParticipantsEntity> getParticipantsEntities() {
        return participantsEntities;
    }

    public void setParticipantsEntities(Set<ParticipantsEntity> participantsEntities) {
        this.participantsEntities = participantsEntities;
    }
}
