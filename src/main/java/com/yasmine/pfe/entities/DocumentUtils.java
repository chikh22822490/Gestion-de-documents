package com.yasmine.pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documents_utils")
public class DocumentUtils {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private String nomDocument;
    private String urlDocument;
    private String categorieDocument;
    private String descriptionDocument;

    public DocumentUtils() {
    }

    public DocumentUtils(String nomDocument, String urlDocument, String categorieDocument, String desctiption) {
        this.setNomDocument(nomDocument);
        this.setUrlDocument(urlDocument);
        this.setCategorieDocument(categorieDocument);
        this.setDescriptionDocument(desctiption);
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

    public String getDescriptionDocument() {
        return descriptionDocument;
    }

    public void setDescriptionDocument(String descriptionDocument) {
        this.descriptionDocument = descriptionDocument;
    }

}
