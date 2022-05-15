package net.foxandr.sport.universiade.restapi.lostfound;

import net.foxandr.sport.universiade.restapi.news.NewsEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LostFoundItemsController {


    private final LostFoundService lostFoundService;

    @Autowired
    public LostFoundItemsController(LostFoundService lostFoundService) {
        this.lostFoundService = lostFoundService;
    }

    @GetMapping(value = "/lost-found")
    public List<LostFoundItemsEntity> getLostFoundItemsByParams(
            @RequestParam(required = false, defaultValue = "true") boolean isRequest,
            @RequestParam(required = false, defaultValue = "false") boolean isFound) {
        return lostFoundService.getLostFoundItemsByParams(isRequest, isFound);
    }

    @GetMapping("/lost-found-all")
    public List<LostFoundItemsEntity> getLostFoundItems() {
        return lostFoundService.getAllLostFoundItems();
    }

    @PostMapping("/lost-found")
    public LostFoundItemsEntity createLostFoundItem(@RequestPart LostFoundItemsDTO lostFoundDTO,
                                                    @RequestPart MultipartFile imageFile){
        return lostFoundService.createLostFoundItem(lostFoundDTO, imageFile);
    }
}
