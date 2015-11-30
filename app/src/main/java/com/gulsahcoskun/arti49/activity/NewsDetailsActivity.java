package com.gulsahcoskun.arti49.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.gulsahcoskun.arti49.R;
import com.gulsahcoskun.arti49.model.NewsItem;
import com.squareup.picasso.Picasso;

/**
 * Created by Saadet on 8/10/2015.
 */
public class NewsDetailsActivity extends AppCompatActivity {
    private NewsItem news;
    private Toolbar mToolbar;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);




        news = (NewsItem) this.getIntent().getSerializableExtra("feed");

        if(null != news){
            ImageView thumb = (ImageView) findViewById(R.id.featuredImg);
            //thumb.setImageDrawable(thumb.getContext().getResources().getDrawable(R.drawable.icon2));
            //new ImageDownloaderTask(thumb).execute(news.getAttachmentUrl());
            Picasso.with(this)
                    .load(news.getAttachmentUrl())
                    .placeholder(R.drawable.icon2)
                    .error(R.drawable.icon2)
                    .into(thumb);

            TextView title = (TextView) findViewById(R.id.title);
            title.setText(Html.fromHtml(news.getTitle(), null, null));

            TextView htmlTextView = (TextView) findViewById(R.id.content);
            htmlTextView.setText(Html.fromHtml(news.getContent(), null, null));

            TextView date = (TextView) findViewById(R.id.detail_date);
            date.setText(Html.fromHtml(news.getDate(), null, null));


            /*TextView entry = (TextView) findViewById(R.id.entry);
            entry.setText(Html.fromHtml(news.getExcerpt(),null,null));*/
        }

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.back_button:
                /*Intent intent = new Intent(NewsDetailsActivity.this, MainActivity.class);
                startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));*/
                finish();
                return true;
            case R.id.menu_share:
                shareContent();
                return true;
            case R.id.menu_view:
                Intent intentView = new Intent(NewsDetailsActivity.this, WebViewActivity.class);
                intentView.putExtra("url", news.getUrl());
                startActivity(intentView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareContent(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, news.getTitle() + "\n" + news.getUrl());
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Share using"));
    }

}
