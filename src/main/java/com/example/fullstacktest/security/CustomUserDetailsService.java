package com.example.fullstacktest.security;

import com.example.fullstacktest.users.entities.Appuser;
import com.example.fullstacktest.users.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Appuser appUser = appUserRepository
                .findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("No existe el usuario"));


        return new CustomUserDetails(appUser);
    }
}
