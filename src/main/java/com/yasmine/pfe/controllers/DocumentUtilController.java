package com.yasmine.pfe.controllers;

import java.nio.file.Paths;
import java.util.List;

import com.yasmine.pfe.entities.DocumentUtils;
import com.yasmine.pfe.services.interfaces.DocumentService;
import com.yasmine.pfe.services.interfaces.DocumentUtilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


@RestController
@RequestMapping("/documentUtils")
@CrossOrigin
public class DocumentUtilController {

    private String pathUtils ="uploads/Documents_utils/";

    @Autowired
    DocumentUtilService documentUtilService;

    @Autowired
    DocumentService documentService;

    @GetMapping(value = "/getAll")
    public List<DocumentUtils> getAllDocumentsUtils(){
        return documentUtilService.allDocuments();
    }

    @PostMapping(value="/addDocumentUtil", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addDocumentUtil(@RequestPart String description, @RequestPart String categorie, @RequestPart("file") MultipartFile file) {
        try {
            documentService.save(file, pathUtils);
            DocumentUtils documentUtils = new DocumentUtils();
            documentUtils.setCategorieDocument(categorie);
            documentUtils.setDescriptionDocument(description);
            documentUtils.setNomDocument(file.getOriginalFilename());
            // String url = MvcUriComponentsBuilder.fromMethodName(DocumentUtilController.class, "getFile", file.getOriginalFilename()).build().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(DocumentUtilController.class, "downloadFile", Paths.get(pathUtils+file.getOriginalFilename()).getFileName().toString()).build().toString();
            documentUtils.setUrlDocument(url);
            documentUtilService.saveDocument(documentUtils);
            return "Document ajoutée avec succès";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource file = documentService.load(filename, pathUtils);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
}
