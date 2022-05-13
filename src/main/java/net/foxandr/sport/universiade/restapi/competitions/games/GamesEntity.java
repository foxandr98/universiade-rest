package net.foxandr.sport.universiade.restapi.competitions.games;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;

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
    @OneToMany(mappedBy = "gamesById")
    private List<GamesTEntity> gamesTSById;

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

    public List<GamesTEntity> getGamesTSById() {
        return gamesTSById;
    }

    public void setGamesTSById(List<GamesTEntity> gamesTSById) {
        this.gamesTSById = gamesTSById;
    }

//    public CountriesEntity getCountriesByCountryId() {
//        return countriesByCountryId;
//    }
//
//    public void setCountriesByCountryId(CountriesEntity countriesByCountryId) {
//        this.countriesByCountryId = countriesByCountryId;
//    }

    public GamesEntity(Long id, String codeName, Short gameYear, Boolean isSummer, List<GamesTEntity> gamesTSById) {
        this.id = id;
        this.codeName = codeName;
        this.gameYear = gameYear;
        this.isSummer = isSummer;
        this.gamesTSById = gamesTSById;
    }
    public GamesEntity() { }

}
