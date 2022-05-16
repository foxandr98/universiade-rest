package net.foxandr.sport.universiade.restapi.news;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.images.ImagesEntity;
import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "news", schema = "universiade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NewsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "created_on")
    private Instant createdOn;
    @OneToMany(mappedBy = "id.newsEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<NewsTEntity> newsTEntities;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
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

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
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

    public NewsEntity(Instant createdOn, ImagesEntity imagesEntity) {
        this.createdOn = createdOn;
        this.imagesEntity = imagesEntity;
    }

    public NewsEntity() {
    }

}
