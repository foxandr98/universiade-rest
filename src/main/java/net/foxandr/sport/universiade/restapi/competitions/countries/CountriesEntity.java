package net.foxandr.sport.universiade.restapi.competitions.countries;

import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntity;
import net.foxandr.sport.universiade.restapi.competitions.universities.UniversitiesEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "universiade")
public class CountriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "ioc_name")
    private String iocName;
    @OneToMany(mappedBy = "countriesById")
    private Collection<CountriesTEntity> countriesTSById;
//    @OneToMany(mappedBy = "countriesByCountryId")
//    private Collection<GamesEntity> gamesById;
    @OneToMany(mappedBy = "countriesByCountryId")
    private Collection<UniversitiesEntity> universitiesById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIocName() {
        return iocName;
    }

    public void setIocName(String iocName) {
        this.iocName = iocName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesEntity that = (CountriesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(iocName, that.iocName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iocName);
    }

    public Collection<CountriesTEntity> getCountriesTSById() {
        return countriesTSById;
    }

    public void setCountriesTSById(Collection<CountriesTEntity> countriesTSById) {
        this.countriesTSById = countriesTSById;
    }

//    public Collection<GamesEntity> getGamesById() {
//        return gamesById;
//    }
//
//    public void setGamesById(Collection<GamesEntity> gamesById) {
//        this.gamesById = gamesById;
//    }

    public Collection<UniversitiesEntity> getUniversitiesById() {
        return universitiesById;
    }

    public void setUniversitiesById(Collection<UniversitiesEntity> universitiesById) {
        this.universitiesById = universitiesById;
    }
}
