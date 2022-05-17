package net.foxandr.sport.universiade.restapi.users.login;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "universiade")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

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


//    @OneToMany(mappedBy = "usersEntity")
//    @JsonManagedReference
//    private List<VolunteersScheduleEntity> volunteersSchedulesEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userName, that.userName) && Objects.equals(passwordHash, that.passwordHash) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)  && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, passwordHash, firstName, lastName, isActive);
    }

    public UserRolesEntity getUserRolesEntity() {
        return userRolesEntity;
    }

    public void setUserRolesEntity(UserRolesEntity userRolesEntity) {
        this.userRolesEntity = userRolesEntity;
    }
}
