package net.foxandr.sport.universiade.restapi.competitions.games;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;
import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "games")
public class GamesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "game_year")
    private Short gameYear;

    @Column(name = "is_summer")
    private Boolean isSummer;
    @JsonManagedReference
    @OneToMany(mappedBy = "gamesEntity")
    private List<GamesTEntity> gamesTEntities;

    public List<ParticipantsEntity> getParticipantsEntities() {
        return participantsEntities;
    }

    public void setParticipantsEntities(List<ParticipantsEntity> participantsEntities) {
        this.participantsEntities = participantsEntities;
    }

    @OneToMany(mappedBy = "gamesEntity")
    @JsonManagedReference
    private List<ParticipantsEntity> participantsEntities;



//    @ManyToOne
//    @JoinColumn(name = "country_id")
//    private CountriesEntity countriesByCountryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Short getGameYear() {
        return gameYear;
    }

    public void setGameYear(Short gameYear) {
        this.gameYear = gameYear;
    }

    public Boolean getIsSummer() {
        return isSummer;
    }

    public void setIsSummer(Boolean isSummer) {
        this.isSummer = isSummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesEntity that = (GamesEntity) o;
        return id.equals(that.id) && gameYear.equals(that.gameYear) == that.isSummer && Objects.equals(codeName, that.codeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeName, gameYear, isSummer);
    }

    public List<GamesTEntity> getGamesTEntities() {
        return gamesTEntities;
    }

    public void setGamesTEntities(List<GamesTEntity> gamesTEntities) {
        this.gamesTEntities = gamesTEntities;
    }

//    public CountriesEntity getCountriesByCountryId() {
//        return countriesByCountryId;
//    }
//
//    public void setCountriesByCountryId(CountriesEntity countriesByCountryId) {
//        this.countriesByCountryId = countriesByCountryId;
//    }

    public GamesEntity(Long id, String codeName, Short gameYear, Boolean isSummer, List<GamesTEntity> gamesTEntities) {
        this.id = id;
        this.codeName = codeName;
        this.gameYear = gameYear;
        this.isSummer = isSummer;
        this.gamesTEntities = gamesTEntities;
    }
    public GamesEntity() { }

}
