package net.foxandr.sport.universiade.restapi.lostfound;

import javax.persistence.Column;
import java.sql.Date;

public class LostFoundItemsDTO {
    private String itemDescription;

    private String lostItemArea;

    private String cityName;

    private Boolean isRequest;

    private String contactName;

    private String contactToNotify;

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

    public void setIsRequest(Boolean request) {
        isRequest = request;
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
}
