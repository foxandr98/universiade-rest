package net.foxandr.sport.universiade.restapi.news;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class NewsEntityDTO {

    //    public static class NewsSubEntityDTO {
//        private String locale;
//        private String title;
//        private String text;
//        public String getLocale() {
//            return locale;
//        }
//        public void setLocale(String locale) {
//            this.locale = locale;
//        }
//        public String getTitle() {
//            return title;
//        }
//        public void setTitle(String title) {
//            this.title = title;
//        }
//        public String getText() {
//            return text;
//        }
//        public void setText(String text) {
//            this.text = text;
//        }
//    }
//
//    private ArrayList<NewsSubEntityDTO> localedList;
//    private MultipartFile imageFile;
//
//    public MultipartFile getImageFile() {
//        return imageFile;
//    }
//    public void setImageFile(MultipartFile imageFile) {
//        this.imageFile = imageFile;
//    }
//
//    public ArrayList<NewsSubEntityDTO> getLocaledList() {
//        return localedList;
//    }
//    public void setLocaledList(ArrayList<NewsSubEntityDTO> localedText) {
//        this.localedList = localedText;
//    }
    private String locale;
    private String title;
    private String text;

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
}
