package com.example.demo.security;

import com.example.demo.domain.User;
import com.example.demo.infrastructure.dal.UserRepository;
import lombok.RequiredArgsConstructor;
import org.postgresql.util.PSQLException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.getByUsername(username);
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of();
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getPassword();
            }
        };
    }

    public String registerUser(String username, String password) throws UserAlreadyRegisteredException {
        if (repository.getByUsername(username) != null) {
            throw new UserAlreadyRegisteredException();
        }


        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        repository.save(newUser);
        return username;

    }

    public static class UserAlreadyRegisteredException extends Exception {
    }
}
