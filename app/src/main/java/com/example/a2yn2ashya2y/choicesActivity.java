package com.example.a2yn2ashya2y;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class choicesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#153F27"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        Button add = (Button) findViewById(R.id.add);
        Button find = (Button) findViewById(R.id.find);
        Button report = (Button) findViewById(R.id.report);

        Bundle extras = this.getIntent().getExtras();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when clicking it go to FAB
                Intent intent = new Intent(getApplication(), Notification.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });


        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choicesActivity.this,categories.class);
                extras.putString("action", "Find");
                intent.putExtras(extras);
                startActivity(intent);

            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choicesActivity.this,categories.class);
                extras.putString("action", "Report");
                intent.putExtras(extras);
                startActivity(intent);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(choicesActivity.this,addItem.class);
                Bundle secExt = new Bundle();
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }
}