package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thanchu.R;

public class MainAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        Button btnCreate = findViewById(R.id.btnAddCard);
        Button btnCardPlay = findViewById(R.id.btnCardPlay);

        Intent create = new Intent(MainAdmin.this, createCard.class);
        Intent listPlay = new Intent(MainAdmin.this, ListCard.class);

        btnCardPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(listPlay);
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(create);
            }
        });
    }
}