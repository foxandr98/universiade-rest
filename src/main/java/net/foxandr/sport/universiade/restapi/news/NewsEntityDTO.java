package net.foxandr.sport.universiade.restapi.news;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class NewsEntityDTO {
    private String locale;
    private String title;
    private String text;

    private MultipartFile imageFile;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
