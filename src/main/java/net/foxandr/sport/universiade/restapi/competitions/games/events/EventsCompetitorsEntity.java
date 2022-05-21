package net.foxandr.sport.universiade.restapi.competitions.games.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.games.events.results.ResultTypesEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "events_competitors", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EventsCompetitorsEntity {

    @EmbeddedId
    @JsonIgnore
    private EventsCompetitorsEntityPK id;

    @Column(name = "part_number")
    private Integer partNumber;

    @Column(name = "lane_number")
    private Integer laneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_type_id")
    @JsonManagedReference
    private ResultTypesEntity resultTypesEntity;

    public EventsCompetitorsEntityPK getId() {
        return id;
    }

    public void setId(EventsCompetitorsEntityPK id) {
        this.id = id;
    }

    public Integer getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(Integer partNumber) {
        this.partNumber = partNumber;
    }

    public Integer getLaneNumber() {
        return laneNumber;
    }

    public void setLaneNumber(Integer laneNumber) {
        this.laneNumber = laneNumber;
    }


    public ResultTypesEntity getResultTypesEntity() {
        return resultTypesEntity;
    }

    public void setResultTypesEntity(ResultTypesEntity resultTypesEntity) {
        this.resultTypesEntity = resultTypesEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsCompetitorsEntity that = (EventsCompetitorsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(partNumber, that.partNumber) && Objects.equals(laneNumber, that.laneNumber)  && Objects.equals(resultTypesEntity, that.resultTypesEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partNumber, laneNumber, resultTypesEntity, resultTypesEntity);
    }
}
