package com.gulsahcoskun.arti49.Service;

import org.json.JSONArray;

/**
 * Created by Saadet on 8/25/2015.
 */
public class GetAllNewsService {


        // JSON URL'lerim

        public static String URL_GET_ALL_NEWS = ServiceHandler.URL_API;
        public static String URL_GET_CATEGORY_NEWS = ServiceHandler.URL_API+"?cat=";


        // JSON Node isimleri
        public static String TAG_TYPE = "type";
        public static String TAG_ID = "id";
        public static String TAG_TITLE = "title";
        public static String TAG_EXCERPT = "excerpt_display";
        public static String TAG_URLS = "permalink";
        public static String TAG_TAXONOMIES = "taxonomies";
        public static String TAG_CATEGORY = "category";
        public static String TAG_CATEGORY_SUB_ID = "id";
        public static String TAG_CATEGORY_SUB_NAME = "name";
        public static String TAG_STATUS = "status";
        public static String TAG_MEDIA = "media";
        public static String TAG_IMAGES_SIZES = "sizes";
        public static String TAG_IMAGE_URL = "url";




        // Verileri içinde tutacağım JSONArray
        public static JSONArray getAllNewsJson = null;




}
