package net.foxandr.sport.universiade.restapi.users.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VolunteersScheduleRepository extends JpaRepository<VolunteersScheduleEntity, Long> {

    @Query("SELECT s FROM VolunteersScheduleEntity s " +
            "LEFT JOIN FETCH s.usersEntity u " +
            "JOIN FETCH s.venuesEntity v " +
            "JOIN FETCH v.venuesTEntities vt " +
            "WHERE u.userName = :userName AND vt.id.locale = 'ru' " +
            "ORDER BY s.utcHelpTime DESC ")
    List<VolunteersScheduleEntity> findAllSchedulesByUserName(String userName);

}
