package net.foxandr.sport.universiade.restapi.images;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageEntityService {

    ImagesEntityRepository imagesEntityRepository;

    @Autowired
    public ImageEntityService(ImagesEntityRepository imagesEntityRepository) {
        this.imagesEntityRepository = imagesEntityRepository;
    }

    public byte[] getImageByUuid(String uuid) {
        try {
            ImagesEntity imageEntity = imagesEntityRepository.getImagesEntityByUuid(uuid);
            var imageRef = imageEntity.getImgRef();
            var extension = imageRef.substring(imageRef.lastIndexOf('.') + 1);

            InputStream is = Files.newInputStream(Paths.get(imageRef));
            BufferedImage image = ImageIO.read(is);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(image, extension, bao);
//            return Base64.encodeBase64(bao.toByteArray());
            return bao.toByteArray();
        } catch (Exception ex) {
            System.out.println("Error while downloading Image");
            return null;
        }
    }


}
