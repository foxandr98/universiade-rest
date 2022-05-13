package net.foxandr.sport.universiade.restapi.competitions.participants;

import net.foxandr.sport.universiade.restapi.competitions.athletes.AthletesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntity;
import net.foxandr.sport.universiade.restapi.competitions.universities.UniversitiesEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "participants", schema = "universiade")
public class ParticipantsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "height")
    private Short height;
    @Basic
    @Column(name = "weight")
    private Short weight;
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false)
    private GamesEntity gamesByGameId;
    @ManyToOne
    @JoinColumn(name = "play_university_id", referencedColumnName = "id", nullable = false)
    private UniversitiesEntity universitiesByPlayUniversityId;
    @ManyToOne
    @JoinColumn(name = "athlete_id", referencedColumnName = "id", nullable = false)
    private AthletesEntity athletesByAthleteId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantsEntity that = (ParticipantsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, weight);
    }

    public GamesEntity getGamesByGameId() {
        return gamesByGameId;
    }

    public void setGamesByGameId(GamesEntity gamesByGameId) {
        this.gamesByGameId = gamesByGameId;
    }

    public UniversitiesEntity getUniversitiesByPlayUniversityId() {
        return universitiesByPlayUniversityId;
    }

    public void setUniversitiesByPlayUniversityId(UniversitiesEntity universitiesByPlayUniversityId) {
        this.universitiesByPlayUniversityId = universitiesByPlayUniversityId;
    }

    public AthletesEntity getAthletesByAthleteId() {
        return athletesByAthleteId;
    }

    public void setAthletesByAthleteId(AthletesEntity athletesByAthleteId) {
        this.athletesByAthleteId = athletesByAthleteId;
    }
}
