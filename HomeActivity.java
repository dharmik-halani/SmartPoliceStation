package com.example.smartpolicestation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    ListView listView;
    String [] items={"File Complaint","See Status Of Complaint","Pay Fine","Police visit Request","Request for Security","Corruption Complaint","Donate Fund","Complaints Statistics","Officer's Ranking & Performances","Awareness Media"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        listView=(ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item=position;
                if(item==0)
                {
                    Intent intent= new Intent(getBaseContext(),FileComplaint.class);
                    startActivity(intent);


                }
            }
        });

    }
}



