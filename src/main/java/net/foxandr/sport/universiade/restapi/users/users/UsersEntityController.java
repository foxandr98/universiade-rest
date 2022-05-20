package net.foxandr.sport.universiade.restapi.users.users;

import net.foxandr.sport.universiade.restapi.exceptions.AnonymousRoleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("/login")
    public Object getStaffEntityByLogin(@CurrentSecurityContext(expression = "authentication")
                                                 Authentication authentication){
        return authentication.getPrincipal();
    }
}
