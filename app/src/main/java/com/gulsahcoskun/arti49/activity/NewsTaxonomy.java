package com.gulsahcoskun.arti49.activity;

/**
 * Created by Saadet on 8/24/2015.
 */
public class NewsTaxonomy {
    public enum TAXONOMY_TYPE {CATEGORY, TAG};
    public TAXONOMY_TYPE type = null;
    public String name = "";
    public int id = 0;
    public int post_count = 0;

    public NewsTaxonomy(int id, String name, int post_count, TAXONOMY_TYPE type) {
        this.id = id;
        this.name = name;
        this.post_count = post_count;
        this.type = type;
    }
}
