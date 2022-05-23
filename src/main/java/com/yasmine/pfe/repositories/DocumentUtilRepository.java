package com.yasmine.pfe.repositories;

import com.yasmine.pfe.entities.DocumentUtils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DocumentUtilRepository extends JpaRepository <DocumentUtils, Long>{
    
}
