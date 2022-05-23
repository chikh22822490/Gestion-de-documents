package com.yasmine.pfe.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "depots")
public class Depot {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depotId;
    private Date depotDate;
    private String statut;

    @ManyToOne
    private User userDepots;

    @ManyToOne
    private DocumentUser documentDepot;

    public Depot() {
    }

    public Depot(Date depotDate,User userDepots, DocumentUser documentDepot, String statut) {
        this.depotDate = depotDate;
        this.userDepots = userDepots;
        this.documentDepot = documentDepot;
        this.statut = statut;
    }

    public Long getDepotId() {
        return depotId;
    }

    public Date getDepotDate() {
        return depotDate;
    }

    public void setDepotDate(Date depotDate) {
        this.depotDate = depotDate;
    }

    public User getUserDepot() {
        return userDepots;
    }

    public void setUserDepot(User userDepots) {
        this.userDepots = userDepots;
    }

    public DocumentUser getDocumentDepot() {
        return documentDepot;
    }

    public void setDocumentDepot(DocumentUser documentDepot) {
        this.documentDepot = documentDepot;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public User getUserDepots() {
        return userDepots;
    }

    public void setUserDepots(User userDepots) {
        this.userDepots = userDepots;
    }

    
}
