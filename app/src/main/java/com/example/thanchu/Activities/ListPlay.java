package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thanchu.Adapters.CardPlayAdapter;
import com.example.thanchu.DAO.CardPlayDAO;
import com.example.thanchu.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ListPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_play);

        CardPlayDAO cardPlayDAO = new CardPlayDAO(this);
        CardPlayAdapter adapter = new CardPlayAdapter(new ArrayList<>(), cardPlayDAO);

        adapter.listenCardFirestore(FirebaseFirestore.getInstance());

        RecyclerView rcvListPlay = findViewById(R.id.rcvListPlay);
        rcvListPlay.setAdapter(adapter);
        rcvListPlay.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvListPlay.addItemDecoration(itemDecoration);
    }
}