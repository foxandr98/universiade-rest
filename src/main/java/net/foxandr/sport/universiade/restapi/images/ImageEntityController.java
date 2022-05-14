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

    ImagesEntityRepository imagesEntityRepository;

    @Autowired
    public ImageEntityController(ImagesEntityRepository imagesEntityRepository) {
        this.imagesEntityRepository = imagesEntityRepository;
    }

    @GetMapping(value = "/images/{uuid}", produces = "image/jpg")
    public @ResponseBody byte[] getImageByUuid(@PathVariable("uuid") String uuid){
        ImagesEntity imageEntity = imagesEntityRepository.getImagesEntityByUuid(uuid);
        var imageRef = imageEntity.getImgRef();
        var extension = imageRef.substring(imageRef.lastIndexOf('.') + 1);
        try {
            InputStream is = Files.newInputStream(Paths.get(imageRef));
            BufferedImage image = ImageIO.read(is);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(image, extension, bao);
            return Base64.encodeBase64(bao.toByteArray());
        } catch (Exception ex) {
            System.out.println("Error while downloading Image");
            return null;
        }
    }

}
