package com.yasmine.pfe.entities;

import java.security.SecureRandom;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class User {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String nomUser;
    private String prenomUser;
    private String emailUser;
    private String Username;
    private String passwordUser;
    private String imageUser;
    private Boolean isAdmin;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    public User(String nomUser, String prenomUser, String emailUser, String Username, String passwordUser, String imageUser, Boolean isAdmin) {
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.emailUser = emailUser;
        this.Username = Username;
        this.passwordUser = bCryptPasswordEncoder.encode(passwordUser);
        this.imageUser = imageUser;
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    @OneToMany(mappedBy = "userDepots")
    private List<Depot> listDepotsUser;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = bCryptPasswordEncoder.encode(passwordUser);
    }

    public String getImageUser() {
        return imageUser;
    }

    public void setImageUser(String imageUser) {
        this.imageUser = imageUser;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean verifyPassword(String passwordUser){
        return bCryptPasswordEncoder.matches(passwordUser, this.passwordUser);
    }

    public List<Depot> getListDepot() {
        return listDepotsUser;
    }

    public void setListDepot(List<Depot> listDepotsUser) {
        this.listDepotsUser = listDepotsUser;
    }

    

}
