package com.yasmine.pfe.repositories;

import com.yasmine.pfe.entities.DocumentUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentUserRepository extends JpaRepository<DocumentUser, Long>{

    @Query(value = "select d from DocumentUser d where documentId = ?1")
    DocumentUser findDocumentById(long id);
    
}
