package net.foxandr.sport.universiade.restapi.images;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesEntityRepository extends JpaRepository<ImagesEntity, String> {

    ImagesEntity getImagesEntityByUuid(String uuid);

}
