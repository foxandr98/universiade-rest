package net.foxandr.sport.universiade.restapi.users.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsersEntityController {

    UsersEntityDetailsService usersEntityDetailsService;

    @Autowired
    public UsersEntityController(UsersEntityDetailsService usersEntityDetailsService) {
        this.usersEntityDetailsService = usersEntityDetailsService;
    }

    @GetMapping("/admin/users/{login}")
    public UsersEntity getStaffEntityByLogin(@PathVariable("login") String login){
        return usersEntityDetailsService.getByLogin(login);
    }
}
