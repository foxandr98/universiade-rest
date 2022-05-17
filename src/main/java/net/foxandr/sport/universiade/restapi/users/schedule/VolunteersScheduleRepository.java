package net.foxandr.sport.universiade.restapi.users.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VolunteersScheduleRepository extends JpaRepository<VolunteersScheduleEntity, Long> {

    @Query("SELECT s FROM VolunteersScheduleEntity s " +
            "LEFT JOIN FETCH s.usersEntity u " +
            "WHERE u.userName = :userName")
    List<VolunteersScheduleEntity> findAllSchedulesByUserName(String userName);

}
