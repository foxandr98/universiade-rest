package net.foxandr.sport.universiade.restapi.news;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.ImagesEntity;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "news", schema = "universiade")
public class NewsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "created_on")
    private Date createdOn;
    @OneToMany(mappedBy = "newsEntity",cascade = CascadeType.MERGE)
    @JsonManagedReference
    private List<NewsTEntity> newsTEntities;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "image_uuid")
    private ImagesEntity imagesEntity;


    public ImagesEntity getImagesEntity() {
        return imagesEntity;
    }

    public void setImagesEntity(ImagesEntity imagesEntity) {
        this.imagesEntity = imagesEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsEntity that = (NewsEntity) o;
        return Objects.equals(id, that.id)  && Objects.equals(createdOn, that.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdOn);
    }

    public List<NewsTEntity> getNewsTEntities() {
        return newsTEntities;
    }

    public void setNewsTEntities(List<NewsTEntity> newsTEntities) {
        this.newsTEntities = newsTEntities;
    }

    public NewsEntity(Date createdOn, ImagesEntity imagesEntity) {
        this.createdOn = createdOn;
        this.imagesEntity = imagesEntity;
    }

    public NewsEntity() {
    }
//
//    public void setImage_uuid(String image_uuid) {
//        this.image_uuid = image_uuid;
//    }
}
