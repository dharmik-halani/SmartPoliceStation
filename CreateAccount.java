package com.example.smartpolicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity
{
    Button newCreate;
    EditText newNumber,newPassword,conPassword;
    DatabaseHelper myDb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount_activity);

        newNumber=(EditText)findViewById(R.id.newnumber);
        newPassword=(EditText)findViewById(R.id.newpassword);
        conPassword=(EditText)findViewById(R.id.conpassword);
        newCreate=(Button)findViewById(R.id.newcreate);
        myDb1=new DatabaseHelper(this);

        newCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String password=newPassword.getText().toString();
                String conpassword=conPassword.getText().toString();
                String number=newNumber.getText().toString();

                if(password.equals(conpassword))
                {
                    boolean isCreated=myDb1.createUser(number,password);
                    if(isCreated==true)
                    {
                        Toast.makeText(CreateAccount.this,"Accouunt Created",Toast.LENGTH_LONG).show();

                        Intent intent= new Intent(getBaseContext(),MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(CreateAccount.this,"Account Not Created",Toast.LENGTH_LONG).show();
                    }
                }
                 else
                {
                   Toast.makeText(CreateAccount.this, "Password Not Matched!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}