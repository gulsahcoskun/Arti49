package com.gulsahcoskun.arti49.activity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulsahcoskun.arti49.R;

/**
 * Created by Gulsah on 31.07.2015.
 */
public class SonDakikaFragment extends Fragment {
    public SonDakikaFragment(){

    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_sondakika,container,false);
        return rootView;
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    public void onDetach(){
        super.onDetach();
    }
}


