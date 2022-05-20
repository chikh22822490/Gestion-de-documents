package com.yasmine.pfe.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private String nomDocument;
    private String urlDocument;
    private String categorieDocument;

    @OneToMany(mappedBy = "documetnDepot")
    private List<Depot> listDepotsDocument;

    public Document(String nomDocument, String urlDocument, String categorieDocument, List<Depot> listDepotsDocument) {
        this.nomDocument = nomDocument;
        this.urlDocument = urlDocument;
        this.categorieDocument = categorieDocument;
        this.listDepotsDocument = listDepotsDocument;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getNomDocument() {
        return nomDocument;
    }

    public void setNomDocument(String nomDocument) {
        this.nomDocument = nomDocument;
    }

    public String getUrlDocument() {
        return urlDocument;
    }

    public void setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
    }

    public String getCategorieDocument() {
        return categorieDocument;
    }

    public void setCategorieDocument(String categorieDocument) {
        this.categorieDocument = categorieDocument;
    }

    public List<Depot> getListDepot() {
        return listDepotsDocument;
    }

    public void setListDepot(List<Depot> listDepotsDocument) {
        this.listDepotsDocument = listDepotsDocument;
    }
}
