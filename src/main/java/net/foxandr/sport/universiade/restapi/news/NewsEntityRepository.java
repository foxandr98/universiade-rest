package net.foxandr.sport.universiade.restapi.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsEntityRepository extends JpaRepository<NewsEntity, Long> {

    @Query("SELECT n FROM NewsEntity n " +
            "JOIN FETCH n.newsTEntities nt " +
            "JOIN FETCH n.imagesEntity i " +
            "JOIN FETCH i.imageCategoriesEntity ic " +
            "WHERE nt.locale = :locale")
    List<NewsEntity> findAllByLocale(String locale);
}
