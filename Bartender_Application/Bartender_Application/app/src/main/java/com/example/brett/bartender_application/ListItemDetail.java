package com.example.brett.bartender_application;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListItemDetail extends AppCompatActivity {
    DBHandler myDB1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listitem);

        myDB1 = new DBHandler(this);
        Intent intent = getIntent();

        final ListView listview = (ListView) findViewById(R.id.listView2);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {


                final String name = parent.getItemAtPosition(position).toString();
                if(name.equals("Coca Cola")){
                    delete("Coca Cola", "Coca Cola");
                }
                else if(name.equals("Dr. Pepper Cherry")){
                    delete("Dr. Pepper Cherry", "Dr. Pepper Cherry");
                }
                else if(name.equals("Gin")){
                    delete("Gin and Tonic", "Gin");
                }
                else if(name.equals("Miller Lite")){
                    delete("Miller Lite", "Miller Lite");
                }
                else if(name.equals("Tonic Water")){
                    delete("Gin and Tonic", "Tonic Water");
                }

            }
        });


    }// on create


    public void delete(String name, String call){
        final String set = name;
        AlertDialog.Builder adb = new AlertDialog.Builder(ListItemDetail.this);
        adb.setTitle("Hide this item?" + call);
        adb.setMessage("Click to confirm");
        //final int positionToRemove = position;
        adb.setNegativeButton("Cancel", null);
        adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                delete_db(set);
            }
        });
        adb.show();
    }
    public void delete_db(String name){
        Cursor data = myDB1.getItemID(name);
        int itemID = -1;
        while(data.moveToNext()){
            itemID = data.getInt(0);
            if(itemID > 0){
                myDB1.deleteName(itemID, name);
            }
        }
        final int ID = itemID;
    }
}
