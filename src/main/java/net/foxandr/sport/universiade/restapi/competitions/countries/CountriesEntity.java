package net.foxandr.sport.universiade.restapi.competitions.countries;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesEntity;
import net.foxandr.sport.universiade.restapi.competitions.games.GamesTEntity;
import net.foxandr.sport.universiade.restapi.competitions.participants.universities.UniversitiesEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    private Set<CountriesTEntity> countriesTEntities;

    @OneToMany(mappedBy = "countriesEntity", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<GamesEntity> gamesEntities;

    @OneToMany(mappedBy = "countriesEntity", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<UniversitiesEntity> universitiesEntities;

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

    public Set<CountriesTEntity> getCountriesTEntities() {
        return countriesTEntities;
    }

    public void setCountriesTEntities(Set<CountriesTEntity> countriesTEntities) {
        this.countriesTEntities = countriesTEntities;
    }

    public Set<UniversitiesEntity> getUniversitiesEntities() {
        return universitiesEntities;
    }

    public void setUniversitiesEntities(Set<UniversitiesEntity> universitiesEntities) {
        this.universitiesEntities = universitiesEntities;
    }


    public Set<GamesEntity> getGamesEntities() {
        return gamesEntities;
    }

    public void setGamesEntities(Set<GamesEntity> gamesEntities) {
        this.gamesEntities = gamesEntities;
    }
}
