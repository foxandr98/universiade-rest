package net.foxandr.sport.universiade.restapi.users.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersEntityRepository extends JpaRepository<UsersEntity, Long> {
    @Query("SELECT u FROM UsersEntity u " +
            "JOIN FETCH u.userRolesEntity ur " +
            "LEFT JOIN FETCH u.volunteersSchedulesEntities s " +
            "WHERE u.userName = :userName")
    Optional<UsersEntity> findByUserName(String userName);
}
