package com.example.a2yn2ashya2y;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class addItem extends AppCompatActivity {
    ImageView img;
    Uri selectedImageUri;
    final int SELECT_PICTURE = 200;
    String category;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getSupportActionBar().setBackgroundDrawable( new ColorDrawable(Color.parseColor("#2D423D")));

        Bundle extras = this.getIntent().getExtras();
        category = new String();
        img = (ImageView) findViewById(R.id.addImage);
        EditText name = (EditText) findViewById(R.id.prodName);
        EditText description = (EditText) findViewById(R.id.breifDescription);
        TextView quest1 = (TextView) findViewById(R.id.seqQues1);
        EditText ans1 = (EditText) findViewById(R.id.seqAns1);
        TextView quest2 = (TextView) findViewById(R.id.seqQues2);
        EditText ans2 = (EditText) findViewById(R.id.seqAns2);
        TextView quest3 = (TextView) findViewById(R.id.seqQues3);
        EditText ans3 = (EditText) findViewById(R.id.seqAns3);
        Button submitBut = (Button) findViewById(R.id.submitAddForm);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Categories2, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Log.i("GTOUTOUT", "Nothing Selected");
            }
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id)  {

                switch (i){
                    case 0:
                    {
                        category = "";
                        name.setHint("");
                        name.setEnabled(false);

                        description.setHint("");
                        description.setEnabled(false);

                        quest1.setText("");
                        quest1.setEnabled(false);
                        quest1.setTextColor(getResources().getColor(R.color.white));
                        quest1.setBackgroundColor(getResources().getColor(R.color.white));

                        ans1.setEnabled(false);
                        ans1.setHint("");

                        quest2.setText("");
                        quest2.setEnabled(false);
                        quest2.setTextColor(getResources().getColor(R.color.white));
                        quest2.setBackgroundColor(getResources().getColor(R.color.white));

                        ans2.setEnabled(false);
                        ans2.setHint("");

                        quest3.setText("");
                        quest3.setEnabled(false);
                        quest3.setTextColor(getResources().getColor(R.color.white));
                        quest3.setBackgroundColor(getResources().getColor(R.color.white));

                        ans3.setEnabled(false);
                        ans3.setHint("");

                        submitBut.setEnabled(false);
                        submitBut.setText("");
                        submitBut.setBackgroundColor(Color.WHITE);

                        img.setVisibility(View.INVISIBLE);
                        img.setEnabled(false);

                        break;

                    }
                    case 1:
                    {
                        category = "IDs";

                        name.setHint("First Name on ID");
                        name.setEnabled(true);

                        description.setHint("Write a brief Description about the Product");
                        description.setEnabled(true);

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

                        img.setVisibility(View.VISIBLE);
                        img.setEnabled(true);


                        break;
                    }
                    case 2:
                    {
                        category = "Keys";
                        name.setHint("Product Name");
                        name.setEnabled(true);

                        description.setHint("Write a brief Description about the Product");
                        description.setEnabled(true);

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

                        img.setVisibility(View.VISIBLE);
                        img.setEnabled(true);

                        break;
                    }
                    case 3:
                    {
                        category = "tech";
                        name.setHint("Product Name");
                        name.setEnabled(true);

                        description.setHint("Write a brief Description about the Product");
                        description.setEnabled(true);

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

                        img.setVisibility(View.VISIBLE);
                        img.setEnabled(true);

                        break;
                    }
                    default:
                    {
                        category = "other";
                        name.setHint("Product Name");
                        name.setEnabled(true);

                        description.setHint("Write a brief Description about the Product");
                        description.setEnabled(true);

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

                        img.setVisibility(View.VISIBLE);
                        img.setEnabled(true);

                        break;
                    }
                }
            }
        });

        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prodName = name.getText().toString();
                String desc = description.getText().toString();
                String q1 = ans1.getText().toString();
                String q2 = ans1.getText().toString();
                String q3 = ans1.getText().toString();
                String imageString = selectedImageUri.toString();

                if(prodName.equals("") || q1.equals("") || desc.equals("") ||
                        q2.equals("") || q3.equals("") || imageString.equals(""))
                {
                    Toast.makeText(addItem.this, "Please fill out all the questions",
                            Toast.LENGTH_SHORT).show();
                    return;

                }
                else
                {
                    try {
                        URL url = new URL("http://192.168.1.30:3000/addObject");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.setDoInput(true);
                        Log.println(Log.DEBUG, prodName, "PRODUCT NAME");
                        Log.println(Log.DEBUG, desc, "DESCRIPTION");
                        Log.println(Log.DEBUG, imageString, "IMAGE PATH");
                        Log.println(Log.DEBUG, extras.getString("userID"), "SID");
                        Log.println(Log.DEBUG, category, "CATEGORY");
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                                new BufferedOutputStream(con.getOutputStream()), StandardCharsets.UTF_8));
                        writer.write(("name=" + prodName + "&description=" + desc+
                                "&image=" + imageString+ "&SID=" + extras.getString("userID")+
                                "&category=" +category));
                        writer.flush();
                        writer.close();

                        con.getResponseCode();

                        URL url2 = new URL("http://192.168.1.30:3000/addAnswer");
                        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
                        con2.setRequestMethod("POST");
                        con2.setDoInput(true);
                        BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(
                                new BufferedOutputStream(con2.getOutputStream()), StandardCharsets.UTF_8));
                        writer2.write(("answer1=" + q1 + "&answer1=" + q2+ "&answer3=" + q3));
                        writer2.flush();
                        writer2.close();
                        con2.getResponseCode();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }


                Intent intent = new Intent(addItem.this,choicesActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }


    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    img.setImageURI(selectedImageUri);
                }
            }
        }
    }

}