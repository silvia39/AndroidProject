package com.example.asus.myapplication4;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity {

    private Button next2Button;
    private TextView timeTextView;
    private Button timeButton;
    private TimePicker timePicker;
    private Button exitButton;
    private AlertDialog.Builder alertdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timeButton = (Button) findViewById(R.id.TimeButton);
        exitButton = (Button) findViewById(R.id.exitButton);
        timeTextView = (TextView) findViewById(R.id.TimeTextView);
        timePicker = (TimePicker) findViewById(R.id.TimePicker);
        timePicker.setIs24HourView(true);

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = "Time : " + timePicker.getCurrentHour() + " : " + timePicker.getCurrentMinute();
                timeTextView.setText(time);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertdialog = new AlertDialog.Builder(MainActivity.this);

                alertdialog.setTitle("EXIT");

                alertdialog.setMessage("Do you want to exit?");

                alertdialog.setIcon(R.drawable.ic_launcher_foreground);

                alertdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();


                    }
                });

                alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"You have clicked NO button",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                alertdialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"You have clicked CANCEL button",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = alertdialog.create();
                alertDialog.show();
            }
        });

    }

}