package net.foxandr.sport.universiade.restapi.lostfound;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LostFoundItemsEntityRepository extends JpaRepository<LostFoundItemsEntity, String> {

    @Query("SELECT l FROM LostFoundItemsEntity l " +
            "LEFT JOIN FETCH l.lostFoundRequestsEntity lf " +
            "JOIN FETCH l.imagesEntity i " +
            "JOIN FETCH i.imageCategoriesEntity ic")
    List<LostFoundItemsEntity> findAll();


    @Query("SELECT l FROM LostFoundItemsEntity l " +
            "LEFT JOIN FETCH l.lostFoundRequestsEntity lf " +
            "JOIN FETCH l.imagesEntity i " +
            "JOIN FETCH i.imageCategoriesEntity ic " +
            "WHERE l.isRequest = :isRequest AND l.isFound = :isFound")
    List<LostFoundItemsEntity> findAllByIsRequestAndIsFound(boolean isRequest, boolean isFound);


}
