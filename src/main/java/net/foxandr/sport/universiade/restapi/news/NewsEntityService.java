package net.foxandr.sport.universiade.restapi.news;

import net.foxandr.sport.universiade.restapi.images.ImagesEntity;
import net.foxandr.sport.universiade.util.ImageCategories;
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
    @Autowired
    public NewsEntityService(NewsEntityRepository newsEntityRepository) {
        this.newsEntityRepository = newsEntityRepository;

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
                        ImageCategories.NEWS.getNumber(),
                        date
                )
        );
        List<NewsTEntity> newsTEntityList = new ArrayList<>();
        for (NewsEntityDTO newsEntityDTO : newsLocaledList) {
            NewsTEntity newsTEntity = new NewsTEntity(
                    new NewsTEntityPK(
                            newsEntity,
                            newsEntityDTO.getLocale()),
                    newsEntityDTO.getTitle(),
                    newsEntityDTO.getText()
            );
            newsTEntityList.add(newsTEntity);
        }
        newsEntity.setNewsTEntities(newsTEntityList);

        return Utils.saveImageAndEntity(path, image, newsEntityRepository, newsEntity);
    }

    public List<NewsEntity> getAllByLocale(String locale) {
        return newsEntityRepository.getAllByNewsTEntitiesLocale(locale);
    }
}
