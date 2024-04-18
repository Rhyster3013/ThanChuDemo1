package com.example.thanchu.Interfaces;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private MutableLiveData<String> myLiveData = new
            MutableLiveData<>();
    public LiveData<String> getMyLiveData() {
        return myLiveData;
    }
    public void updateData(String newData) {
        myLiveData.setValue(newData);
    }
}
