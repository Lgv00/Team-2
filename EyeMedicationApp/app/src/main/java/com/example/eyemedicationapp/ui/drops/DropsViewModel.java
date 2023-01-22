package com.example.eyemedicationapp.ui.drops;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DropsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DropsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("My Drops");
    }

    public LiveData<String> getText() {
        return mText;
    }
}