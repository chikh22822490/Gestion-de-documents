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
    private User userDepot;

    @ManyToOne
    private Document documentDepot;

    public Depot(Date depotDate,User userDepot, Document documentDepot) {
        this.depotDate = depotDate;
        this.userDepot = userDepot;
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
        return userDepot;
    }

    public void setUserDepot(User userDepot) {
        this.userDepot = userDepot;
    }

    public Document getDocumentDepot() {
        return documentDepot;
    }

    public void setDocumentDepot(Document documentDepot) {
        this.documentDepot = documentDepot;
    }

    
}
