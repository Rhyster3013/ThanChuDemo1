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
import com.example.thanchu.DAO.CardDAO;
import com.example.thanchu.Models.Card;
import com.example.thanchu.R;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private List<Card> listCard;
    private CardDAO cardDAO;


    public CardAdapter(List<Card> listCard, CardDAO cardDAO) {
        this.listCard = listCard;
        this.cardDAO = cardDAO;
    }

    public CardAdapter() {
    }


    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCard = LayoutInflater.from( parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(viewCard);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Card p = listCard.get(position);
        holder.txtName.setText(p.getName());
        holder.txtDescription.setText(p.getDescription());
        holder.txtArtist.setText(p.getArtist());
        if(p.getImage().startsWith("https://"))
        {
            Glide.with(holder.imgView.getContext()).load(p.getImage()).into(holder.imgView);
        }
    }

    @Override
    public int getItemCount() {
        return listCard.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtName, txtDescription, txtArtist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgProduct);
            txtName = (TextView)   itemView.findViewById(R.id.txtName);
            txtArtist = (TextView)   itemView.findViewById(R.id.txtArtist);
            txtDescription = (TextView)   itemView.findViewById(R.id.txtDescription);
        }
    }


    public void deleteItem(int pos){
        cardDAO.Delete(String.valueOf(pos));
    }
    public void insertItem(Card p){
        cardDAO.Insert(p);
    }

    public void listenCardFirestore(FirebaseFirestore db){
        db.collection("Card").addSnapshotListener(new
         EventListener<QuerySnapshot>() {
             @Override
             public void onEvent(@Nullable QuerySnapshot snapshots, @Nullable
             FirebaseFirestoreException e) {
                 if (e != null) {
                     Log.w("FireBase", "listen:error", e);
                     return;
                 }
                 for (DocumentChange dc : snapshots.getDocumentChanges()) {
                     Card card = dc.getDocument().toObject(Card.class);

                     switch (dc.getType()) {
                         case ADDED:
                             listCard.add(card);
                             notifyItemInserted(listCard.size() - 1);
                             break;
                         case MODIFIED:
                             if (dc.getOldIndex() == dc.getNewIndex()) //nếu vị trí đối tượng tương đồng với vị trí mới
                             {
                                 listCard.set(dc.getOldIndex(), card);
                                 notifyItemChanged(dc.getOldIndex());
                             } else //khác vị trí sẽ xóa đối tượng ở danh sách và thêm lại
                             {
                                 listCard.remove(dc.getOldIndex());
                                 listCard.add(dc.getNewIndex(), card);
                                 notifyItemMoved(dc.getOldIndex(),
                                         dc.getNewIndex());
                             }
                             break;
                         case REMOVED:
                             listCard.remove(dc.getOldIndex());
                             notifyItemRemoved(dc.getOldIndex());
                             break;
                     }
                 }
             }
         });
    }
}
