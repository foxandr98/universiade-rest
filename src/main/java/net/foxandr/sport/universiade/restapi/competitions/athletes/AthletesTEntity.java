package net.foxandr.sport.universiade.restapi.competitions.athletes;

import net.foxandr.sport.universiade.restapi.LanguagesEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "athletes_t", schema = "universiade")
@IdClass(AthletesTEntityPK.class)
public class AthletesTEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Id
    @Column(name = "locale")
    private String locale;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "middle_name")
    private String middleName;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private AthletesEntity athletesById;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthletesTEntity that = (AthletesTEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(locale, that.locale) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(middleName, that.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locale, firstName, lastName, middleName);
    }

    public AthletesEntity getAthletesById() {
        return athletesById;
    }

    public void setAthletesById(AthletesEntity athletesById) {
        this.athletesById = athletesById;
    }

    public LanguagesEntity getLanguagesByLocale() {
        return languagesByLocale;
    }

    public void setLanguagesByLocale(LanguagesEntity languagesByLocale) {
        this.languagesByLocale = languagesByLocale;
    }
}
