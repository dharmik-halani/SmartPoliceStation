package com.example.smartpolicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileComplaint extends AppCompatActivity
{
    EditText name,aadhar,email,complaint,comNumber;
    Button comSubmit;
    DatabaseHelper myDb2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filecomplaint_activity);

        name=(EditText)findViewById(R.id.name);
        aadhar=(EditText)findViewById(R.id.aadhar);
        email=(EditText)findViewById(R.id.email);
        complaint=(EditText)findViewById(R.id.complaint);
        comNumber=(EditText) findViewById(R.id.comnumber);
        comSubmit=(Button)findViewById(R.id.comsubmit);
        myDb2=new DatabaseHelper(this);

        comSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean isRegister=myDb2.register(comNumber.getText().toString(),name.getText().toString(),aadhar.getText().toString(),email.getText().toString(),complaint.getText().toString());
                if(isRegister==true)
                {
                    Toast.makeText(FileComplaint.this,"Complaint Registered",Toast.LENGTH_LONG).show();
                    name.getText().clear();
                    aadhar.getText().clear();
                    email.getText().clear();
                    complaint.getText().clear();
                    comNumber.getText().clear();

                }


            }
        });
    }
}