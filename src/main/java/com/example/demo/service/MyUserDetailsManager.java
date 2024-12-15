package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;


//BCryptPasswordEncoder
@Service
@RequiredArgsConstructor
public class MyUserDetailsManager implements UserDetailsManager {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {
//
    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {//проверка на наличие пользователя
        try {
            loadUserByUsername(username);

        } catch (UsernameNotFoundException usernameNotFoundException) {
            return false;
        }
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepository.findByUsername(username)//получение пользователя
                .orElseThrow(() -> new UsernameNotFoundException(username));

        //получение ролей
        var roles = user.getRoles()
                .stream()
                .map(e -> e.getName())
                .toArray(String[]::new);

        return User.builder() //создание обьекта юзера с которым работает спринг
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }
}
