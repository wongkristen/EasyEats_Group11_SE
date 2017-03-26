package com.example.brett.bartender_application;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    Button btnAdd;
    DBHandler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        myDB = new DBHandler(this);
        btnAdd = (Button) findViewById(R.id.button2);



        Intent intent = getIntent();

        final ListView listview = (ListView) findViewById(R.id.listView1);
        updateList(listview);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String entry1 = "Miller Lite";
                String entry2 = "Coca Cola";
                String entry3 = "Dr. Pepper Cherry";
                String entry4 = "Gin and Tonic";
                AddData(entry1);
                AddData(entry2);
                AddData(entry3);
                AddData(entry4);
                updateList(listview);
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {

                final String name = parent.getItemAtPosition(position).toString();
                Cursor data = myDB.getItemID(name);
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                    if (itemID > 0){
                        break;
                    }
                }
                final int ID = itemID;
                AlertDialog.Builder adb = new AlertDialog.Builder(OrderActivity.this);
                adb.setTitle("Complete?");
                adb.setMessage("Click to confirm order ready: " + name);
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        myDB.deleteName(ID, name);
                        updateList(listview);
                    }
                });
                adb.show();
            }
        });

    }// end on create

    public void AddData(String newEntry) {
        boolean insertData = myDB.addData(newEntry);

    }
    public void updateList(ListView listview){
        final ArrayList<String> theList = new ArrayList<>();
        final Cursor data = myDB.getListContents();
        while(data.moveToNext()){
            theList.add(data.getString(1));
            ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
            listview.setAdapter(listAdapter);
        }
    }
    public void ingredient(View view){
        Intent intent = new Intent(this, ListItemDetail.class);
        startActivity(intent);
    }
    public void problem(View view) {
        Intent intent = new Intent(this, Problem.class);
        startActivity(intent);
    }
}
