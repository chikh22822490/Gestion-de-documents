package com.yasmine.pfe.controllers;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.yasmine.pfe.entities.Depot;
import com.yasmine.pfe.entities.DocumentUser;
import com.yasmine.pfe.entities.User;
import com.yasmine.pfe.repositories.DocumentUserRepository;
import com.yasmine.pfe.services.interfaces.DepotService;
import com.yasmine.pfe.services.interfaces.DocumentService;
import com.yasmine.pfe.services.interfaces.DocumentUserService;
import com.yasmine.pfe.services.interfaces.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping("/depot")
@CrossOrigin
public class DepotController {
    
    private String pathDepot ="uploads/Documents_depots/";

    @Autowired
    DepotService depotService;

    @Autowired
    DocumentUserService documentUserService;

    @Autowired 
    DocumentService documentService;

    @Autowired
    UserServices userServices;

    @Autowired
    DocumentUserRepository documentUserRepository;

    @GetMapping(value = "/getAll")
    public List<Depot> getAllDepots(){
        return depotService.allDepots();
    }

    @GetMapping(value = "/getDepotById/{id}")
    public Depot getDepotById(@PathVariable String id){
        return depotService.getDepotById(Long.parseLong(id));
    }

    @PostMapping(value="/addDocumentUtil", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addDocumentUtil(@RequestPart String idUser, @RequestPart String description, @RequestPart String categorie, @RequestPart("file") MultipartFile file) {
        try {
            documentService.save(file, pathDepot);
            DocumentUser documentUser = new DocumentUser();
            documentUser.setCategorieDocument(categorie);
            documentUser.setDescriptionDocument(description);
            documentUser.setNomDocument(file.getOriginalFilename());
            String url = MvcUriComponentsBuilder.fromMethodName(DocumentUtilController.class, "downloadFile", Paths.get(pathDepot+file.getOriginalFilename()).getFileName().toString()).build().toString();
            documentUser.setUrlDocument(url);
            documentUserService.saveDocument(documentUser);

            DocumentUser documentUser2 = new DocumentUser();
            documentUser2.setDocumentId(documentUserRepository.count());
            Depot depot = new Depot();
            User user = new User();
            user.setUserId(Long.parseLong(idUser));
            depot.setDepotDate(LocalDate.now());
            depot.setStatut("waiting");
            depot.setDocumentDepot(documentUser2);
            depot.setUserDepots(user);
            depotService.saveDepot(depot);
            return "Document ajoutée avec succès";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
