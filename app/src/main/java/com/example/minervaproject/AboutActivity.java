package com.example.minervaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        textView=findViewById(R.id.aboutView);
       
        textView.setText("Minerva is a platform that allows student to share their placement and interview experience with people. " +
                "This app is also a great platform to share  your knowledge about particular skill that you have ." +
                " It has lot of documents  which can help the user to learn and prepare for placement exams and interviews." +
                " Its all about sharing knowledge . ");


    }
}