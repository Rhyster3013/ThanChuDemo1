package com.example.thanchu.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.thanchu.DAO.CardCharDAO;
import com.example.thanchu.DAO.CardDAO;
import com.example.thanchu.Models.Card;
import com.example.thanchu.Models.CardCharacter;
import com.example.thanchu.R;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CardCharAdapter extends RecyclerView.Adapter<CardCharAdapter.ViewHolder>{
    private List<CardCharacter> listChar;
    private CardCharDAO cardCharDAO;

    public CardCharAdapter(List<CardCharacter> listChar, CardCharDAO cardCharDAO) {
        this.listChar = listChar;
        this.cardCharDAO = cardCharDAO;
    }

    public CardCharAdapter() {
    }

    @NonNull
    @Override
    public CardCharAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCard = LayoutInflater.from( parent.getContext()).inflate(R.layout.item_char, parent, false);
        return new ViewHolder(viewCard);
    }

    @Override
    public void onBindViewHolder(@NonNull CardCharAdapter.ViewHolder holder, int position) {
        CardCharacter p = listChar.get(position);
        holder.txtNameChar.setText(p.getName());
        holder.txtHp.setText(p.getHp());
        holder.txtArtistChar.setText(p.getArtist());
        if(p.getImage().startsWith("https://"))
        {
            Glide.with(holder.imgChar.getContext()).load(p.getImage()).into(holder.imgChar);
        }
    }

    @Override
    public int getItemCount() {
        return listChar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgChar;
        TextView txtNameChar, txtHp, txtArtistChar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChar = (ImageView) itemView.findViewById(R.id.imgChar);
            txtNameChar = (TextView)   itemView.findViewById(R.id.txtNameChar);
            txtHp = (TextView)   itemView.findViewById(R.id.txtHp);
            txtArtistChar = (TextView)   itemView.findViewById(R.id.txtArtistChar);
        }
    }


    public void deleteItem(int pos){
        cardCharDAO.Delete(String.valueOf(pos));
    }
    public void insertItem(CardCharacter p){
        cardCharDAO.Insert(p);
    }

    public void listenCardFirestore(FirebaseFirestore db){
        db.collection("CardCharacter").addSnapshotListener(new EventListener<QuerySnapshot>() {
          @Override
          public void onEvent(@Nullable QuerySnapshot snapshots, @Nullable
          FirebaseFirestoreException e) {
              if (e != null) {
                  Log.w("FireBase", "listen:error", e);
                  return;
              }
              for (DocumentChange dc : snapshots.getDocumentChanges()) {
                  CardCharacter card = dc.getDocument().toObject(CardCharacter.class);

                  switch (dc.getType()) {
                      case ADDED:
                          listChar.add(card);
                          notifyItemInserted(listChar.size() - 1);
                          break;
                      case MODIFIED:
                          if (dc.getOldIndex() == dc.getNewIndex()) //nếu vị trí đối tượng tương đồng với vị trí mới
                          {
                              listChar.set(dc.getOldIndex(), card);
                              notifyItemChanged(dc.getOldIndex());
                          } else //khác vị trí sẽ xóa đối tượng ở danh sách và thêm lại
                          {
                              listChar.remove(dc.getOldIndex());
                              listChar.add(dc.getNewIndex(), card);
                              notifyItemMoved(dc.getOldIndex(),
                                      dc.getNewIndex());
                          }
                          break;
                      case REMOVED:
                          listChar.remove(dc.getOldIndex());
                          notifyItemRemoved(dc.getOldIndex());
                          break;
                  }
              }
          }
      });
    }
}
