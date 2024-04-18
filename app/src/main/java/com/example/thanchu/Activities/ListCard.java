package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thanchu.Adapters.CardAdapter;
import com.example.thanchu.Adapters.CardCharAdapter;
import com.example.thanchu.Adapters.CardPlayAdapter;
import com.example.thanchu.DAO.CardCharDAO;
import com.example.thanchu.DAO.CardDAO;
import com.example.thanchu.DAO.CardPlayDAO;
import com.example.thanchu.Models.Card;
import com.example.thanchu.Models.CardCharacter;
import com.example.thanchu.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ListCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_card);

        // Nhận loại thẻ từ Intent
        String cardType = getIntent().getStringExtra("card_type");

        if ("character".equals(cardType)) {
            CardCharDAO cardCharDAO = new CardCharDAO(this);
            CardCharAdapter adapter = new CardCharAdapter(new ArrayList<>(), cardCharDAO);
            if (adapter != null) {
                adapter.listenCardFirestore(FirebaseFirestore.getInstance());

                RecyclerView rcvListCard = findViewById(R.id.rcvListCard);
                rcvListCard.setAdapter(adapter);
                rcvListCard.setLayoutManager(new LinearLayoutManager(this));

                RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
                rcvListCard.addItemDecoration(itemDecoration);
            }
        } else if ("playing".equals(cardType)) {
            CardPlayDAO cardPlayDAO = new CardPlayDAO(this);
            CardPlayAdapter adapter = new CardPlayAdapter(new ArrayList<>(), cardPlayDAO);
            if (adapter != null) {
                adapter.listenCardFirestore(FirebaseFirestore.getInstance());

                RecyclerView rcvListCard = findViewById(R.id.rcvListCard);
                rcvListCard.setAdapter(adapter);
                rcvListCard.setLayoutManager(new LinearLayoutManager(this));

                RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
                rcvListCard.addItemDecoration(itemDecoration);
            }
        }

    }

}