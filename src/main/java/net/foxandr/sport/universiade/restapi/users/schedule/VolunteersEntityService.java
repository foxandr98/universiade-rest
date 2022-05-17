package net.foxandr.sport.universiade.restapi.users.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteersEntityService {
    VolunteersScheduleRepository volunteersScheduleRepository;

    @Autowired
    public VolunteersEntityService(VolunteersScheduleRepository volunteersScheduleRepository) {
        this.volunteersScheduleRepository = volunteersScheduleRepository;
    }

    public List<VolunteersScheduleEntity> findAllSchedulesByUserName(String userName){
        return volunteersScheduleRepository.findAllSchedulesByUserName(userName);
//        List<VolunteersScheduleEntity> scheduleEntities =  volunteerScheduleRepository.findAllSchedulesByUserName(userName);
//        for(VolunteersScheduleEntity schedule : scheduleEntities){
//
//        }
    }
}
