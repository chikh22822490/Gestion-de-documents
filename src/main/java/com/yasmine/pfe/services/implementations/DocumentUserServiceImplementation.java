package com.yasmine.pfe.services.implementations;

import java.util.List;

import com.yasmine.pfe.entities.DocumentUser;
import com.yasmine.pfe.repositories.DocumentUserRepository;
import com.yasmine.pfe.services.interfaces.DocumentUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentUserServiceImplementation implements DocumentUserService{

    @Autowired
    DocumentUserRepository documentUserRepository;

    @Override
    public void saveDocument(DocumentUser documentUtils) {
        documentUserRepository.save(documentUtils);
    }

    @Override
    public void updateDocument(DocumentUser documentUtils) {
        documentUserRepository.save(documentUtils);
    }

    @Override
    public List<DocumentUser> allDocuments() {
        return documentUserRepository.findAll();
    }

    @Override
    public void deletDocument(Long id) {
        documentUserRepository.deleteById(id);
    }
    
}
