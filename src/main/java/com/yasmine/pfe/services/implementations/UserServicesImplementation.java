package com.yasmine.pfe.services.implementations;

import java.util.List;

import com.yasmine.pfe.entities.User;
import com.yasmine.pfe.repositories.UserRepository;
import com.yasmine.pfe.services.interfaces.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServicesImplementation implements UserServices{

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deletUser(Long id) {
        userRepository.deleteById(id);
    }
    
}
