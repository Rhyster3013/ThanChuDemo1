package com.example.thanchu.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.thanchu.Models.Card;

public class VmCard {
    private MutableLiveData<Card> cardLiveData = new MutableLiveData<>();
    public void setCard(Card card) {
        cardLiveData.setValue(card);
    }

    public LiveData<Card> getCard() {
        return cardLiveData;
    }
}
