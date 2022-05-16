package net.foxandr.sport.universiade.restapi.staff.login;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.staff.schedule.VolunteersScheduleEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "staff", schema = "universiade")
public class StaffEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private UserRolesEntity userRolesEntity;

    @OneToMany(mappedBy = "staffEntity")
    @JsonManagedReference
    private List<VolunteersScheduleEntity> volunteersSchedulesEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(loginName, that.loginName) && Objects.equals(passwordHash, that.passwordHash) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)  && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loginName, passwordHash, firstName, lastName, isActive);
    }

    public UserRolesEntity getUserRolesEntity() {
        return userRolesEntity;
    }

    public void setUserRolesEntity(UserRolesEntity userRolesEntity) {
        this.userRolesEntity = userRolesEntity;
    }

    public List<VolunteersScheduleEntity> getVolunteersSchedulesEntities() {
        return volunteersSchedulesEntities;
    }

    public void setVolunteersSchedulesEntities(List<VolunteersScheduleEntity> volunteersSchedulesEntities) {
        this.volunteersSchedulesEntities = volunteersSchedulesEntities;
    }


}
