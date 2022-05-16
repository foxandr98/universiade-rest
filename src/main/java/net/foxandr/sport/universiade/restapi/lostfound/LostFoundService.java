package net.foxandr.sport.universiade.restapi.lostfound;

import net.foxandr.sport.universiade.restapi.images.ImagesEntity;
import net.foxandr.sport.universiade.util.ImageCategories;
import net.foxandr.sport.universiade.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
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
            return generatedLostFoundItem;
        } catch (Exception ex) {
            return null;
        }
    }

    private LostFoundItemsEntity saveImageAndGetLostFoundEntity(LostFoundItemsDTO lostFoundDTO,
                                                                MultipartFile image) {
        UUID uuid = UUID.randomUUID();
        Path path = Paths.get("/images/lost-found/" + uuid + image.getOriginalFilename());
        Instant date = Instant.now();

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
        LostFoundRequestsEntity requestEntity = null;
        if (lostFoundDTO.getIsRequest()) {
            requestEntity = new LostFoundRequestsEntity(
                    lostFoundDTO.getContactName(),
                    lostFoundDTO.getContactToNotify()
            );
            requestEntity.setLostFoundItemsEntity(lostFoundItemsEntity);
        }
        lostFoundItemsEntity.setLostFoundRequestsEntity(requestEntity);

        return Utils.saveImageAndEntity(path, image, lostFoundItemsEntityRepository, lostFoundItemsEntity);
    }
}
