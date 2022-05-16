package net.foxandr.sport.universiade.restapi.lostfound;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.foxandr.sport.universiade.restapi.images.ImagesEntity;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "lost_found_items", schema = "universiade")
public class LostFoundItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "lost_item_area")
    private String lostItemArea;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "is_request")
    private Boolean isRequest;

    @Column(name = "is_found")
    private Boolean isFound;

    @Column(name = "created_on")
    private Instant createdOn;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JoinColumn(name = "image_uuid")
    private ImagesEntity imagesEntity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lostFoundItemsEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private LostFoundRequestsEntity lostFoundRequestsEntity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getLostItemArea() {
        return lostItemArea;
    }

    public void setLostItemArea(String lostItemArea) {
        this.lostItemArea = lostItemArea;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Boolean getIsRequest() {
        return isRequest;
    }

    public void setIsRequest(Boolean isRequest) {
        this.isRequest = isRequest;
    }

    public Boolean getIsFound() {
        return isFound;
    }

    public void setIsFound(Boolean isFound) {
        this.isFound = isFound;
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
        LostFoundItemsEntity that = (LostFoundItemsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(itemDescription, that.itemDescription) && Objects.equals(lostItemArea, that.lostItemArea) && Objects.equals(cityName, that.cityName) && Objects.equals(isRequest, that.isRequest) && Objects.equals(isFound, that.isFound) && Objects.equals(createdOn, that.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemDescription, lostItemArea, cityName, isRequest, isFound, createdOn);
    }

    public LostFoundRequestsEntity getLostFoundRequestsEntity() {
        return lostFoundRequestsEntity;
    }

    public void setLostFoundRequestsEntity(LostFoundRequestsEntity lostFoundRequestsEntity) {
        this.lostFoundRequestsEntity = lostFoundRequestsEntity;
    }

    public ImagesEntity getImagesEntity() {
        return imagesEntity;
    }

    public void setImagesEntity(ImagesEntity imagesEntity) {
        this.imagesEntity = imagesEntity;
    }

    public LostFoundItemsEntity(String itemDescription, String lostItemArea, String cityName, Boolean isRequest,
                                Boolean isFound, Instant createdOn, ImagesEntity imagesEntity) {
        this.itemDescription = itemDescription;
        this.lostItemArea = lostItemArea;
        this.cityName = cityName;
        this.isRequest = isRequest;
        this.isFound = isFound;
        this.createdOn = createdOn;
        this.imagesEntity = imagesEntity;
    }

    public LostFoundItemsEntity() {

    }
}
