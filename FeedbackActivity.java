package com.example.smartpolicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity
{
    EditText editText;
    RatingBar rate;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_activity);

        rate=(RatingBar)findViewById(R.id.rate);
        submit=(Button)findViewById(R.id.submit);
        editText=(EditText)findViewById(R.id.edittext);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                float rateValue=rate.getRating();

                    Toast.makeText(FeedbackActivity.this,"Registered :"+rateValue+" Rating",Toast.LENGTH_LONG).show();
                    editText.getText().clear();
            }
        });

    }
}