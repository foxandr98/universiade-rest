package net.foxandr.sport.universiade.restapi.competitions.countries;

import net.foxandr.sport.universiade.restapi.LanguagesEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "countries_t", schema = "universiade")
@IdClass(CountriesTEntityPK.class)
public class CountriesTEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Id
    @Column(name = "locale")
    private String locale;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private CountriesEntity countriesById;
    @ManyToOne
    @JoinColumn(name = "locale", referencedColumnName = "locale", nullable = false, insertable = false, updatable = false)
    private LanguagesEntity languagesByLocale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesTEntity that = (CountriesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(locale, that.locale) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locale, name);
    }

    public CountriesEntity getCountriesById() {
        return countriesById;
    }

    public void setCountriesById(CountriesEntity countriesById) {
        this.countriesById = countriesById;
    }

    public LanguagesEntity getLanguagesByLocale() {
        return languagesByLocale;
    }

    public void setLanguagesByLocale(LanguagesEntity languagesByLocale) {
        this.languagesByLocale = languagesByLocale;
    }
}
