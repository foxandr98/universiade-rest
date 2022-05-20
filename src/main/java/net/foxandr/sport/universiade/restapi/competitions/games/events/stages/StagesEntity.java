package net.foxandr.sport.universiade.restapi.competitions.games.events.stages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stages", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StagesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "stage_code")
    private String stageCode;

    @OneToMany(mappedBy = "id.stagesEntity")
    @JsonManagedReference
    private Set<StagesTEntity> stagesTEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String stageCode) {
        this.stageCode = stageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StagesEntity that = (StagesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(stageCode, that.stageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stageCode);
    }

    public Set<StagesTEntity> getStagesTEntities() {
        return stagesTEntities;
    }

    public void setStagesTEntities(Set<StagesTEntity> stagesTEntities) {
        this.stagesTEntities = stagesTEntities;
    }
}
