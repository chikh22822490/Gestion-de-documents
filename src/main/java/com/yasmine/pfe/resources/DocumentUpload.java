package com.yasmine.pfe.resources;


public class DocumentUpload {

    private String nomDocument;
    private String urlDocument;

    public DocumentUpload() {
    }

    public DocumentUpload(String nomDocument, String urlDocument) {
        this.nomDocument = nomDocument;
        this.urlDocument = urlDocument;
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

}
