package net.foxandr.sport.universiade.restapi.staff.schedule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.foxandr.sport.universiade.restapi.staff.login.StaffEntity;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "volunteers_schedule", schema = "universiade")
public class VolunteersScheduleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "venue_id")
    private Long venueId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private StaffEntity staffEntity;

    @Column(name = "utc_help_time")
    private Instant utcHelpTime;

    @Column(name = "to_do_list")
    private String toDoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public Instant getUtcHelpTime() {
        return utcHelpTime;
    }

    public void setUtcHelpTime(Instant utcHelpTime) {
        this.utcHelpTime = utcHelpTime;
    }

    public String getToDoList() {
        return toDoList;
    }

    public void setToDoList(String toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolunteersScheduleEntity that = (VolunteersScheduleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(venueId, that.venueId) && Objects.equals(utcHelpTime, that.utcHelpTime) && Objects.equals(toDoList, that.toDoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, venueId, utcHelpTime, toDoList);
    }

    public StaffEntity getStaffEntity() {
        return staffEntity;
    }

    public void setStaffEntity(StaffEntity staffEntity) {
        this.staffEntity = staffEntity;
    }
}
