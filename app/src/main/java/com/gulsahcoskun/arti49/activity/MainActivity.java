package com.gulsahcoskun.arti49.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.gulsahcoskun.arti49.R;
import com.gulsahcoskun.arti49.adapter.CustomListAdapter;
import com.gulsahcoskun.arti49.model.Category;
import com.gulsahcoskun.arti49.model.CategoryModel;
import com.gulsahcoskun.arti49.model.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener,SwipeRefreshLayout.OnRefreshListener {
    private static String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    //private ImageButton btnRefresh;
    private Category categoryList;
    private SliderLayout sliderLayout;
    private ViewPager mViewPager;
    private HashMap<String, String> sliderList;
    private String imgUrl;
    protected BaseSliderView.OnSliderClickListener mOnSliderClickListener;
    private SwipeRefreshLayout swipeRefreshLayout; // Aşağı çekince yenileneme özelliği sağlayan layoutum
    private ProgressDialog pDialog;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // btnRefresh = (ImageButton) findViewById(R.id.action_refresh);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        sliderList = new HashMap<String, String>();

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.ZoomOutSlide);  //Slider Animasyonu
        sliderLayout.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));//Slider İndicatoru
        sliderLayout.setCustomAnimation(new DescriptionAnimation()); //Slider Animasyonu
        sliderLayout.setDuration(4000); //Slider Animasyonu Saniye
        sliderLayout.addOnPageChangeListener(this); //Slider Animasyonu Listener

        //refreshTwoMinutes(); // İki Dk da bir yenileme metodum

        //btnRefresh.setOnClickListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        displayView(0);

        new GetNews().execute();
    }

  /*  private void refreshTwoMinutes() {


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                /*pager=1; // Yenilediğinde sayfa numaram tekrar bir oluyor
                allNewsModelList.clear(); // Yenilerken önce tüm haberlistesini temizliyorum
                new GetAllNews().execute(); // Tekrar haberleri servisten çekiyorum
                allNewsAdapter.notifyDataSetChanged();
                new GetNews().execute();
                sliderLayout.removeAllSliders(); // Slider Yenileniyor
                handler.postDelayed(this, 120000);
            }
        }, 120000);
    }
*/

    public void updateList() {
        feedListView = (ListView) findViewById(R.id.list);

        feedListView.setAdapter(new CustomListAdapter(MainActivity.this, feedList));
        feedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = feedListView.getItemAtPosition(position);
                NewsItem newsData = (NewsItem) o;

                Intent intent = new Intent(MainActivity.this, NewsDetailsActivity.class);
                intent.putExtra("feed", newsData);
                startActivity(intent);

            }
        });


        for (String name : sliderList.keySet()) {
            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(sliderList.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(MainActivity.this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }

        swipeRefreshLayout.setRefreshing(false);



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        View fragmentView;
        switch (position) {
            case 0:
                fragment = new AnaSayfaFragment();
                title = "Arti49";
                //mToolbar.setLogo(R.drawable.arti49_logo);
                break;
            case 1:
                fragment = new SonDakikaFragment();
                title = getString(R.string.title_sondakika);
                break;
            case 2:
                fragment = new GundemFragment();
                title = getString(R.string.title_gundem);
                break;
            case 3:
                fragment = new TurkiyeFragment();
                title = getString(R.string.title_turkiye);
                break;
            case 4:
                fragment = new DunyaFragment();
                title = getString(R.string.title_dunya);
                break;
            case 5:
                fragment = new SiyasetFragment();
                title = getString(R.string.title_siyaset);
                break;
            case 6:
                fragment = new EkonomiFragment();
                title = getString(R.string.title_ekonomi);
                break;
            case 7:
                fragment = new KulturFragment();
                title = getString(R.string.title_kultur);
                break;
            case 8:
                fragment = new SporFragment();
                title = getString(R.string.title_spor);
                break;
            case 9:
                fragment = new YasamFragment();
                title = getString(R.string.title_yasam);
                break;
            case 10:
                fragment = new RoportajFragment();
                title = getString(R.string.title_roportaj);
                break;
            case 11:
                fragment = new AlmanyaFragment();
                title = getString(R.string.title_almanya);

                break;
            case 12:
                fragment = new FransaFragment();
                title = getString(R.string.title_fransa);
                break;
            case 13:
                fragment = new BelcikaFragment();
                title = getString(R.string.title_belcika);
                break;
            case 14:
                fragment = new IsvicreFragment();
                title = getString(R.string.title_isvicre);
                break;
            case 15:
                fragment = new HollandaFragment();
                title = getString(R.string.title_hollanda);
                break;
            case 16:
                fragment = new AvusturyaFragment();
                title = getString(R.string.title_avusturya);
                break;
            case 17:
                fragment = new DeutschFragment();
                title = getString(R.string.title_deutsch);
                break;
            case 18:
                fragment = new EnglishFragment();
                title = getString(R.string.title_english);
                break;


            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    /*protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        sliderLayout.stopAutoCycle();
        super.onStop();
    }*/

    @Override
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
        startActivity(gotoNewsScreen);*/

    }

    public void onDestroy() {
        super.onDestroy();
        Log.i("service", "service killed");
    }

    /**
     * Exit the app if user select yes.
     */
    private void doExit() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                MainActivity.this);

        alertDialog.setPositiveButton("Evet", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialog.setNegativeButton("Hayir", null);

        alertDialog.setMessage("Uygulamadan cikmak istediginize emin misiniz?");
        alertDialog.setTitle("Arti49");
        alertDialog.show();
    }
    public void onBackPressed() {

        doExit();
    }

    @Override
    public void onRefresh() {
        sliderLayout.removeAllSliders();
        new GetNews().execute();
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
     */

        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(MainActivity.this);
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

                            }*/

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
                            if(null != categories && categories.length() >0 ){
                                JSONObject categoryId = categories.getJSONObject(0);
                                item.setCategoryId(categoryId.getString(TAG_CAT_ID));

                            }

                            sliderList.put(Html.fromHtml((String) post.getString(TAG_TITLE)).toString(), imgUrl);

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
}

