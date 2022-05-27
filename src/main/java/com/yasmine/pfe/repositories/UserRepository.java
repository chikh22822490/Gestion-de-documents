package com.yasmine.pfe.repositories;

import com.yasmine.pfe.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository <User, Long>{

    @Query(value = "select u from User u where userId = ?1")
    User findUserById(long id);

    @Query(value = "select u from User u where nomUser = ?1")
    User findUserByName(String nom);

    @Query(value = "select u from User u where emailuser = ?1")
    User findUserByEmail(String email);

    @Query(value = "select u from User u where Username = ?1")
    User findUserByUsername(String username);
    
}
