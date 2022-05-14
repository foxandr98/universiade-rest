package net.foxandr.sport.universiade.restapi.news;

import net.foxandr.sport.universiade.restapi.ImageCategoriesEntity;
import net.foxandr.sport.universiade.restapi.ImagesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class NewsEntityService {

    NewsEntityRepository newsEntityRepository;
    NewsEntityTRepository newsEntityTRepository;

    @Autowired
    public NewsEntityService(NewsEntityTRepository newsEntityTRepository, NewsEntityRepository newsEntityRepository) {
        this.newsEntityRepository = newsEntityRepository;
        this.newsEntityTRepository = newsEntityTRepository;
    }


    public void createNewImage(NewsEntityDTO newsDTO) {
        UUID uuid = UUID.randomUUID();
        Path path = Paths.get("/images/news/" + uuid + newsDTO.getImageFile().getOriginalFilename());
        try {
            byte[] bytes = newsDTO.getImageFile().getBytes();
            if (!Files.exists(path))
                Files.createDirectories(path.getParent());
            Files.write(path, bytes);
        } catch (Exception ex) {
            System.out.println("Error saving photo");
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                System.out.println("Error while deleting file");
            }
        }
    }

    public NewsEntity createNewNewsEntity(NewsEntityDTO newsDTO) {
        UUID uuid = UUID.randomUUID();
        Path path = Paths.get("/images/news/" + uuid + newsDTO.getImageFile().getOriginalFilename());
        Date date = new Date(new java.util.Date().getTime());
        try {
            byte[] bytes = newsDTO.getImageFile().getBytes();

            NewsEntity newsEntity = new NewsEntity(
                    date,
                    new ImagesEntity(
                            uuid.toString(),
                            path.toString(),
                            (long) 3,
                            date
                    )
            );

            if (!Files.exists(path))
                Files.createDirectories(path.getParent());
            Files.write(path, bytes);

            var generatedNews = newsEntityRepository.save(newsEntity);

            List<NewsTEntity> newsTEntityList = List.of(
                    new NewsTEntity(
                            generatedNews.getId(),
                            newsDTO.getLocale(),
                            newsDTO.getTitle(),
                            newsDTO.getText()
                    ));

            newsEntityTRepository.save(newsTEntityList.get(0));

            return generatedNews;
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

    public List<NewsEntity> findAllByLocale(String locale) {
        return newsEntityRepository.findAllByLocale(locale);
    }
}
