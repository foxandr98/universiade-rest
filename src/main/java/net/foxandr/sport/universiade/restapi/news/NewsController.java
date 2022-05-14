package net.foxandr.sport.universiade.restapi.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NewsController {

    private final NewsEntityRepository newsEntityRepository;

    @Autowired
    public NewsController(NewsEntityRepository newsEntityRepository) {
        this.newsEntityRepository = newsEntityRepository;
    }


    @GetMapping("/news")
    public List<NewsEntity> getNewsByLocale(String locale){
       return newsEntityRepository.findAllByLocale(locale);
    }

}
