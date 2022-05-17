package net.foxandr.sport.universiade.restapi.users.login;

import net.foxandr.sport.universiade.restapi.users.login.auth.UsersEntityDetailsService;
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

//    @PostMapping("/login")
//    public UsersEntity loginAndGetToken(){
//        return usersEntityDetailsService.getByLogin();
//    }

}
