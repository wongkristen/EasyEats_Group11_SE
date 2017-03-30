package com.example.brett.bartender_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Move to main working page
    public void sendMessage(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}