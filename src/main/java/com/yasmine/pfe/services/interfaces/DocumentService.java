package com.yasmine.pfe.services.interfaces;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
    public void init();
    public void save(MultipartFile file, String path);
    public Resource load(String filename, String path);
    public void deleteAll(String path);
    public Stream<Path> loadAll(String path);
    public void deleteFile(String filename, String path);
}
