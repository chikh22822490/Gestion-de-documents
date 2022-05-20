package com.yasmine.pfe.services.interfaces;

import java.util.List;

import com.yasmine.pfe.entities.User;

public interface UserServices {

    void saveUser(User user);
    void updateUser(User user);
    List<User> allUsers();
    User findUserById(Long id);
    void deletUser(Long id);

}
