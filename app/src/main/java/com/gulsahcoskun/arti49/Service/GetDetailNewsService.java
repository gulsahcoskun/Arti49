package com.gulsahcoskun.arti49.Service;

import org.json.JSONArray;

/**
 * Created by Saadet on 8/25/2015.
 */
public class GetDetailNewsService {

    public static String URL_GET_DETAIL_NEWS = ServiceHandler.URL_API;


    // JSON Node

    public static String TAG_ID = "id";
    public static String TAG_TITLE = "title";
    public static String TAG_EXCERPT = "excerpt_display";
    public static String TAG_URLS = "permalink";
    public static String TAG_CATEGORY = "category";
    public static String TAG_CATEGORY_SUB_ID = "id";
    public static String TAG_CATEGORY_SUB_NAME = "name";
    public static String TAG_STATUS = "status";
    public static String TAG_MEDIA = "media";
    public static String TAG_IMAGES_SIZES = "sizes";
    public static String TAG_IMAGE_URL = "url";
    public static String TAG_AUTHOR = "author";
    public static String TAG_AUTHOR_NAME = "display_name";
    public static String TAG_CONTENT = "content_display";



    // Verileri içinde tutacağım JSONArray

    public static JSONArray getDetailNewsJson = null;


}
