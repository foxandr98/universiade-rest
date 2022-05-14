package net.foxandr.sport.universiade.restapi.lostfound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LostFoundItemsController {

    private final LostFoundItemsEntityRepository lostFoundItemsEntityRepository;

    @Autowired
    public LostFoundItemsController(LostFoundItemsEntityRepository lostFoundItemsEntityRepository) {
        this.lostFoundItemsEntityRepository = lostFoundItemsEntityRepository;
    }


    @GetMapping(value = "/lost-found")
    public List<LostFoundItemsEntity> getLostFoundItemsByParams(
            @RequestParam(required = false, defaultValue = "true") boolean isRequest,
            @RequestParam(required = false, defaultValue = "false") boolean isFound){
        return lostFoundItemsEntityRepository.findAllByIsRequestAndIsFound(isRequest, isFound);
    }

    @GetMapping("/lost-found-all")
    public List<LostFoundItemsEntity> getLostFoundItems(){

        return lostFoundItemsEntityRepository.findAll();
    }



}
