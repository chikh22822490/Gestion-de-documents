package com.yasmine.pfe.services.interfaces;

import java.util.List;

import com.yasmine.pfe.entities.DocumentUser;

public interface DocumentUserService {
    
    void saveDocument(DocumentUser documentUser);
    void updateDocument(DocumentUser documentUser);
    List<DocumentUser> allDocuments();
    void deletDocument(Long id);

}
