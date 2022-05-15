package net.foxandr.sport.universiade.restapi.lostfound;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lost_found_requests", schema = "universiade")
public class LostFoundRequestsEntity {
    @Id
    @GeneratedValue
    @Column(name = "lost_found_item_id")
    private Long lostFoundItemId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_to_notify")
    private String contactToNotify;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "lost_found_item_id", insertable = false, updatable = false)
    private LostFoundItemsEntity lostFoundItemsEntity;

    public LostFoundItemsEntity getLostFoundItemsEntity() {
        return lostFoundItemsEntity;
    }

    public void setLostFoundItemsEntity(LostFoundItemsEntity lostFoundItemsEntity) {
        this.lostFoundItemsEntity = lostFoundItemsEntity;
    }

    public Long getLostFoundItemId() {
        return lostFoundItemId;
    }

    public void setLostFoundItemId(Long lostFoundItemId) {
        this.lostFoundItemId = lostFoundItemId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactToNotify() {
        return contactToNotify;
    }

    public void setContactToNotify(String contactToNotify) {
        this.contactToNotify = contactToNotify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LostFoundRequestsEntity that = (LostFoundRequestsEntity) o;
        return Objects.equals(lostFoundItemId, that.lostFoundItemId) && Objects.equals(contactName, that.contactName) && Objects.equals(contactToNotify, that.contactToNotify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lostFoundItemId, contactName, contactToNotify);
    }

    public LostFoundRequestsEntity(Long id, String contactName, String contactToNotify) {
        this.lostFoundItemId = id;
        this.contactName = contactName;
        this.contactToNotify = contactToNotify;
    }

    public LostFoundRequestsEntity(String contactName, String contactToNotify) {
        this.contactName = contactName;
        this.contactToNotify = contactToNotify;
    }

    public LostFoundRequestsEntity() {
    }
}
