package com.gulsahcoskun.arti49.model;

import java.io.Serializable;

/**
 * Created by Saadet on 8/9/2015.
 */
public class NewsItem implements Serializable {
    private String title;
    private String date;
    private String attachmentUrl;
    private String id;
    private String content;
    private String url;
    private String excerpt;
    private String categoryId;
    private String categoryName;



    /*public NewsItem(String title,String date,String attachmentUrl,String id,String content,String url,String excerpt,String categoryId,String categoryName){
        this.title = title;
        this.date = date;
        this.attachmentUrl = attachmentUrl;
        this.id = id;
        this.content = content;
        this.url = url;
        this.excerpt =excerpt;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
 */

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
