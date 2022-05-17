package net.foxandr.sport.universiade.restapi.users.login.auth;

import net.foxandr.sport.universiade.restapi.users.login.UsersEntity;
import net.foxandr.sport.universiade.restapi.users.login.UsersEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersEntityDetailsService implements UserDetailsService {

    UsersEntityRepository usersEntityRepository;

    public UsersEntityDetailsService(UsersEntityRepository usersEntityRepository) {
        this.usersEntityRepository = usersEntityRepository;
    }

    public UsersEntity getByLogin(String userName){
        return usersEntityRepository.findByUserName(userName).get();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UsersEntity> usersEntity = usersEntityRepository.findByUserName(userName);
        usersEntity.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return new UsersEntityDetails(usersEntity.get());
    }
}
