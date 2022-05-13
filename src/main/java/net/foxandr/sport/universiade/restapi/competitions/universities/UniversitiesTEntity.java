package net.foxandr.sport.universiade.restapi.competitions.universities;

import net.foxandr.sport.universiade.restapi.LanguagesEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "universities_t", schema = "universiade")
@IdClass(UniversitiesTEntityPK.class)
public class UniversitiesTEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Id
    @Column(name = "locale")
    private String locale;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "abbreviation")
    private String abbreviation;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private UniversitiesEntity universitiesById;
    @ManyToOne
    @JoinColumn(name = "locale", referencedColumnName = "locale", nullable = false, insertable = false, updatable = false)
    private LanguagesEntity languagesByLocale;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversitiesTEntity that = (UniversitiesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(locale, that.locale) && Objects.equals(name, that.name) && Objects.equals(abbreviation, that.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locale, name, abbreviation);
    }

    public UniversitiesEntity getUniversitiesById() {
        return universitiesById;
    }

    public void setUniversitiesById(UniversitiesEntity universitiesById) {
        this.universitiesById = universitiesById;
    }

    public LanguagesEntity getLanguagesByLocale() {
        return languagesByLocale;
    }

    public void setLanguagesByLocale(LanguagesEntity languagesByLocale) {
        this.languagesByLocale = languagesByLocale;
    }
}
