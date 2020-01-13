package com.example.fotomotionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Big Boy make me happy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button switchScreenButton = (Button) findViewById(R.id.switchScreenButton);
        switchScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchScreenIntent = new Intent(getApplicationContext(), PaintActivity.class);
                startActivity(switchScreenIntent);
            }
        });

        // get the button by finding the elements with the id of "straightButton"
        Button straightButton = findViewById(R.id.fileButton);

        // set the action to be performed on click to an iClicker
        straightButton.setOnClickListener(new iClicker());


    }

    private class iClicker implements View.OnClickListener {

        @Override
        public void onClick(View v) {


            // notifies user about what the button really does
            Toast.makeText(MainActivity.this,"you still non-hetero lmao", Toast.LENGTH_SHORT).show();
        }
    }
}
