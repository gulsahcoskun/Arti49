package com.gulsahcoskun.arti49.model;

/**
 * Created by Saadet on 8/25/2015.
 */
public class DetailNewsModel {
    String authorName;
    String authorAlias;
    String authorImagesPage;
    String authorImagesGrid;
    String authorImagesList;
    String text;

    public DetailNewsModel(String text) {
        this.text = text;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAlias() {
        return authorAlias;
    }

    public void setAuthorAlias(String authorAlias) {
        this.authorAlias = authorAlias;
    }

    public String getAuthorImagesPage() {
        return authorImagesPage;
    }

    public void setAuthorImagesPage(String authorImagesPage) {
        this.authorImagesPage = authorImagesPage;
    }

    public String getAuthorImagesGrid() {
        return authorImagesGrid;
    }

    public void setAuthorImagesGrid(String authorImagesGrid) {
        this.authorImagesGrid = authorImagesGrid;
    }

    public String getAuthorImagesList() {
        return authorImagesList;
    }

    public void setAuthorImagesList(String authorImagesList) {
        this.authorImagesList = authorImagesList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


