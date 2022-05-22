package com.yasmine.pfe.services.interfaces;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentStorageService {
    public void init();
    public void save(MultipartFile file);
    public Resource load(String filename);
    public Stream<Path> loadAll();
    public void deleteFile(String filename);
    public void deleteAll();
}
