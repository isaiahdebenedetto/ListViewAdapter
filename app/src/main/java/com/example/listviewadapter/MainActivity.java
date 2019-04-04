package com.example.listviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    EditText et_addName;
    ListView lv_listOfNames;

    List<String> friends = new ArrayList<String>();

    String [] startingList = {"Elijah", "Jacob", "Sam", "Hartmann"};

    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        et_addName = findViewById(R.id.et_addName);
        lv_listOfNames = findViewById(R.id.lv_listOfNames);

        friends = new ArrayList<>(Arrays.asList(startingList));

        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , friends);

        lv_listOfNames.setAdapter(ad);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = et_addName.getText().toString();
                friends.add(newName);
                Collections.sort(friends);



                ad.notifyDataSetChanged();
            }
        });

        lv_listOfNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "pos=" + position + " name=" + friends.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
