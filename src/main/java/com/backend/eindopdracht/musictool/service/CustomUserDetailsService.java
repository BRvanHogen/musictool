package com.backend.eindopdracht.musictool.service;

import com.backend.eindopdracht.musictool.exceptions.UsernameNotFoundException;
import com.backend.eindopdracht.musictool.model.Authority;
import com.backend.eindopdracht.musictool.model.User;
import com.backend.eindopdracht.musictool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    //onderstaande methode is als enige custom. De rest is allemaal standaard SQL (UserDetailsService)
    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userService.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        String password = user.get().getPassword();

        Set<Authority> authorities = user.get().getAuthorities();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
    }
}
