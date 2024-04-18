package com.example.thanchu.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private MutableLiveData<String> selectedHp = new MutableLiveData<>();

    public void selectHp(String hp) {
        selectedHp.setValue(hp);
    }

    public MutableLiveData<String> getSelectedHp() {
        return selectedHp;
    }
}
