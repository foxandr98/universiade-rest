package net.foxandr.sport.universiade.restapi.news;

import net.foxandr.sport.universiade.restapi.ImageCategoriesEntity;
import net.foxandr.sport.universiade.restapi.ImagesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class NewsController {

    private final NewsEntityService newsEntityService;

    @Autowired
    public NewsController(NewsEntityService newsEntityService) {
        this.newsEntityService = newsEntityService;
    }

    @GetMapping("/news")
    public List<NewsEntity> getNewsByLocale(String locale){
       return newsEntityService.findAllByLocale(locale);
    }


    @PostMapping("/news")
    public NewsEntity createNewNewsEntity(@ModelAttribute NewsEntityDTO newsDTO) {
        return newsEntityService.createNewNewsEntity(newsDTO);
    }

//    @PostMapping("/newImage")
//    public void createNewImage(@ModelAttribute NewsEntityDTO newsDTO) {
//        newsEntityService.createNewImage(newsDTO);
//    }

}
