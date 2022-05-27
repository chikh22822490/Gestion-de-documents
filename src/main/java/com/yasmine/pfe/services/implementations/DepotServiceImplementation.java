package com.yasmine.pfe.services.implementations;

import java.util.List;

import com.yasmine.pfe.entities.Depot;
import com.yasmine.pfe.repositories.DepotRepository;
import com.yasmine.pfe.services.interfaces.DepotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepotServiceImplementation implements DepotService{

    @Autowired
    DepotRepository depotRepository;

    @Override
    public void saveDepot(Depot depot) {
        depotRepository.save(depot);
    }

    @Override
    public void updateDepot(Depot depot) {
        depotRepository.save(depot);
    }

    @Override
    public List<Depot> allDepots() {
        return depotRepository.findAll();
    }

    @Override
    public Depot getDepotById(Long id) {
        return depotRepository.findDepotById(id);
    }

    @Override
    public List<Depot> allDepotsByUser(Long id) {
        return depotRepository.findDepotByUser(id);
    }
    
}
