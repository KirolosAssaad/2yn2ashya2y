package com.example.a2yn2ashya2y;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class ContactInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#153F27"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle("Contact Info");

        TextView name = (TextView) findViewById(R.id.name);
        TextView number = (TextView) findViewById(R.id.number);
        TextView call = (TextView) findViewById(R.id.call);

        name.setText("Mariam Elsaqa");
        number.setText("01001143450");

    }
}