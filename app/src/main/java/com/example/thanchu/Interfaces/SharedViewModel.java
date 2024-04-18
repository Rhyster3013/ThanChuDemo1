package com.example.thanchu.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thanchu.Models.Card;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Card> cardLiveData = new MutableLiveData<>();
    private MutableLiveData<String> hpLiveData = new MutableLiveData<>();
    private MutableLiveData<Integer> numberLiveData = new MutableLiveData<>();
    private MutableLiveData<String> elementLiveData = new MutableLiveData<>();
    private MutableLiveData<String> typeLiveData = new MutableLiveData<>();
    private MutableLiveData<String> colorLiveData = new MutableLiveData<>();

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

    public void setNumber(Integer number) {
        numberLiveData.setValue(number);
    }

    public LiveData<Integer> getNumber() { return numberLiveData; }

    public void setElement(String element) {
        elementLiveData.setValue(element);
    }

    public LiveData<String> getElement() {
        return elementLiveData;
    }

    public void setType(String type) {
        typeLiveData.setValue(type);
    }

    public LiveData<String> getType() {
        return typeLiveData;
    }

    public void setColor(String color) {
        colorLiveData.setValue(color);
    }

    public LiveData<String> getColor() {
        return colorLiveData;
    }
}
