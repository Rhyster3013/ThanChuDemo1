package com.example.thanchu.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thanchu.Models.Card;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Card> cardLiveData = new MutableLiveData<>();
    private MutableLiveData<String> hpLiveData = new MutableLiveData<>();

    public void setCard(Card card) {
        cardLiveData.setValue(card);
    }

    public LiveData<Card> getCard() {
        return cardLiveData;
    }

    public void setHp(String hp) {
        hpLiveData.setValue(hp);
    }

    public LiveData<String> getHp() {
        return hpLiveData;
    }
}
