package net.foxandr.sport.universiade.restapi.images;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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
