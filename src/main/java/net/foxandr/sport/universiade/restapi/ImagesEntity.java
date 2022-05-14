package net.foxandr.sport.universiade.restapi;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.lostfound.LostFoundItemsEntity;
import net.foxandr.sport.universiade.restapi.news.NewsEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "images", schema = "universiade")
public class ImagesEntity {
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "img_ref")
    private String imgRef;

//    @OneToOne(mappedBy = "imagesEntity", fetch = FetchType.LAZY)
//    @JsonBackReference
//    private LostFoundItemsEntity lostFoundItemsEntity;
//
//
//    @OneToOne(mappedBy = "imagesEntity", fetch = FetchType.LAZY)
//    @JsonBackReference
//    private NewsEntity newsEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "img_category_id")
    private ImageCategoriesEntity imageCategoriesEntity;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ImageCategoriesEntity getImageCategoriesEntity() {
        return imageCategoriesEntity;
    }

    public void setImageCategoriesEntity(ImageCategoriesEntity imageCategoriesEntity) {
        this.imageCategoriesEntity = imageCategoriesEntity;
    }

    public String getImgRef() {
        return imgRef;
    }

    public void setImgRef(String imgRef) {
        this.imgRef = imgRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagesEntity that = (ImagesEntity) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(imgRef, that.imgRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, imgRef);
    }

//    public LostFoundItemsEntity getLostFoundItemsEntity() {
//        return lostFoundItemsEntity;
//    }
//
//    public void setLostFoundItemsEntity(LostFoundItemsEntity lostFoundItemsEntity) {
//        this.lostFoundItemsEntity = lostFoundItemsEntity;
//    }
//
//    public NewsEntity getNewsEntity() {
//        return newsEntity;
//    }
//
//    public void setNewsEntity(NewsEntity newsEntity) {
//        this.newsEntity = newsEntity;
//    }
}
