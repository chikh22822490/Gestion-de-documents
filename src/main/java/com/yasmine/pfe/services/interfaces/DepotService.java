package com.yasmine.pfe.services.interfaces;

import java.util.List;

import com.yasmine.pfe.entities.Depot;

public interface DepotService {
    
    void saveDepot(Depot depot);
    void updateDepot(Depot depot);
    List<Depot> allDepots();
    List<Depot> allDepotsByUser(Long id);
    Depot getDepotById(Long id);


}
