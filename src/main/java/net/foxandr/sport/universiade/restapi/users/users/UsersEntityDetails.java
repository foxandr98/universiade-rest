package net.foxandr.sport.universiade.restapi.users.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsersEntityDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean isActive;
    private String role;

    public UsersEntityDetails(UsersEntity usersEntity) {
        this.userName = usersEntity.getUserName();
        this.password = usersEntity.getPasswordHash();
        this.isActive = usersEntity.getIsActive();
        this.role = usersEntity.getUserRolesEntity().getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role)); //ОБЯЗАТЕЛЬНО ПРИСТАВКА "ROLE_"
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
