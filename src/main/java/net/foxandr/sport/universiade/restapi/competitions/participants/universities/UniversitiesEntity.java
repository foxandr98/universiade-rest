package net.foxandr.sport.universiade.restapi.competitions.participants.universities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;
import net.foxandr.sport.universiade.restapi.competitions.participants.ParticipantsEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "universities", schema = "universiade")
public class UniversitiesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "universitiesEntity")
    @JsonBackReference
    private Set<ParticipantsEntity> participantsEntities;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonManagedReference
    private CountriesEntity countriesEntity;

    @OneToMany(mappedBy = "id.universitiesEntity")
    @JsonManagedReference
    private Set<UniversitiesTEntity> universitiesTEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversitiesEntity that = (UniversitiesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(website, that.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, website);
    }

    public Set<ParticipantsEntity> getParticipantsEntities() {
        return participantsEntities;
    }

    public void setParticipantsEntities(Set<ParticipantsEntity> participantsEntities) {
        this.participantsEntities = participantsEntities;
    }

    public CountriesEntity getCountriesEntity() {
        return countriesEntity;
    }

    public void setCountriesEntity(CountriesEntity countriesEntity) {
        this.countriesEntity = countriesEntity;
    }

    public Set<UniversitiesTEntity> getUniversitiesTEntities() {
        return universitiesTEntities;
    }

    public void setUniversitiesTEntities(Set<UniversitiesTEntity> universitiesTSById) {
        this.universitiesTEntities = universitiesTSById;
    }
}
