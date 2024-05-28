package com.cpimperu.home.service;


import com.cpimperu.home.config.JwtUtil;
import com.cpimperu.home.persistence.entity.User;
import com.cpimperu.home.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserInterface {
    private static final String EMAIL_ALREADY_REGISTERED = "El correo ya está registrado";
    private static final String USER_NOT_FOUND = "Usuario con correo %s no encontrado";

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException(EMAIL_ALREADY_REGISTERED);
        }
        return userRepository.save(setUserDta(user));
    }

    @Override
    public User getUserInfo(String email) {
        User userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(String.format(USER_NOT_FOUND, email)));

        return userEntity;
    }

    private User setUserDta(User user){
        Date dateTime = new Date();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated(dateTime);
        user.setModified(dateTime);
        user.setLastLogin(dateTime);
        user.setToken(jwtUtil.generateToken(user.getEmail()));
        user.setActive(true);
        return user;
    }
}
