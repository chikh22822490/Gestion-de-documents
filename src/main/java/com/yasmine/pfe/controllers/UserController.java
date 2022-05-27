package com.yasmine.pfe.controllers;

import java.util.List;

import com.yasmine.pfe.entities.User;
import com.yasmine.pfe.services.interfaces.EmailSenderService;
import com.yasmine.pfe.services.interfaces.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    UserServices userServices;

    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers(){
        return userServices.allUsers();
    }

    @GetMapping(value = "/getUserById/{id}")
    public User getUserById(@PathVariable(value = "id") String id){
        return userServices.findUserById(Long.parseLong(id));
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestParam String nomUser, @RequestParam String prenomUser, @RequestParam String emailUser, @RequestParam String username, @RequestParam String passwordUser, @RequestParam String imageUser){
        User user = new User(nomUser, prenomUser, emailUser, username, passwordUser, imageUser, false);
        userServices.saveUser(user);
        this.emailSenderService.sendEmail(user.getEmailUser(),"Compte créé.","Bonjour et bienvenu dans l'équipe TenStep.\n Cet e-mail est envoyé automatiquement lors de votre inscription sur notre plateforme de gestion des documents.\n Cordialement.");
        return "User ajouté avec succès";
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") String id){
        String emailUser = userServices.findUserById(Long.parseLong(id)).getEmailUser();
        userServices.deletUser(Long.parseLong(id));
        this.emailSenderService.sendEmail(emailUser,"Supression de votre compte TenStep","Bonjour .\n Cet e-mail est envoyé automatiquement lors de la supression de votre compte sur notre plateforme de gestion des documents.\n Cordialement.");
        return "User Supprimé avec succès";
    }

    @PutMapping(value = "/modifyUser/{id}")
    public String updateUser(@PathVariable(value = "id") String id, @RequestParam String nomUser, @RequestParam String prenomUser, @RequestParam String emailUser, @RequestParam String username, @RequestParam String imageUser){
        User user = userServices.findUserById(Long.parseLong(id));
        user.setEmailUser(emailUser);
        user.setImageUser(imageUser);
        user.setNomUser(nomUser);
        user.setPrenomUser(prenomUser);
        user.setUsername(username);

        userServices.saveUser(user);
        this.emailSenderService.sendEmail(user.getEmailUser(),"Modification effectuée","Bonjour et bienvenu dans l'équipe TenStep.\n Cet e-mail est envoyé automatiquement lors de toute modification de votre profil sur notre plateforme de gestion des documents.\n Cordialement.");
        return "User modifié avec succès";
    }

    @PutMapping(value = "/passwordReset/{id}")
    public String passwordReset(@PathVariable(value = "id") String id, @RequestParam String password){
        User user = userServices.findUserById(Long.parseLong(id));
        user.setPasswordUser(password);
        userServices.saveUser(user);
        this.emailSenderService.sendEmail(user.getEmailUser(),"Mot de passe modifié","Bonjour.\n Cet e-mail est envoyé automatiquement lors du changement de votre mot de passe sur notre plateforme de gestion des documents.\n Cordialement.");
        return "Mot de passe modiifé avec succès";
    }

    @PostMapping(value = "/login")
    public User login(@RequestParam String username, @RequestParam String password){
        User user = userServices.findUserByUsername(username);
        if(user!=null&&user.verifyPassword(password))
            return user;
        else return null;
    }

    @PutMapping(value = "/setAdmin/{id}")
    public String setAdmin(@PathVariable String id){
        User user = userServices.findUserById(Long.parseLong(id));
        user.setIsAdmin(true);
        userServices.saveUser(user);
        String message = user.getNomUser()+" est maintenant administrateur";
        this.emailSenderService.sendEmail(user.getEmailUser(), "Vous etes desormais admin", "Vous etes desormais administrateur de la plateforme de gestion des documents TenStep.\nCordialement.");
        return message;
    }

    @PutMapping(value = "/removeAdmin/{id}")
    public String removeAdmin(@PathVariable String id){
        User user = userServices.findUserById(Long.parseLong(id));
        user.setIsAdmin(false);
        userServices.saveUser(user);
        String message = user.getNomUser()+" n'est plus administrateur";
        this.emailSenderService.sendEmail(user.getEmailUser(), "Vous n'etes plus admin", "Vous n'etes plus administrateur de la plateforme de gestion des documents TenStep.\nCordialement.");
        return message;
    }
}
