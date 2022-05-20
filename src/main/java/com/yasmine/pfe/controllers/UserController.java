package com.yasmine.pfe.controllers;

import java.util.List;

import com.yasmine.pfe.entities.User;
import com.yasmine.pfe.services.interfaces.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    UserServices userServices;

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers(){
        return userServices.allUsers();
    }

    @GetMapping(value = "/getUserById/{id}")
    public User getUserById(@PathVariable(value = "id") String id){
        return userServices.findUserById(Long.parseLong(id));
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user){
        userServices.saveUser(user);
        return "User ajouté avec succès";
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") String id){
        userServices.deletUser(Long.parseLong(id));
        return "User Supprimé avec succès";
    }

    @PutMapping(value = "/modifyUser/{id}")
    public String updateUser(@PathVariable(value = "id") String id, @RequestBody User user){
        User user2 = userServices.findUserById(Long.parseLong(id));
        user2.setEmailUser(user.getEmailUser());
        user2.setImageUser(user.getImageUser());
        user2.setIsAdmin(user.getIsAdmin());
        user2.setNomUser(user.getNomUser());
        user2.setPrenomUser(user.getPrenomUser());
        user2.setUsername(user.getUsername());
        user2.setPasswordUser(user.getPasswordUser());
        user2.setListDepot(user.getListDepot());

        userServices.saveUser(user2);
        return "User modifié avec succès";
    }

}
