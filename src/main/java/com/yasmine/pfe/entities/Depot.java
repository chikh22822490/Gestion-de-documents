package com.yasmine.pfe.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "depots")
public class Depot {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depotId;
    private LocalDate depotDate;
    private String statut;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "documentId")
    private DocumentUser documentId;

    public Depot() {
    }

    public Depot(LocalDate depotDate,User userId, DocumentUser documentId, String statut) {
        this.depotDate = depotDate;
        this.userId = userId;
        this.documentId = documentId;
        this.statut = statut;
    }

    public Long getDepotId() {
        return depotId;
    }

    public LocalDate getDepotDate() {
        return depotDate;
    }

    public void setDepotDate(LocalDate localDate) {
        this.depotDate = localDate;
    }

    public DocumentUser getDocumentDepot() {
        return documentId;
    }

    public void setDocumentDepot(DocumentUser documentId) {
        this.documentId = documentId;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public User getUserDepots() {
        return userId;
    }

    public void setUserDepots(User userId) {
        this.userId = userId;
    }

    
}
