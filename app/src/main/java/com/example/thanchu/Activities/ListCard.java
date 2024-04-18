package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thanchu.Adapters.CardAdapter;
import com.example.thanchu.DAO.CardDAO;
import com.example.thanchu.Models.Card;
import com.example.thanchu.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ListCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_card);

        CardDAO cardDAO =new CardDAO(ListCard.this);
        CardAdapter adapter =new CardAdapter(new ArrayList<>(), cardDAO);

        adapter.listenCardFirestore(FirebaseFirestore.getInstance());

        RecyclerView rcvListCard = findViewById(R.id.rcvListCard);
        rcvListCard.setAdapter(adapter);
        rcvListCard.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvListCard.addItemDecoration(itemDecoration);
    }

}