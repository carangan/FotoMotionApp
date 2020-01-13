package com.example.fotomotionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private int PERMISSION_ACCESS = 1;
    TableLayout myLayout;
    TableRow currentRow;
    int counter;

    //Big Boy make me happy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askPermission();

        makeDirectory();

        final Button switchScreenButton = findViewById(R.id.switchScreenButton);
        switchScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchScreenIntent = new Intent(getApplicationContext(), PaintActivity.class);
                switchScreenIntent.putExtra("com.example.fotomotionapp.buttonText", switchScreenButton.getText().toString());
                startActivity(switchScreenIntent);
            }
        });

        myLayout = findViewById(R.id.layout);

        Button addPanelsButton = findViewById(R.id.addPanelsButton);
        addPanelsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button additionalButton = new Button(MainActivity.this);

                if(counter % 3 == 0) {
                    currentRow = new TableRow(MainActivity.this);
                    currentRow.setLayoutParams(new TableRow.LayoutParams(
                            TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.MATCH_PARENT

                    ));
                    myLayout.addView(currentRow);
                }

                additionalButton.setText("Project: " + ++counter);

                currentRow.addView(additionalButton);

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
            Toast.makeText(MainActivity.this, "you still non-hetero lmao", Toast.LENGTH_SHORT).show();
        }
    }

    //helper method that helps make the directory that will hold all the projects that the person has
    private void makeDirectory(){
        File myDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ getString(R.string.DirectoryName));
        if(!myDir.exists()){
            myDir.mkdir();
            Toast.makeText(MainActivity.this, "Directory has been made", Toast.LENGTH_SHORT).show();
            Log.e("PrayTheGayAway", "newagain");
        } else{
            Toast.makeText(MainActivity.this, "Directory already exists", Toast.LENGTH_SHORT).show();
        }
        Log.e("HelloGay:", myDir.toString());
    }

    //Helper method that checks to see if the person if person has accepted permissions, if not then it proceeds to ask them
    private void askPermission(){
        //Checks if the user has already accepted the permission
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(MainActivity.this, "Thank you for accepting the permission dummy", Toast.LENGTH_SHORT).show();
        } else{
            //If they haven't accepted the program then it asks the person to accept it
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_ACCESS);
        }
    }




}