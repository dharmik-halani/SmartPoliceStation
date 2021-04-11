

package com.example.smartpolicestation;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login,create;
    EditText number,password;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login= (Button) findViewById(R.id.login);
        create=(Button)findViewById(R.id.create);
        number=(EditText)findViewById(R.id.number);
        password=(EditText)findViewById(R.id.password);
        myDb=new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check=myDb.check(number.getText().toString(),password.getText().toString());
                if(check==true)
                {

                    Intent intent= new Intent(getBaseContext(),AfterLogin.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid User",Toast.LENGTH_LONG).show();

                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),CreateAccount.class);
                startActivity(intent);

            }
        }
        );


    }

}