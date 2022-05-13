package net.foxandr.sport.universiade.restapi.competitions.games;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;

import javax.persistence.*;
import java.util.Collection;
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
    private short gameYear;

    @Column(name = "is_summer")
    private byte isSummer;
    @JsonManagedReference
    @OneToMany(mappedBy = "gamesById")
    private Collection<GamesTEntity> gamesTSById;

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

    public short getGameYear() {
        return gameYear;
    }

    public void setGameYear(short gameYear) {
        this.gameYear = gameYear;
    }

    public byte getIsSummer() {
        return isSummer;
    }

    public void setIsSummer(byte isSummer) {
        this.isSummer = isSummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesEntity that = (GamesEntity) o;
        return id.equals(that.id) && gameYear == that.gameYear && isSummer == that.isSummer && Objects.equals(codeName, that.codeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeName, gameYear, isSummer);
    }

    public Collection<GamesTEntity> getGamesTSById() {
        return gamesTSById;
    }

    public void setGamesTSById(Collection<GamesTEntity> gamesTSById) {
        this.gamesTSById = gamesTSById;
    }

//    public CountriesEntity getCountriesByCountryId() {
//        return countriesByCountryId;
//    }
//
//    public void setCountriesByCountryId(CountriesEntity countriesByCountryId) {
//        this.countriesByCountryId = countriesByCountryId;
//    }
}
