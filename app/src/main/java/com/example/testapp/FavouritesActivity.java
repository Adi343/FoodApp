package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Map;

public class FavouritesActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    private String TAG = "TAG";
    private String pref = "foodPref";
    private int n = 0;
    private ListView foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        foodList = (ListView)findViewById(R.id.foodList);
        sharedPreferences = this.getSharedPreferences(pref,MODE_PRIVATE);

        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            //Log.d(TAG, entry.getKey() + ": " + entry.getValue().toString());
            n++;
        }

        String[] list = new String[n];
        int i = 0;
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d(TAG, entry.getKey() + ": " + entry.getValue().toString());
            list[i] = entry.getValue().toString();
            Log.d(TAG,"list[i] is "+list[i]);
            i++;
        }

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        foodList.setAdapter(itemsAdapter);


    }
}