package com.example.thanchu.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
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

        adapter.listenCardFirestore(FirebaseFirestore.getInstance());
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        RecyclerView rcvListChar = findViewById(R.id.rcvListChar);
        rcvListChar.setAdapter(adapter);
        rcvListChar.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvListChar.addItemDecoration(itemDecoration);
    }
}