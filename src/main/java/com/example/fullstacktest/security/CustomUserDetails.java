package com.example.fullstacktest.security;

import com.example.fullstacktest.users.entities.Appuser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    //Se hace override de métodos teniendo en cuenta  los roles de usuario
    private final Appuser appuser;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(new SimpleGrantedAuthority("ROLE_"+ appuser.getRole().toUpperCase()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return appuser.getPassword();
    }

    @Override
    public String getUsername() {
        return appuser.getUsername();
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
        return true;
    }
}
