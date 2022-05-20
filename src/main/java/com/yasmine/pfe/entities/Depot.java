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

    @ManyToOne
    private User userDepots;

    @ManyToOne
    private Document documentDepot;

    public Depot() {
    }

    public Depot(Date depotDate,User userDepots, Document documentDepot) {
        this.depotDate = depotDate;
        this.userDepots = userDepots;
        this.documentDepot = documentDepot;
    }

    public Long getDepotId() {
        return depotId;
    }

    public void setDepotId(Long depotId) {
        this.depotId = depotId;
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

    public Document getDocumentDepot() {
        return documentDepot;
    }

    public void setDocumentDepot(Document documentDepot) {
        this.documentDepot = documentDepot;
    }

    
}
