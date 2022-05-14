package net.foxandr.sport.universiade.restapi;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "image_categories", schema = "universiade")
public class ImageCategoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "imageCategoriesEntity")
    @JsonBackReference
    private List<ImagesEntity> imagesEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageCategoriesEntity that = (ImageCategoriesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public List<ImagesEntity> getImagesEntities() {
        return imagesEntities;
    }

    public void setImagesEntities(List<ImagesEntity> imagesEntities) {
        this.imagesEntities = imagesEntities;
    }
}
