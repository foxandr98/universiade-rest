package net.foxandr.sport.universiade.restapi.competitions.games;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "games", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @OneToMany(mappedBy = "id.gamesEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<GamesTEntity> gamesTEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    @JsonManagedReference
    private CountriesEntity countriesEntity;


    @OneToMany(mappedBy = "gamesEntity")
    @JsonManagedReference
    private Set<EventsEntity> eventsEntities;


//    @OneToMany(mappedBy = "gamesEntity")
//    @JsonManagedReference
//    private List<ParticipantsEntity> participantsEntities;
//


//    public List<ParticipantsEntity> getParticipantsEntities() {
//        return participantsEntities;
//    }
//
//    public void setParticipantsEntities(List<ParticipantsEntity> participantsEntities) {
//        this.participantsEntities = participantsEntities;
//    }

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

    public Set<GamesTEntity> getGamesTEntities() {
        return gamesTEntities;
    }

    public void setGamesTEntities(Set<GamesTEntity> gamesTEntities) {
        this.gamesTEntities = gamesTEntities;
    }

    public Set<EventsEntity> getEventsEntities() {
        return eventsEntities;
    }

    public void setEventsEntities(Set<EventsEntity> eventsEntities) {
        this.eventsEntities = eventsEntities;
    }

    public GamesEntity(Long id, String codeName, Short gameYear, Boolean isSummer, Set<GamesTEntity> gamesTEntities) {
        this.id = id;
        this.codeName = codeName;
        this.gameYear = gameYear;
        this.isSummer = isSummer;
        this.gamesTEntities = gamesTEntities;
    }
    public GamesEntity() { }

    public CountriesEntity getCountriesEntity() {
        return countriesEntity;
    }

    public void setCountriesEntity(CountriesEntity countriesEntity) {
        this.countriesEntity = countriesEntity;
    }
}
