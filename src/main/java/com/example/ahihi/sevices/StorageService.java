package com.example.ahihi.sevices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
    private String path;

    public void uploadFile(MultipartFile file) {

        if (file.isEmpty()) {

        }
        try {
            var fileName = file.getOriginalFilename();
            var is = file.getInputStream();

            Files.copy(is, Paths.get(path + fileName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {

            var msg = String.format("Failed to store file %f", file.getName());

        }
    }

}
