package com.yasmine.pfe.services.interfaces;

import java.util.List;

import com.yasmine.pfe.entities.DocumentUtils;

public interface DocumentUtilService {

    void saveDocument(DocumentUtils documentUtils);
    void updateDocument(DocumentUtils documentUtils);
    List<DocumentUtils> allDocuments();
    void deletDocument(Long id);
    
}
