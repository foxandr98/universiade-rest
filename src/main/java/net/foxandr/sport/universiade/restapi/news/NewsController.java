package net.foxandr.sport.universiade.restapi.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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
       return newsEntityService.getAllByLocale(locale);
    }


    @PostMapping("/news")
    public NewsEntity createNewNewsEntity(@RequestPart ArrayList<NewsEntityDTO> localedList,
                                          @RequestPart MultipartFile imageFile) {
        return newsEntityService.createNewNewsEntity(localedList, imageFile);
    }

}
