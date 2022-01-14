package com.example.a2yn2ashya2y;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Verification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#153F27"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle("Verification");

        String catengoryName = getIntent().getExtras().getString("Categories");

        TextView quest1 = (TextView) findViewById(R.id.seqQues1);
        EditText ans1 = (EditText) findViewById(R.id.seqAns1);
        TextView quest2 = (TextView) findViewById(R.id.seqQues2);
        EditText ans2 = (EditText) findViewById(R.id.seqAns2);
        TextView quest3 = (TextView) findViewById(R.id.seqQues3);
        EditText ans3 = (EditText) findViewById(R.id.seqAns3);
        Button submitBut = (Button) findViewById(R.id.submitAddForm);

        switch (catengoryName){
                case "IDs":
                    quest1.setText("What is the name on the ID?");
                    quest1.setEnabled(true);
                    quest1.setTextColor(getResources().getColor(R.color.black));
                    quest1.setBackgroundColor(getResources().getColor(R.color.white));

                    ans1.setEnabled(true);
                    ans1.setHint("Name on ID");

                    quest2.setText("What is the ID number?");
                    quest2.setEnabled(true);
                    quest2.setTextColor(getResources().getColor(R.color.black));
                    quest2.setBackgroundColor(getResources().getColor(R.color.white));

                    ans2.setEnabled(true);
                    ans2.setHint("SID");

                    quest3.setText("When was the ID found?");
                    quest3.setEnabled(true);
                    quest3.setTextColor(getResources().getColor(R.color.black));
                    quest3.setBackgroundColor(getResources().getColor(R.color.white));

                    ans3.setEnabled(true);
                    ans3.setHint("When");

                    submitBut.setEnabled(true);
                    submitBut.setText(R.string.submit);
                    submitBut.setBackgroundColor(Color.parseColor("#2D423D"));
                    break;
                case "Keys":
                        quest1.setText("How many keys does it have?");
                        quest1.setEnabled(true);
                        quest1.setTextColor(getResources().getColor(R.color.black));
                        quest1.setBackgroundColor(getResources().getColor(R.color.white));

                        ans1.setEnabled(true);
                        ans1.setHint("Number of keys");

                        quest2.setText("Does it have a keychain? If so, what is on it");
                        quest2.setEnabled(true);
                        quest2.setTextColor(getResources().getColor(R.color.black));
                        quest2.setBackgroundColor(getResources().getColor(R.color.white));

                        ans2.setEnabled(true);
                        ans2.setHint("Keychain");

                        quest3.setText("When were the keys found?");
                        quest3.setEnabled(true);
                        quest3.setTextColor(getResources().getColor(R.color.black));
                        quest3.setBackgroundColor(getResources().getColor(R.color.white));

                        ans3.setEnabled(true);
                        ans3.setHint("When");

                        submitBut.setEnabled(true);
                        submitBut.setText(R.string.submit);
                        submitBut.setBackgroundColor(Color.parseColor("#2D423D"));

                    break;
                case "Technology":
                        quest1.setText("What is the model of the Product?");
                        quest1.setEnabled(true);
                        quest1.setTextColor(getResources().getColor(R.color.black));
                        quest1.setBackgroundColor(getResources().getColor(R.color.white));

                        ans1.setEnabled(true);
                        ans1.setHint("Product Model");

                        quest2.setText("Does it have any unique features?");
                        quest2.setEnabled(true);
                        quest2.setTextColor(getResources().getColor(R.color.black));
                        quest2.setBackgroundColor(getResources().getColor(R.color.white));

                        ans2.setEnabled(true);
                        ans2.setHint("Unique Features");

                        quest3.setText("When was the product found?");
                        quest3.setEnabled(true);
                        quest3.setTextColor(getResources().getColor(R.color.black));
                        quest3.setBackgroundColor(getResources().getColor(R.color.white));

                        ans3.setEnabled(true);
                        ans3.setHint("When");

                        submitBut.setEnabled(true);
                        submitBut.setText(R.string.submit);
                        submitBut.setBackgroundColor(Color.parseColor("#2D423D"));

                    break;
                case "Other":
                        quest1.setText("What is the Product?");
                        quest1.setEnabled(true);
                        quest1.setTextColor(getResources().getColor(R.color.black));
                        quest1.setBackgroundColor(getResources().getColor(R.color.white));

                        ans1.setEnabled(true);
                        ans1.setHint("Product Model");

                        quest2.setText("hat is the color of the product?");
                        quest2.setEnabled(true);
                        quest2.setTextColor(getResources().getColor(R.color.black));
                        quest2.setBackgroundColor(getResources().getColor(R.color.white));

                        ans2.setEnabled(true);
                        ans2.setHint("Product Color");

                        quest3.setText("When was the product lost?");
                        quest3.setEnabled(true);
                        quest3.setTextColor(getResources().getColor(R.color.black));
                        quest3.setBackgroundColor(getResources().getColor(R.color.white));

                        ans3.setEnabled(true);
                        ans3.setHint("When");

                        submitBut.setEnabled(true);
                        submitBut.setText(R.string.submit);
                        submitBut.setBackgroundColor(Color.parseColor("#2D423D"));

                    break;
        }

        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Verification.this,ContactInfo.class);
                startActivity(intent);
            }
        });

    }
}