package net.foxandr.sport.universiade.restapi.news;

import net.foxandr.sport.universiade.restapi.images.ImagesEntity;
import net.foxandr.sport.universiade.util.Utils;
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

    public NewsEntity createNewNewsEntity(List<NewsEntityDTO> newsLocaledList, MultipartFile image) {
        try {
            var generatedNews = saveImageAndGetNewsEntity(newsLocaledList, image);
            if (generatedNews == null)
                throw new Exception("");
            return generatedNews;
        } catch (Exception ex) {
            return null;
        }
    }

    private NewsEntity saveImageAndGetNewsEntity(List<NewsEntityDTO> newsLocaledList, MultipartFile image) {
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
        NewsEntity newNewsEntity = Utils.saveImageAndEntity(path, image, newsEntityRepository, newsEntity);

        List<NewsTEntity> newsTEntityList = new ArrayList<>();
        Long id = newNewsEntity.getId();
        for (NewsEntityDTO newsEntityDTO : newsLocaledList) {
            newsTEntityList.add(
                    new NewsTEntity(
                            id,
                            newsEntityDTO.getLocale(),
                            newsEntityDTO.getTitle(),
                            newsEntityDTO.getText()
                    ));
        }
        try {
            newsEntityTRepository.saveAll(newsTEntityList);
            newNewsEntity.setNewsTEntities(newsTEntityList);
            return newNewsEntity;
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
