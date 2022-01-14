package com.example.a2yn2ashya2y;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class addItem extends AppCompatActivity {
    ImageView IVPreviewImage;
    final int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        getSupportActionBar().setBackgroundDrawable( new ColorDrawable(Color.parseColor("#2D423D")));


        IVPreviewImage = (ImageView) findViewById(R.id.addImage);
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

        IVPreviewImage.setOnClickListener(new View.OnClickListener() {
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
                        break;

                    }
                    case 1:
                    {
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
                    }
                    case 2:
                    {
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
                    }
                    case 3:
                    {
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
                    }
                    default:
                    {
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
                }
            }
        });

        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addItem.this,choicesActivity.class);
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
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }

}