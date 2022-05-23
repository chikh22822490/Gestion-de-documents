package com.yasmine.pfe.repositories;

import java.util.List;

import com.yasmine.pfe.entities.Depot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepotRepository extends JpaRepository <Depot, Long> {

    @Query(value = "select d from Depot d where d.userDepots.userId = ?1")
    public List<Depot> findDepotByUser(Long userId);
    
}
