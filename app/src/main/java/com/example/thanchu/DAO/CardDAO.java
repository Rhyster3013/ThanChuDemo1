package com.example.thanchu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.thanchu.DB.DBHelper;
import com.example.thanchu.Models.Card;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CardDAO {

    FirebaseFirestore db;
    Context context;
    public CardDAO(Context context)
    {
        //kết nối với DB hiện tại
        db = FirebaseFirestore.getInstance();
        this.context = context;
    }
    public void Insert(Card p) {
        // Add a new document with a generated ID
        p.setId(UUID.randomUUID().toString());
        HashMap<String, Object> mapproduct = p.convertHashMap();
        db.collection("Card").document(p.getId())
                .set(mapproduct)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Thêm mới thẻ thành công!",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Thêm mới thẻ thất bại!",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void Delete(String cardId) {
        db.collection("Card").document(cardId)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Xóa thẻ thành công!",
                                Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, " Xóa thẻ thất bại!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
