package net.foxandr.sport.universiade.restapi.competitions.countries;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntity;
import net.foxandr.sport.universiade.restapi.competitions.universities.UniversitiesEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CountriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ioc_name")
    private String iocName;

    @OneToMany(mappedBy = "id.countriesEntity")
    @JsonManagedReference
    private List<CountriesTEntity> countriesTEntities;

    @OneToMany(mappedBy = "countriesEntity", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<GamesEntity> gamesById;

//    @OneToMany(mappedBy = "countriesByCountryId")
//    private List<UniversitiesEntity> universitiesById;

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

    public List<CountriesTEntity> getCountriesTEntities() {
        return countriesTEntities;
    }

    public void setCountriesTEntities(List<CountriesTEntity> countriesTEntities) {
        this.countriesTEntities = countriesTEntities;
    }

    //    public List<UniversitiesEntity> getUniversitiesById() {
//        return universitiesById;
//    }
//
//    public void setUniversitiesById(List<UniversitiesEntity> universitiesById) {
//        this.universitiesById = universitiesById;
//    }


    public List<GamesEntity> getGamesById() {
        return gamesById;
    }

    public void setGamesById(List<GamesEntity> gamesById) {
        this.gamesById = gamesById;
    }
}
