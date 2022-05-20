package net.foxandr.sport.universiade.restapi.competitions.participants;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.athletes.AthletesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntity;
import net.foxandr.sport.universiade.restapi.competitions.universities.UniversitiesEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "participants", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParticipantsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "height")
    private Short height;

    @Column(name = "weight")
    private Short weight;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "game_id")
    private GamesEntity gamesEntity;
//    @ManyToOne
//    @JoinColumn(name = "play_university_id", referencedColumnName = "id", nullable = false)
//    private UniversitiesEntity universitiesByPlayUniversityId;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "athlete_id")
    private AthletesEntity athletesEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public GamesEntity getGamesEntity() {
        return gamesEntity;
    }

    public void setGamesEntity(GamesEntity gamesEntity) {
        this.gamesEntity = gamesEntity;
    }

//    public UniversitiesEntity getUniversitiesByPlayUniversityId() {
//        return universitiesByPlayUniversityId;
//    }
//
//    public void setUniversitiesByPlayUniversityId(UniversitiesEntity universitiesByPlayUniversityId) {
//        this.universitiesByPlayUniversityId = universitiesByPlayUniversityId;
//    }

    public AthletesEntity getAthletesEntity() {
        return athletesEntity;
    }

    public void setAthletesEntity(AthletesEntity athletesEntity) {
        this.athletesEntity = athletesEntity;
    }
}
