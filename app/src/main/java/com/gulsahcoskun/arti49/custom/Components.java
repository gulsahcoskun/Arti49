package com.gulsahcoskun.arti49.custom;

import android.app.ProgressDialog;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by gulsahcoskun on 22/08/15.
 */
public class Components {

// Genel Her Fragmentte Kullanılacak Konponentler
    public static ImageView imgNews;
    public static TextView lblNewsTitle;
    public static TextView lblNewsSubTitle;
    public static TextView lblDateTime;
    public static TextView lblCategory;
    public static TextView lblPageTitle;

    public static ProgressDialog progressDialog;  // Genel Her Servis İşleminde Kullanılacak Progress Dialog


    public static void showDialog(){
        progressDialog.setMessage("Lütfen Bekleyiniz...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public static void cancelDialog(){
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
