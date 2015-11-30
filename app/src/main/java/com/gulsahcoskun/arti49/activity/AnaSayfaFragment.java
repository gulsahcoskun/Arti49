package com.gulsahcoskun.arti49.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.gulsahcoskun.arti49.R;
import com.gulsahcoskun.arti49.adapter.CustomListAdapter;
import com.gulsahcoskun.arti49.model.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Gulsah on 31.07.2015.
 */
public class AnaSayfaFragment extends Fragment {

    /*
    private SliderLayout sliderLayout;
    private ViewPager mViewPager;
    private HashMap<String, String> sliderList;
    private String imgUrl;
    protected BaseSliderView.OnSliderClickListener mOnSliderClickListener;
    private SwipeRefreshLayout swipeRefreshLayout; // Aşağı çekince yenileneme özelliği sağlayan layoutum
    private ProgressDialog pDialog;
    private View rootView;
    private Activity activity;
    private OnFragmentInteractionListener mListener;


    //url to get news
    private static String url = "http://arti49.com/mobbing/v1/posts";
    private static String catUrl = "http://arti49.com/mobbing/v1/posts?cat=1";

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
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_TAXONOMIES = "taxonomies";
    private static final String TAG_CAT_ID = "id";
    private static final String TAG_CAT_NAME = "name";


    //posts Json Array
    //JSONArray posts = null;

    private ArrayList<NewsItem> feedList = null;
    private ListView feedListView = null;
    //public ArrayList<NewsTaxonomy> cat = new ArrayList<NewsTaxonomy>();

*/
    public AnaSayfaFragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_anasayfa, container, false);

      /*  activity = this.getActivity();

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);

        sliderLayout = (SliderLayout) rootView.findViewById(R.id.slider);
        sliderList = new HashMap<String, String>();

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.ZoomOutSlide);  //Slider Animasyonu
        sliderLayout.setCustomIndicator((PagerIndicator) rootView.findViewById(R.id.custom_indicator));//Slider İndicatoru
        sliderLayout.setCustomAnimation(new DescriptionAnimation()); //Slider Animasyonu
        sliderLayout.setDuration(4000); //Slider Animasyonu Saniye
        sliderLayout.addOnPageChangeListener(this); //Slider Animasyonu Listener

        //refreshTwoMinutes(); // İki Dk da bir yenileme metodum

        //btnRefresh.setOnClickListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);

        new GetNews().execute();

*/
        return rootView;
    }

 /*   public void updateList() {
        feedListView = (ListView) rootView.findViewById(R.id.list);

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


        for (String name : sliderList.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(sliderList.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }

        swipeRefreshLayout.setRefreshing(false);


    }


    /*  public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            new GetNews().execute();
            sliderLayout.removeAllSliders();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Log.d("Slider Demo", "Page Changed: " + i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
           /* Object o = feedList.equals(slider.getBundle().get("extra"));
            NewsItem newsData = (NewsItem) o;*/

       /*Object o = sliderLayout.getCurrentSlider();
        NewsItem newsData = (NewsItem) o;
        Intent intent = new Intent(MainActivity.this, NewsDetailsActivity.class);
        intent.putExtra("feed", newsData);
        startActivity(intent);*/
        //Toast.makeText(MainActivity.this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
       /* Intent gotoNewsScreen=new Intent(MainActivity.this,NewsDetailsActivity.class);
        gotoNewsScreen.putExtra("feed",newsData);
        startActivity(gotoNewsScreen);

    }


    public void onRefresh() {
        sliderLayout.removeAllSliders();
        new GetNews().execute();
    }


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public interface OnFragmentInteractionListener {
        public void onNavFragmentInteraction(Uri uri);
    }


    private class GetNews extends AsyncTask<Void, Void, Void> {

        protected void onProgressUpdate(Integer... values) {
        }
     /*
     public void addCat(NewsTaxonomy tax) {
         cat.add(tax);
     }

     public void addCat(List<NewsTaxonomy> taxes) {
         if (taxes == null) return;
         Iterator<NewsTaxonomy> iter = taxes.iterator();
         while (iter.hasNext()) {
             cat.add(iter.next());
         }
     }

     public List<NewsTaxonomy> getTaxonomies() {
         return cat;
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


            String jsonStr = sh.makeServiceCall(catUrl, ServiceHandler.GET);

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

                            }

                            JSONArray images = post.getJSONArray(TAG_MEDIA);
                            if (null != images && images.length() > 0) {
                                JSONObject sizes = (JSONObject) images.getJSONObject(0);
                                JSONArray size = sizes.getJSONArray(TAG_SIZES);

                                if (null != size && size.length() > 0) {
                                    JSONObject attachment = size.getJSONObject(0);
                                    if (attachment != null)
                                        item.setAttachmentUrl(attachment.getString(TAG_MEDIA_URL));
                                    imgUrl = attachment.getString(TAG_MEDIA_URL);
                                }

                            }

                            JSONObject taxonomies = post.getJSONObject(TAG_TAXONOMIES);
                            JSONArray categories = taxonomies.getJSONArray(TAG_CATEGORY);
                            if (null != categories && categories.length() > 0) {
                                JSONObject categoryId = categories.getJSONObject(0);
                                item.setCategoryId(categoryId.getString(TAG_CAT_ID));

                            }

                            sliderList.put(Html.fromHtml((String) post.getString(TAG_TITLE)).toString(), imgUrl);

                            feedList.add(item);
                        }

                    }

                } catch (JSONException e) {
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