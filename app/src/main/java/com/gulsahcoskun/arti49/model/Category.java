package com.gulsahcoskun.arti49.model;

import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by Saadet on 8/20/2015.
 */
public class Category {
    private static ArrayList<Pair<Integer,String>> cats = new ArrayList<>();
    public static void add(Integer id, String name) {
        cats.add(new Pair<Integer, String>(id, name));
    }

    public static void add(int id, String name) {
        add(new Integer(id), name);
    }

    public Integer getId(String name) {
        for (Pair<Integer,String> c : cats) {
            if (name.equals(c.second)) {
                return c.first;
            }
        }

        return null;
    }

    public String getName(Integer id) {
        for (Pair<Integer,String> c : cats) {
            if (id == c.first) {
                return c.second;
            }
        }

        return null;
    }

    static {
        Category.add(196, "Almanya");
        Category.add(2266, "Avusturya");
        Category.add(2263, "Belçika");
        Category.add(411, "DEUTSCH");
        Category.add(243, "Dünya");
        Category.add(242, "Ekonomi");
        Category.add(3815, "ENGLISH");
        Category.add(2262, "Fransa");
        Category.add(1672, "Güncel");
        Category.add(1, "Gündem");
        Category.add(2265, "Hollanda");
        Category.add(2264, "İsviçre");
        Category.add(1211, "Kültür");
        Category.add(2197, "Röportaj");
        Category.add(1806, "Siyaset");
        Category.add(2379, "Son Dakika");
        Category.add(342, "Spor");
        Category.add(237, "Türkiye");
        Category.add(2254, "Video");
        Category.add(236, "Yaşam");
    }






}
