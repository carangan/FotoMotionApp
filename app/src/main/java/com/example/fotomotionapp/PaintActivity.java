package com.example.fotomotionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        TextView view = findViewById(R.id.tempText);

        if(getIntent().hasExtra("com.example.fotomotionapp.buttonText")){
            view.setText(getIntent().getExtras().getString("com.example.fotomotionapp.buttonText"));
        }
    }
}
