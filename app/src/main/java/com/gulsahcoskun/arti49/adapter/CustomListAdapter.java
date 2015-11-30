package com.gulsahcoskun.arti49.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gulsahcoskun.arti49.R;

import java.util.ArrayList;
import com.gulsahcoskun.arti49.model.NewsItem;
import com.squareup.picasso.Picasso;

/**
 * Created by Gulsah on 8/9/2015.
 */
public class CustomListAdapter extends BaseAdapter {
    private ArrayList listData;
    private LayoutInflater layoutInflater;
    private Context mContext;


    public CustomListAdapter(Context context,ArrayList listData){
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        mContext =context;
    }

    public int getCount(){
        return listData.size();
    }

    public Object getItem(int position){
        return listData.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position,View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView ==null){
            convertView = layoutInflater.inflate(R.layout.activity_list_item, null);
            holder = new ViewHolder();
            holder.headlineView = (TextView) convertView.findViewById(R.id.lbl_title);
            holder.introduction = (TextView) convertView.findViewById(R.id.lbl_intro);
            holder.imageV = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        NewsItem newsItem = (NewsItem) listData.get(position);
        holder.headlineView.setText(Html.fromHtml(newsItem.getTitle(), null, null));
        holder.introduction.setText(Html.fromHtml(newsItem.getExcerpt(),null,null));
       // holder.imageV.setImageDrawable(holder.imageV.getContext().getResources().getDrawable(R.drawable.icon2));
       // holder.imageV.setImageResource(R.drawable.icon2);

       /*if (holder.imageV != null) {
            new ImageDownloaderTask(holder.imageV).execute(newsItem.getAttachmentUrl());
       }*/
        Picasso.with(mContext)
                .load(newsItem.getAttachmentUrl())
                .placeholder(R.drawable.icon2)
                .error(R.drawable.icon2)
                .into(holder.imageV);




        return convertView;

    }

    static class ViewHolder {
        TextView headlineView;
        TextView introduction;
        ImageView imageV;
    }
}
