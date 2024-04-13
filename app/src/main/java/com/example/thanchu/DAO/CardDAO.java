package com.example.thanchu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thanchu.DB.DBHelper;
import com.example.thanchu.Models.Card;

import java.util.ArrayList;
import java.util.List;

public class CardDAO {
    DBHelper dbHelper;
    public CardDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public List<Card> GetAll()
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        List<Card> listCard = new ArrayList<>();
        String query = "SELECT * FROM card";
        Cursor c = db.rawQuery(query, null);

        while (c.moveToNext())
        {
            Card temp = new Card();
            temp.setId(c.getInt(0));
            temp.setName(c.getString(1));
            temp.setImage(c.getString(2));
            temp.setArtist(c.getString(3));
            temp.setDescription(c.getString(4));
            listCard.add(temp);
        }
        return listCard;
    }
    public void Insert(Card p) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //c1: sử dụng contentValues
        ContentValues values = new ContentValues();

        // values.put("id", p.getId());
        values.put("name", p.getName());
        values.put("image", p.getImage());
        values.put("artist", p.getArtist());
        values.put("description", p.getDescription());
        db.insert("card", null, values);
//c2: sử dụng câu query thuần
    }
    public void Delete(int productId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
//c1: sử dụng delete
        db.delete("card", "id=?", new String[] { String.valueOf(productId) });
    }
}
