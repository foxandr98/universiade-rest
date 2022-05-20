package net.foxandr.sport.universiade.restapi.competitions.participants.universities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.countries.CountriesEntity;

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

//    @OneToMany(mappedBy = "universitiesByPlayUniversityId")
//    private Collection<ParticipantsEntity> participantsById;
    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonManagedReference
    private CountriesEntity countriesByCountryId;
    @OneToMany(mappedBy = "id.universitiesEntity")
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

//    public Collection<ParticipantsEntity> getParticipantsById() {
//        return participantsById;
//    }

//    public void setParticipantsById(Collection<ParticipantsEntity> participantsById) {
//        this.participantsById = participantsById;
//    }

    public CountriesEntity getCountriesByCountryId() {
        return countriesByCountryId;
    }

    public void setCountriesByCountryId(CountriesEntity countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }

    public Set<UniversitiesTEntity> getUniversitiesTEntities() {
        return universitiesTEntities;
    }

    public void setUniversitiesTEntities(Set<UniversitiesTEntity> universitiesTSById) {
        this.universitiesTEntities = universitiesTSById;
    }
}
