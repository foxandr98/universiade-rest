package net.foxandr.sport.universiade.restapi.staff.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StaffEntityController {

    StaffEntityService staffEntityService;

    @Autowired
    public StaffEntityController(StaffEntityService staffEntityService) {
        this.staffEntityService = staffEntityService;
    }

    @GetMapping("/users/{login}")
    public StaffEntity getStaffEntityByLogin(@PathVariable("login" ) String login){
        return staffEntityService.getByLogin(login);
    }

}
