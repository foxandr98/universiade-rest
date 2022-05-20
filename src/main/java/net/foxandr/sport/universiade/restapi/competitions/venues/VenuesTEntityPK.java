package net.foxandr.sport.universiade.restapi.competitions.venues;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VenuesTEntityPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonBackReference
    private VenuesEntity venuesEntity;
    @Column(name = "locale")
    private String locale;

    public VenuesEntity getId() {
        return venuesEntity;
    }

    public void setId(VenuesEntity venuesEntity) {
        this.venuesEntity = venuesEntity;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenuesTEntityPK that = (VenuesTEntityPK) o;
        return Objects.equals(venuesEntity, that.venuesEntity) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venuesEntity, locale);
    }
}
