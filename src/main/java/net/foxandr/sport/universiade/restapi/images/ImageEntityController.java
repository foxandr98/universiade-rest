package net.foxandr.sport.universiade.restapi.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ImageEntityController {

    ImageEntityService imageEntityService;

    @Autowired
    public ImageEntityController(ImageEntityService imageEntityService) {
        this.imageEntityService = imageEntityService;
    }

    @GetMapping(value = "/images/{uuid}", produces = "image/jpg")
    public @ResponseBody byte[] getImageByUuid(@PathVariable("uuid") String uuid){
        return imageEntityService.getImageByUuid(uuid);
    }

}
