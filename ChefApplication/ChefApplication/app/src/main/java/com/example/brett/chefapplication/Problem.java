package com.example.brett.chefapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Problem extends AppCompatActivity {

    Button btnNotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);

        Intent intent = getIntent();

        btnNotify = (Button) findViewById(R.id.button5);

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(Problem.this);
                adb.setTitle("Message Sent");
                //adb.setMessage("Click to confirm order ready: ");
                //adb.setNegativeButton("", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Problem.this, DisplayMessageActivity.class);
                        startActivity(intent);
                    }
                });
                adb.show();
            }
        });
    }
}
