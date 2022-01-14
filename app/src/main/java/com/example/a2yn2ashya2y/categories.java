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

public class categories extends AppCompatActivity {

    String[] Categories;
    int[] Images = {
            R.drawable.idpic,
            R.drawable.key,
            R.drawable.tech,
            R.drawable.other,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#153F27"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle("Categories");

        Categories = getResources().getStringArray(R.array.Categories);

        ListView list_view = (ListView) findViewById(R.id.categoriesList);

        CategoriesAdapter adapter = new CategoriesAdapter(categories.this,Categories,Images);
        list_view.setAdapter(adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(categories.this, Items.class);
                intent.putExtra("Categories", Categories[i]); //pass the category name
                startActivity(intent);
            }
        });

    }
}