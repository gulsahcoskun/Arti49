package com.gulsahcoskun.arti49.Service;

import org.json.JSONArray;

/**
 * Created by Saadet on 8/25/2015.
 */
public class GetCategoryService {
    // JSON URL'lerim

    public static String URL_GET_CATEGORY = ServiceHandler.URL_API+"?cat=";


    // JSON Nodes
    public static String TAG_ID = "id";
    public static String TAG_NAME = "name";


    // Verileri içinde tutacağım JSONArray
    public static JSONArray getCategoryJson = null;

}
