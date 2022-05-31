package net.foxandr.sport.universiade.restapi.competitions.venues;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.events.EventsEntity;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "for_competitions")
    private Boolean forCompetitions;
    @OneToMany(mappedBy = "id.venuesEntity")
    @JsonManagedReference
    private Set<VenuesTEntity> venuesTEntities;

    @OneToMany(mappedBy = "venuesEntity", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<EventsEntity> eventsEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
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


    public Set<EventsEntity> getEventsEntities() {
        return eventsEntities;
    }

    public void setEventsEntities(Set<EventsEntity> eventsEntities) {
        this.eventsEntities = eventsEntities;
    }
}
