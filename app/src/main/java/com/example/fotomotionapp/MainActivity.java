package com.example.fotomotionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String directory = "/FOTOMOTION_APP";
    TableLayout myLayout;
    int counter;

    //Big Boy make me happy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = findViewById(R.id.layout);

        final Button switchScreenButton = findViewById(R.id.switchScreenButton);
        switchScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchScreenIntent = new Intent(getApplicationContext(), PaintActivity.class);
                switchScreenIntent.putExtra("com.example.fotomotionapp.buttonText", switchScreenButton.getText().toString());
                startActivity(switchScreenIntent);
            }
        });

        Button addPanelsButton = findViewById(R.id.addPanelsButton);
        addPanelsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Button additionalButton = new Button(MainActivity.this);
                additionalButton.setText("Project: " + counter++);

                additionalButton.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT

                ));

                myLayout.addView(additionalButton);
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

    private void makeDirectory(){
        File myDir = new File(Environment.getExternalStorageDirectory() + directory);
        if(!myDir.exists()){
            myDir.mkdir();
            Toast.makeText(MainActivity.this, "Directory has been made", Toast.LENGTH_SHORT).show();
        }
    }
}