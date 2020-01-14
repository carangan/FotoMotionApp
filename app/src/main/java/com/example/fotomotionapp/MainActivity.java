package com.example.fotomotionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
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

    TableLayout myLayout;
    TableRow currentRow;
    int counter;

    //Big Boy make me happy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    private void makeDirectory(){
        String pathName = getExternalFilesDir(null).getPath() + getString(R.string.DirectoryName);
        File myDir = new File(pathName);

        Log.e("HelloGay", pathName);
        if(!myDir.exists()){
            if(myDir.mkdir()) {
                Toast.makeText(MainActivity.this, "Directory has been made", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Directory FAILED", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(MainActivity.this, "Directory already exists", Toast.LENGTH_SHORT).show();
        }
        Log.e("HelloGay:", myDir.toString());
    }


    //Helper method to help find directories on files
    //Also give me the kids Karen I need tHTMEMMEMMMMMM, i'm sorry i just get mad sometimes, plz call back
    private void viewInnerFiles(File directory) {
        Log.e("jay says", directory.getPath());
        if(directory != null && directory.isDirectory()) {
            for(File innerFile: directory.listFiles()) {
                // Log.e("jay says", innerFile.getPath());
                viewInnerFiles(innerFile);
            }
        } else {
            // Log.e("jay says", "not a directory");
        }
    }
}