package net.foxandr.sport.universiade.restapi.competitions.universities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UniversitiesTEntityPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonBackReference
    private UniversitiesEntity universitiesEntity;
    @Column(name = "locale")
    private String locale;


    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public UniversitiesEntity getUniversitiesEntity() {
        return universitiesEntity;
    }

    public void setUniversitiesEntity(UniversitiesEntity universitiesEntity) {
        this.universitiesEntity = universitiesEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversitiesTEntityPK that = (UniversitiesTEntityPK) o;
        return Objects.equals(universitiesEntity, that.universitiesEntity) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universitiesEntity, locale);
    }
}
