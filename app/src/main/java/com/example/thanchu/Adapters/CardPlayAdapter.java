package com.example.thanchu.Adapters;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.thanchu.DAO.CardPlayDAO;
import com.example.thanchu.Models.CardPlay;
import com.example.thanchu.R;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CardPlayAdapter extends RecyclerView.Adapter<CardPlayAdapter.ViewHolder> {
    private List<CardPlay> listPlay;
    private CardPlayDAO cardPlayDAO;

    public CardPlayAdapter() {
    }

    public CardPlayAdapter(List<CardPlay> listPlay, CardPlayDAO cardPlayDAO) {
        this.listPlay = listPlay;
        this.cardPlayDAO = cardPlayDAO;
    }

    @NonNull
    @Override
    public CardPlayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCard = LayoutInflater.from( parent.getContext()).inflate(R.layout.item_play, parent, false);
        return new ViewHolder(viewCard);
    }

    @Override
    public void onBindViewHolder(@NonNull CardPlayAdapter.ViewHolder holder, int position) {
        CardPlay p = listPlay.get(position);
        String element = p.getElement();
        String type = p.getType();

        holder.txtNamePlay.setText(p.getName());
        holder.txtElement.setText(p.getNumber());
        holder.txtArtistPlay.setText(p.getArtist());
        if(p.getImage().startsWith("https://"))
        {
            Glide.with(holder.imgPlay.getContext()).load(p.getImage()).into(holder.imgPlay);
        }

        switch (type){
            case "Kế sách":
                holder.txtNamePlay.setBackgroundColor(Color.BLUE);
                break;
            case "Cơ bản":
                holder.txtNamePlay.setBackgroundColor(Color.rgb(144, 238, 144));
                break;
            case "Trang bị":
                holder.txtNamePlay.setBackgroundColor(Color.rgb(0, 100, 0));
                break;
        }

        switch (element){
            case "Lửa":
                holder.txtElement.setBackgroundColor(Color.RED);
                holder.txtElement.setTextColor(Color.BLACK);
                break;
            case "Nước":
                holder.txtElement.setBackgroundColor(Color.BLUE);
                holder.txtElement.setTextColor(Color.WHITE);
                break;
            case "Gió":
                holder.txtElement.setBackgroundColor(Color.GRAY);
                holder.txtElement.setTextColor(Color.BLACK);
                break;
            case "Đất":
                holder.txtElement.setBackgroundColor(Color.rgb(165, 42, 42));
                holder.txtElement.setTextColor(Color.WHITE);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listPlay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlay;
        TextView txtNamePlay, txtElement, txtArtistPlay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlay = (ImageView) itemView.findViewById(R.id.imgPlay);
            txtNamePlay = (TextView)   itemView.findViewById(R.id.txtNamePlay);
            txtArtistPlay = (TextView)   itemView.findViewById(R.id.txtArtistPlay);
            txtElement = (TextView)   itemView.findViewById(R.id.txtElement);
        }
    }

    public void deleteItem(int pos){
        cardPlayDAO.Delete(String.valueOf(pos));
    }
    public void insertItem(CardPlay p){
        cardPlayDAO.Insert(p);
    }

    public void listenCardFirestore(FirebaseFirestore db){
        db.collection("CardPlay").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot snapshots, @Nullable
            FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w("FireBase", "listen:error", e);
                    return;
                }
                for (DocumentChange dc : snapshots.getDocumentChanges()) {
                    CardPlay card = dc.getDocument().toObject(CardPlay.class);

                    switch (dc.getType()) {
                        case ADDED:
                            listPlay.add(card);
                            notifyItemInserted(listPlay.size() - 1);
                            break;
                        case MODIFIED:
                            if (dc.getOldIndex() == dc.getNewIndex()) //nếu vị trí đối tượng tương đồng với vị trí mới
                            {
                                listPlay.set(dc.getOldIndex(), card);
                                notifyItemChanged(dc.getOldIndex());
                            } else //khác vị trí sẽ xóa đối tượng ở danh sách và thêm lại
                            {
                                listPlay.remove(dc.getOldIndex());
                                listPlay.add(dc.getNewIndex(), card);
                                notifyItemMoved(dc.getOldIndex(),
                                        dc.getNewIndex());
                            }
                            break;
                        case REMOVED:
                            listPlay.remove(dc.getOldIndex());
                            notifyItemRemoved(dc.getOldIndex());
                            break;
                    }
                }
            }
        });
    }
}
