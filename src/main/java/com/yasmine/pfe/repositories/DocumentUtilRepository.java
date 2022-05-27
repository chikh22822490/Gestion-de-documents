package com.yasmine.pfe.repositories;

import com.yasmine.pfe.entities.DocumentUtils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DocumentUtilRepository extends JpaRepository <DocumentUtils, Long>{
    
    @Query(value = "select d from DocumentUtils d where documentId = ?1")
    DocumentUtils findDocumentById(long id);
}
