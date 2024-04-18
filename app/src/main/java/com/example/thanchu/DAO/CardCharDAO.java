package com.example.thanchu.DAO;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.thanchu.Models.Card;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.UUID;

public class CardCharDAO {
    FirebaseFirestore db;
    Context context;

    public CardCharDAO(Context context){
        //kết nối với DB hiện tại
        db = FirebaseFirestore.getInstance();
        this.context = context;
    }

    public void Insert(Card p) {
        // Add a new document with a generated ID
        p.setId(UUID.randomUUID().toString());
        HashMap<String, Object> mapcard = p.convertHashMap();
        db.collection("CardCharacter").document(p.getId())
                .set(mapcard)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Thêm mới nhân vật thành công!",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Thêm mới nhân vật thất bại!",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void Delete(String cardId) {
        db.collection("CardCharacter").document(cardId)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Xóa nhân vật thành công!",
                                Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, " Xóa nhân vật thất bại!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
