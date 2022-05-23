// package com.yasmine.pfe.controllers;

// import java.util.List;
// import java.util.stream.Collectors;

// import com.yasmine.pfe.resources.DocumentUpload;
// import com.yasmine.pfe.services.interfaces.DocumentService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.Resource;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

// @RestController
// @CrossOrigin
// @RequestMapping("/utilFiles")
// public class DocumentsController {

//     @Autowired
//     DocumentService documentUtilService;

//     @PostMapping("/upload")
//     public String uploadFile(@RequestParam("file") MultipartFile file){
//         try {
//             documentUtilService.save(file);
//             return "Uploaded the file successfully: " + file.getOriginalFilename();
//         } catch (Exception e) {
//             return "Could not upload the file: " + file.getOriginalFilename() + "!";
//         }
//     }

//     @GetMapping("/files")
//     public List<DocumentUpload> getListFiles() {
//         List<DocumentUpload> fileInfos = documentUtilService.loadAll().map(path -> {
//         String filename = path.getFileName().toString();
//         String url = MvcUriComponentsBuilder
//             .fromMethodName(DocumentsController.class, "getFile", path.getFileName().toString()).build().toString();
//         return new DocumentUpload(filename, url);
//         }).collect(Collectors.toList());
//         return fileInfos;
//     }

//     @GetMapping("/files/{filename:.+}")
//     @ResponseBody
//     public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
//         Resource file = documentUtilService.load(filename);
//         return ResponseEntity.ok()
//             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//     }
    
//     @DeleteMapping("/files/delete/{filename:.+}")
//     public String deleteFile(@PathVariable String filename){
//         documentUtilService.deleteFile(filename);
//         return "File deleted successfully";
//     }

//     @PutMapping(value="update/{filename:.+}")
//     public String updateFile(@PathVariable String filename, @RequestParam("file") MultipartFile file) {
//         if(file.getOriginalFilename().matches(filename)){
//             deleteFile(filename);
//             uploadFile(file);
//             return "file updated";
//         } else {
//             return("Le fichier n'a pas le meme nom : \nOriginal: "+ filename+"\nNew : "+file.getOriginalFilename());
//         }
//     }
// }
