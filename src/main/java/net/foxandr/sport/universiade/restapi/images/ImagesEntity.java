package net.foxandr.sport.universiade.restapi.images;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "images", schema = "universiade")
public class ImagesEntity {
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "img_ref")
    private String imgRef;

    @Column(name = "img_category_id")
    private Long categoryId;

    @Column(name = "created_on")
    private Instant createdOn;

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "img_category_id", updatable = false, insertable = false)
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

    public ImagesEntity() {
    }

    public ImagesEntity(String uuid, String imgRef, Long categoryId, Instant createdOn) {
        this.uuid = uuid;
        this.imgRef = imgRef;
        this.categoryId = categoryId;
        this.createdOn = createdOn;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
