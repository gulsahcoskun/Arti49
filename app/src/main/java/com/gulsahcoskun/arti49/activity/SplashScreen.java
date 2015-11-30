package com.gulsahcoskun.arti49.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.gulsahcoskun.arti49.R;

/**
 * Created by Gulsah on 8/14/2015.
 */
public class SplashScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread background = new Thread(){
            public void run(){
                try{
                    //Thread will sleep for 5 seconds
                    sleep(1000);

                    //After 5 seconds
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);

                    //remove activity
                    finish();

                }catch(Exception e){

                }
            }
        };

        background.start();
    }


    protected void onDestroy(){
        super.onDestroy();
    }
}
