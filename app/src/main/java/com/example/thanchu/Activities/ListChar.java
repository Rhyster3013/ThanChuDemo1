package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thanchu.Adapters.CardCharAdapter;
import com.example.thanchu.DAO.CardCharDAO;
import com.example.thanchu.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ListChar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_char);

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
    }
}