package com.cpimperu.home.service;


import com.cpimperu.home.persistence.entity.User;

public interface UserInterface {
    User createUser(User user);
    User getUserInfo(String email);
}
