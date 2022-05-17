package net.foxandr.sport.universiade.restapi.users.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/volunteer")
public class VolunteersScheduleController {

    VolunteersEntityService volunteersEntityService;

    @Autowired
    public VolunteersScheduleController(VolunteersEntityService volunteersEntityService) {
        this.volunteersEntityService = volunteersEntityService;
    }

    @GetMapping("/schedule/{userName}")
    public List<VolunteersScheduleEntity> getScheduleByUsername(@PathVariable(name = "userName") String userName){
        return volunteersEntityService.findAllSchedulesByUserName(userName);
    }

}
