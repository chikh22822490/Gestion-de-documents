package com.yasmine.pfe.services.implementations;

import java.util.List;

import com.yasmine.pfe.entities.DocumentUtils;
import com.yasmine.pfe.repositories.DocumentUtilRepository;
import com.yasmine.pfe.services.interfaces.DocumentUtilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentUtilServiceImplementation implements DocumentUtilService{

    @Autowired
    DocumentUtilRepository documentUtilRepository;

    @Override
    public void saveDocument(DocumentUtils documentUtils) {
        documentUtilRepository.save(documentUtils);
    }

    @Override
    public void updateDocument(DocumentUtils documentUtils) {
        documentUtilRepository.save(documentUtils);
    }

    @Override
    public List<DocumentUtils> allDocuments() {
        return documentUtilRepository.findAll();
    }

    @Override
    public void deletDocument(Long id) {
        documentUtilRepository.deleteById(id);
    }
    
}
