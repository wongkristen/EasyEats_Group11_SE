package com.example.brett.chefapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


/**
 * Created by Brett on 3/24/2017.
 */


public class ListItemDetail extends AppCompatActivity {
    DBHandler myDB1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listitem);

        myDB1 = new DBHandler(this);
        Intent intent = getIntent();

        final ListView listview = (ListView) findViewById(R.id.listView2);

        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {


                final String name = parent.getItemAtPosition(position).toString();
                if(name.equals("Apples")){
                    delete("Apple pie", "Apples");
                }
                else if(name.equals("Bacon")){
                    delete("Bacon and Eggs", "Bacon");
                }
                else if(name.equals("Cheese")){
                    delete("Chicken Parmesan", "Cheese");
                }
                else if(name.equals("Chicken")){
                    delete("Chicken Parmesan", "Chicken");
                }
                else if(name.equals("Eggs")){
                    delete("Bacon and Eggs", "Eggs");
                }
                else if(name.equals("Potatoes")){
                    delete("A few potatoes", "Potatoes");
                }
                else if(name.equals("Tomato Sauce")){
                    delete("Chicken Parmesan", "Tomato Sauce");
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
