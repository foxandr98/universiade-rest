package net.foxandr.sport.universiade.restapi.competitions.venues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "venues", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VenuesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "for_competitions")
    private Boolean forCompetitions;
    @OneToMany(mappedBy = "id.venuesEntity")
    @JsonManagedReference
    private Set<VenuesTEntity> venuesTEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Boolean getForCompetitions() {
        return forCompetitions;
    }

    public void setForCompetitions(Boolean forCompetitions) {
        this.forCompetitions = forCompetitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenuesEntity that = (VenuesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(longitude, that.longitude) && Objects.equals(latitude, that.latitude) && Objects.equals(forCompetitions, that.forCompetitions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longitude, latitude, forCompetitions);
    }

    public Set<VenuesTEntity> getVenuesTEntities() {
        return venuesTEntities;
    }

    public void setVenuesTEntities(Set<VenuesTEntity> venuesTEntities) {
        this.venuesTEntities = venuesTEntities;
    }
}
