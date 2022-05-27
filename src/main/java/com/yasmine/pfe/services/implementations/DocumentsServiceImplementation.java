package com.yasmine.pfe.services.implementations;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.yasmine.pfe.services.interfaces.DocumentService;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentsServiceImplementation implements DocumentService{
    
    @Override
    public void init() {
        Path rootPath = Paths.get("uploads/");
        Path utilsPath = Paths.get("uploads/Documents_utils");
        Path depotPath = Paths.get("uploads/Documents_depots");
        try {
            if(!Files.exists(rootPath))
                Files.createDirectory(rootPath);
            else if(!Files.exists(depotPath))
                Files.createDirectory(depotPath);
            else if(!Files.exists(utilsPath))
                Files.createDirectory(utilsPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folders for upload!");
        }
    }

    @Override
    public void save(MultipartFile file, String path) {
        Path storagePath = Paths.get(path);
        try {
            Files.copy(file.getInputStream(), storagePath.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: "+e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll(String sPath) {
        Path storagePath = Paths.get(sPath);
        try {
            return Files.walk(storagePath, 1).filter(path -> !path.equals(storagePath)).map(storagePath::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    @Override
    public Resource load(String filename, String path) {
        Path storagePath = Paths.get(path);
        try {
            Path file = storagePath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists()|| resource.isReadable()){
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @Override
    public void deleteAll(String path) {
        Path storagePath = Paths.get(path);
        FileSystemUtils.deleteRecursively(storagePath.toFile());
    }

    

    @Override
    public void deleteFile(String filename, String path) {
        Path storagePath = Paths.get(path);
        try {
            FileSystemUtils.deleteRecursively(storagePath.resolve(filename));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
