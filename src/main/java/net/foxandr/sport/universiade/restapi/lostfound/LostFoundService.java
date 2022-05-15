package net.foxandr.sport.universiade.restapi.lostfound;

import net.foxandr.sport.universiade.restapi.images.ImagesEntity;
import net.foxandr.sport.universiade.restapi.news.NewsEntity;
import net.foxandr.sport.universiade.restapi.news.NewsTEntity;
import net.foxandr.sport.universiade.util.ImageCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LostFoundService {

    LostFoundItemsEntityRepository lostFoundItemsEntityRepository;
    LostFoundRequestRepository lostFoundRequestRepository;

    @Autowired
    public LostFoundService(LostFoundItemsEntityRepository lostFoundItemsEntityRepository, LostFoundRequestRepository lostFoundRequestRepository) {
        this.lostFoundItemsEntityRepository = lostFoundItemsEntityRepository;
        this.lostFoundRequestRepository = lostFoundRequestRepository;
    }

    public List<LostFoundItemsEntity> getLostFoundItemsByParams(boolean isRequest, boolean isFound) {
        return lostFoundItemsEntityRepository.findAllByIsRequestAndIsFound(isRequest, isFound);
    }

    public List<LostFoundItemsEntity> getAllLostFoundItems() {
        return lostFoundItemsEntityRepository.findAll();
    }

    public LostFoundItemsEntity createLostFoundItem(LostFoundItemsDTO lostFoundDTO, MultipartFile image) {
        try {
            var generatedLostFoundItem = saveImageAndGetLostFoundEntity(lostFoundDTO, image);
            if (generatedLostFoundItem == null)
                throw new Exception("");
            LostFoundRequestsEntity requestEntity = null;
            if (lostFoundDTO.getIsRequest()) {
                requestEntity = new LostFoundRequestsEntity(
                        generatedLostFoundItem.getId(),
                        lostFoundDTO.getContactName(),
                        lostFoundDTO.getContactToNotify()
                );
                lostFoundRequestRepository.save(requestEntity);
            }
            generatedLostFoundItem.setLostFoundRequestsEntity(requestEntity);
            return generatedLostFoundItem;
        } catch (Exception ex) {
            return null;
        }
    }

    private LostFoundItemsEntity saveImageAndGetLostFoundEntity(LostFoundItemsDTO lostFoundDTO,
                                                                MultipartFile image) {

        UUID uuid = UUID.randomUUID();
        Path path = Paths.get("/images/lost-found/" + uuid + image.getOriginalFilename());
        Date date = new Date(new java.util.Date().getTime());

        LostFoundItemsEntity lostFoundItemsEntity = new LostFoundItemsEntity(
                lostFoundDTO.getItemDescription(),
                lostFoundDTO.getLostItemArea(),
                lostFoundDTO.getCityName(),
                lostFoundDTO.getIsRequest(),
                false,
                date,
                new ImagesEntity(
                        uuid.toString(),
                        path.toString(),
                        lostFoundDTO.getIsRequest()
                                ? ImageCategories.LOST_FOUND_REQUEST.getNumber()
                                : ImageCategories.LOST_FOUND_DETECTED.getNumber(),
                        date
                )
        );
        try {
            byte[] bytes = image.getBytes();
            if (!Files.exists(path))
                Files.createDirectories(path.getParent());
            Files.write(path, bytes);
            return lostFoundItemsEntityRepository.save(lostFoundItemsEntity);
        } catch (Exception ex) {
            System.out.println("Error saving photo");
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                System.out.println("Error while deleting file");
                return null;
            }
            return null;
        }
    }

}