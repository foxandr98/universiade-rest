package net.foxandr.sport.universiade.restapi.competitions.games.events.results;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResultTypesTEntityPK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonBackReference
    private ResultTypesEntity resultTypesEntity;

    @Column(name = "locale")
    private String locale;

    public ResultTypesEntity getResultTypesEntity() {
        return resultTypesEntity;
    }

    public void setResultTypesEntity(ResultTypesEntity resultTypesEntity) {
        this.resultTypesEntity = resultTypesEntity;
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
        ResultTypesTEntityPK that = (ResultTypesTEntityPK) o;
        return Objects.equals(resultTypesEntity, that.resultTypesEntity) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultTypesEntity, locale);
    }
}
