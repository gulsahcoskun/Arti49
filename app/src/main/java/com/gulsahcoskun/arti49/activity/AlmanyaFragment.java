package com.gulsahcoskun.arti49.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.gulsahcoskun.arti49.R;
import com.gulsahcoskun.arti49.adapter.CustomListAdapter;
import com.gulsahcoskun.arti49.model.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Gulsah on 31.07.2015.
 */
public class AlmanyaFragment extends Fragment  {
    private Toolbar mToolbar;
    private static String url = "http://arti49.com/mobbing/v1/posts?cat=3815";

    //JSON node names
    private static final String TAG_POSTS = "posts";
    private static final String TAG_ID = "id";
    private static final String TAG_TITLE = "title";
    private static final String TAG_DATE = "date";
    private static final String TAG_URL = "permalink";
    private static final String TAG_MEDIA_URL = "url";
    private static final String TAG_MEDIA = "media";
    private static final String TAG_ENTRY = "excerpt_display";
    private static final String TAG_CONTENT = "content_display";
    private static final String TAG_TYPE = "type";
    private static final String TAG_SIZES = "sizes";


    private ArrayList<NewsItem> feedList = null;
    private ListView feedListView = null;
    private View rootView;
    private ProgressDialog pDialog;


    //posts Json Array
    //JSONArray posts = null;

    public AlmanyaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_almanya, container, false);

        new GetContacts().execute();


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


   /* public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_almanya,
                container, false);

        new GetContacts().execute();

        return root;
        }








    public void updateList() {
        feedListView = (ListView) rootView.findViewById(R.id.listFragment);

        feedListView.setAdapter(new CustomListAdapter(getActivity(), feedList));
        feedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = feedListView.getItemAtPosition(position);
                NewsItem newsData = (NewsItem) o;

                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                intent.putExtra("feed", newsData);
                startActivity(intent);

            }
        });
    }




    private class GetContacts extends AsyncTask<Void, Void, Void> {

        protected void onProgressUpdate(Integer... values) {
        }


        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        protected Void doInBackground(Void... arg0) {
            ServiceHandler sh = new ServiceHandler();

            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response:", ">" + jsonStr);


            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    // ArrayList<NewsTaxonomy> cats = new ArrayList<NewsTaxonomy>();  //gerekirse silinecek**


                    JSONArray posts = jsonObject.getJSONArray(TAG_POSTS);

                    feedList = new ArrayList();

                    for (int i = 0; i < posts.length(); i++) {
                        JSONObject post = (JSONObject) posts.getJSONObject(i);
                        if (post.getString(TAG_TYPE).equals("post")) {
                            NewsItem item = new NewsItem();


                            item.setTitle(post.getString(TAG_TITLE));
                            item.setDate(post.getString(TAG_DATE));
                            item.setId(post.getString(TAG_ID));
                            item.setUrl(post.getString(TAG_URL));
                            item.setContent(post.getString(TAG_CONTENT));
                            item.setExcerpt(post.getString(TAG_ENTRY));

                               /*gerekirse silinecek**
                            JSONObject taxList = post.getJSONObject("taxonomies");
                            JSONObject catList = taxList.getJSONObject("category");
                            JSONObject tax = null;
                            Iterator<String> iter = catList.keys();
                            //cats.clear();
                            while (iter.hasNext()) {
                                tax = catList.getJSONObject(iter.next());
                                cats.add(new NewsTaxonomy(
                                        tax.getInt("id"), tax.getString("name"), tax.getInt("post_count"), NewsTaxonomy.TAXONOMY_TYPE.CATEGORY
                                ));

                            } */
/*
                            JSONArray images = post.getJSONArray(TAG_MEDIA);
                            if (null != images && images.length() > 0) {
                                JSONObject sizes = (JSONObject) images.getJSONObject(0);
                                JSONArray size = sizes.getJSONArray(TAG_SIZES);

                                if (null != size && size.length() > 0) {
                                    JSONObject attachment = size.getJSONObject(0);
                                    if (attachment != null)
                                        item.setAttachmentUrl(attachment.getString(TAG_MEDIA_URL));
                                }

                            }



                            feedList.add(item);
                        }

                    }

                }

                catch (JSONException e) {
                    e.printStackTrace();

                }

            }
            return null;

        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            if (null != feedList) {
                updateList();

            }

        }
            }
 */
}
