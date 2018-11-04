package com.example.hariprasad.thelocalherald;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.name;

public class AddNewsActivity extends AppCompatActivity {

    EditText heading, description, date, pincode, place ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);

        heading = (EditText)findViewById(R.id.etHeading_AN);
        description = (EditText)findViewById(R.id.etDescription_AN);
        date = (EditText)findViewById(R.id.etDate_AN);
        pincode = (EditText)findViewById(R.id.etPincode_AN);
        place = (EditText)findViewById(R.id.etLocality_AN);
    }

    public void AddNews(View view)
    {
        String str_heading = heading.getText().toString();
        String str_description = description.getText().toString();
        String str_date = date.getText().toString();
        String str_pincode = pincode.getText().toString();
        String str_place = place.getText().toString();

        String type = "add_news";

        loginBackground lbw = new loginBackground(this);
        lbw.execute(type,str_heading,str_description,str_date,str_pincode,str_place);
    }
}

