package net.foxandr.sport.universiade.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static <T, ID> T saveImageAndEntity(Path path, MultipartFile image, JpaRepository<T, ID> repository, T item){
        try {
            byte[] bytes = image.getBytes();
            if (!Files.exists(path))
                Files.createDirectories(path.getParent());
            Files.write(path, bytes);
            return repository.save(item);
        } catch (Exception ex) {
            System.out.println("Error saving photo");
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                System.out.println("Error while deleting file");
                return null;
            }
            return null;
        }
    }
}
