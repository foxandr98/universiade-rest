package net.foxandr.sport.universiade.restapi.competitions.venues;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "venues_t", schema = "universiade")
public class VenuesTEntity {

    @EmbeddedId
    @JsonIgnore
    private VenuesTEntityPK id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenuesTEntity that = (VenuesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    public VenuesTEntityPK getId() {
        return id;
    }

    public void setId(VenuesTEntityPK id) {
        this.id = id;
    }
}
