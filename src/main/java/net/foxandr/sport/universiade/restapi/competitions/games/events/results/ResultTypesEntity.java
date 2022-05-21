package net.foxandr.sport.universiade.restapi.competitions.games.events.results;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "result_types", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ResultTypesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "is_win")
    private Boolean isWin;

    @OneToMany(mappedBy = "id.resultTypesEntity")
    @JsonManagedReference
    private Set<ResultTypesTEntity> resultTypesTEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(Boolean isWin) {
        this.isWin = isWin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultTypesEntity that = (ResultTypesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(isWin, that.isWin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isWin);
    }

    public Set<ResultTypesTEntity> getResultTypesTEntities() {
        return resultTypesTEntities;
    }

    public void setResultTypesTEntities(Set<ResultTypesTEntity> resultTypesTEntities) {
        this.resultTypesTEntities = resultTypesTEntities;
    }

    public Boolean getWin() {
        return isWin;
    }

    public void setWin(Boolean win) {
        isWin = win;
    }
}
