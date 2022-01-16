package com.example.a2yn2ashya2y;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        String[] itemImage = null;

        try {
            URL url = new URL("http://192.168.1.30:3000/objectFetch");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new BufferedOutputStream(con.getOutputStream()), StandardCharsets.UTF_8));
            writer.write(("category="+CategoryName));
            writer.flush();
            writer.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String decodedString = in.readLine();
            con.getResponseCode();

            JSONArray jArray = new JSONArray(decodedString);
            Log.println(Log.DEBUG, decodedString, "QUERY RESULT2");
            Log.println(Log.DEBUG, jArray.toString(), "QUERY RESULT");
            itemName = new String[jArray.length()];
            itemImage = new String[jArray.length()];
            for(int i=0;i<itemName.length;i++)
            {
                JSONObject jObj = jArray.getJSONObject(i);
                Log.println(Log.DEBUG, jObj.getString("name"), "name");
                Log.println(Log.DEBUG, jObj.getString("image"), "image");

                itemName[i] = jObj.getString("name");
                itemImage[i] = jObj.getString("image");


            }

            Log.println(Log.DEBUG, decodedString, "Query Result");
            if(decodedString.equals("[]"))
            {
                Toast.makeText(Items.this, "NO ITEMS FOUND",
                        Toast.LENGTH_SHORT).show();
            }
            else {

                ItemsAdapter adapter = new ItemsAdapter(Items.this, itemName, itemImage);
                list_view.setAdapter(adapter);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


//        switch (CategoryName){
//            case "IDs":
//                itemName = getResources().getStringArray(R.array.IDS);
//                itemImage = R.drawable.idpic;
//                break;
//            case "Keys":
//                itemName = getResources().getStringArray(R.array.Keys);
//                itemImage = R.drawable.key;
//                break;
//            case "Technology":
//                itemName = getResources().getStringArray(R.array.Technology);
//                itemImage = R.drawable.tech;
//                break;
//            case "Other":
//                itemName = getResources().getStringArray(R.array.Other);
//                itemImage = R.drawable.other;
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + CategoryName);
//        }



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