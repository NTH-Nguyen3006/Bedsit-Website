package com.example.ahihi.sevices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ahihi.exception.StorageException;

@Service
public class StorageService {
    private String path = "var/www/upload/";

    public void uploadFile(MultipartFile file, String filename) {
        if (file.isEmpty())
            throw new StorageException("Failed to store empty file");
        try {
            var is = file.getInputStream();
            Path uploadPath = Paths.get(this.path);
            if (!Files.exists(uploadPath)) {
                uploadPath = Files.createDirectories(uploadPath);
            }
            Files.copy(is, uploadPath.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            var msg = String.format("Failed to store file %s", file.getName());
            throw new StorageException(msg, e);
        }
    }

    public void deleteFile(String filename) {
        if (filename.isEmpty())
            throw new StorageException("Failed to store empty file");
        try {
            Path imagePath = Paths.get(path, filename);
            Files.delete(imagePath);
        } catch (IOException e) {
            throw new StorageException("Unable to delete file named: " + filename);
        }
    }
}
