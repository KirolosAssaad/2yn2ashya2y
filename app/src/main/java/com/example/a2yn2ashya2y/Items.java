package com.example.a2yn2ashya2y;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Items extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#153F27"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        String CategoryName = getIntent().getExtras().getString("Categories");
        getSupportActionBar().setTitle(CategoryName);

        ListView list_view = (ListView) findViewById(R.id.itemsList);

        String[] itemName = null;
        int itemImage;

        switch (CategoryName){
            case "IDs":
                itemName = getResources().getStringArray(R.array.IDS);
                itemImage = R.drawable.idpic;
                break;
            case "Keys":
                itemName = getResources().getStringArray(R.array.Keys);
                itemImage = R.drawable.key;
                break;
            case "Technology":
                itemName = getResources().getStringArray(R.array.Technology);
                itemImage = R.drawable.tech;
                break;
            case "Other":
                itemName = getResources().getStringArray(R.array.Other);
                itemImage = R.drawable.other;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + CategoryName);
        }

        ItemsAdapter adapter = new ItemsAdapter(Items.this,itemName,itemImage);
        list_view.setAdapter(adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Items.this, Verification.class);
                intent.putExtra("Categories", CategoryName); //pass the category name
                startActivity(intent);
            }
        });

    }
}