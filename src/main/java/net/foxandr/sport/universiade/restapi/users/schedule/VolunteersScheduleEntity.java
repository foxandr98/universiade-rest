package net.foxandr.sport.universiade.restapi.users.schedule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.competitions.venues.VenuesEntity;
import net.foxandr.sport.universiade.restapi.users.users.UsersEntity;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    @JsonManagedReference
    private VenuesEntity venueEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UsersEntity usersEntity;

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

    public VenuesEntity getVenueEntity() {
        return venueEntity;
    }

    public void setVenueEntity(VenuesEntity venueEntity) {
        this.venueEntity = venueEntity;
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
        return Objects.equals(id, that.id) && Objects.equals(venueEntity, that.venueEntity) && Objects.equals(utcHelpTime, that.utcHelpTime) && Objects.equals(toDoList, that.toDoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, venueEntity, utcHelpTime, toDoList);
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
}
