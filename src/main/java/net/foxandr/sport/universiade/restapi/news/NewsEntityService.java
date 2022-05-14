package net.foxandr.sport.universiade.restapi.news;

import net.foxandr.sport.universiade.restapi.images.ImagesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
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


    public void createNewImage(MultipartFile image) {
        UUID uuid = UUID.randomUUID();
        Path path = Paths.get("/images/news/" + uuid + image.getOriginalFilename());
        try {
            byte[] bytes = image.getBytes();
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

    public NewsEntity createNewNewsEntity(List<NewsEntityDTO> newsLocaledList, MultipartFile image) {
        try {
            var generatedNews = saveImageAndGetNewsEntity(image);
            if(generatedNews == null)
                throw new Exception("");
            List<NewsTEntity> newsTEntityList = new ArrayList<>();
            Long id = generatedNews.getId();
            for (NewsEntityDTO newsEntityDTO : newsLocaledList) {
                newsTEntityList.add(
                        new NewsTEntity(
                                id,
                                newsEntityDTO.getLocale(),
                                newsEntityDTO.getTitle(),
                                newsEntityDTO.getText()
                        ));
            }

            newsEntityTRepository.saveAll(newsTEntityList);
            generatedNews.setNewsTEntities(newsTEntityList);
            return generatedNews;
        } catch (Exception ex) {
            return null;
        }
    }

    private NewsEntity saveImageAndGetNewsEntity(MultipartFile image) {

        UUID uuid = UUID.randomUUID();
        Path path = Paths.get("/images/news/" + uuid + image.getOriginalFilename());
        Date date = new Date(new java.util.Date().getTime());

        NewsEntity newsEntity = new NewsEntity(
                date,
                new ImagesEntity(
                        uuid.toString(),
                        path.toString(),
                        (long) 3,
                        date
                )
        );
        try {
            byte[] bytes = image.getBytes();
            if (!Files.exists(path))
                Files.createDirectories(path.getParent());
            Files.write(path, bytes);
            return newsEntityRepository.save(newsEntity);
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

        public List<NewsEntity> findAllByLocale (String locale){
            return newsEntityRepository.findAllByLocale(locale);
        }
    }
