package com.example.smartpolicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfterLogin extends AppCompatActivity {

    Button homeActivity, contactusActivity, feedbackActivity,ourvisionActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin_activity);

        homeActivity = (Button) findViewById(R.id.home_activity);
        feedbackActivity = (Button) findViewById(R.id.feedback_activity);
        contactusActivity = (Button) findViewById(R.id.contactus_activity);
        ourvisionActivity = (Button) findViewById(R.id.ourvision_activity);


        homeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        contactusActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),ContactusActivity.class);
                startActivity(intent);
            }
        });

        feedbackActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),FeedbackActivity.class);
                startActivity(intent);
            }
        });

        ourvisionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),OurvisionActivity.class);
                startActivity(intent);
            }
        });
    }
}