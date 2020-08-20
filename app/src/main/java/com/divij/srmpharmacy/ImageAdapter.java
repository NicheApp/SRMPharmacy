package com.divij.srmpharmacy;
import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    List<String> myimages;

    // Constructor
    public ImageAdapter(Context c, List<String> allimages) {
        mContext = c;
        myimages=allimages;
    }

    public int getCount() {
        return myimages.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        Picasso.get()
                .load(myimages.get(position))
                .fit()
                .into(imageView);
      //  imageView.setImageURI();
       // imageView.setImageResource(myimages.get(position));
        return imageView;
    }



}