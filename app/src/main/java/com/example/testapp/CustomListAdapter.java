package com.example.testapp;

//import info.androidhive.customlistviewvolley.R;
//import info.androidhive.customlistviewvolley.app.AppController;
//import info.androidhive.customlistviewvolley.model.Movie;
import com.example.testapp.R;
import com.example.testapp.AppController;
import com.example.testapp.FoodItem;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<FoodItem> foodItems;
    private String TAG = "TAG";
    private String pref = "foodPref";
    SharedPreferences sharedPreferences;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<FoodItem> Items) {
        this.activity = activity;
        this.foodItems = Items;
    }

    @Override
    public int getCount() {
        return foodItems.size();
    }

    @Override
    public Object getItem(int location) {
        return foodItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        Button saveButton = (Button)convertView.findViewById(R.id.save);
        //TextView rating = (TextView) convertView.findViewById(R.id.rating);
        //TextView genre = (TextView) convertView.findViewById(R.id.genre);
        //TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
        FoodItem m = foodItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnail(), imageLoader);

        // title
        title.setText(m.getName());
        sharedPreferences = this.activity.getSharedPreferences(pref,Context.MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Button "+m.getName());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(m.getName(),m.getName());
                editor.commit();

            }
        });



        return convertView;
    }

}