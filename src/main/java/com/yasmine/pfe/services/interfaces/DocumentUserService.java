package com.yasmine.pfe.services.interfaces;

import java.util.List;

import com.yasmine.pfe.entities.DocumentUser;

public interface DocumentUserService {
    
    void saveDocument(DocumentUser documentUtils);
    void updateDocument(DocumentUser documentUtils);
    List<DocumentUser> allDocuments();
    void deletDocument(Long id);

}
