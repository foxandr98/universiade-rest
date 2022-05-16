package net.foxandr.sport.universiade.restapi.staff.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffEntityRepository extends JpaRepository<StaffEntity, Long> {

    @Query("SELECT s FROM StaffEntity s " +
            "JOIN FETCH s.userRolesEntity ur " +
            "LEFT JOIN FETCH s.volunteersSchedulesEntities vs " +
            "WHERE s.loginName = :login")
    StaffEntity findByLoginName(String login);

}
