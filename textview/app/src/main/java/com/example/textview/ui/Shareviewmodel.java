package com.example.textview.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Shareviewmodel extends ViewModel {
    private final MutableLiveData<String> listdata = new MutableLiveData<>();
    public void setListdata(String data){
        listdata.setValue(data);
    }
    public MutableLiveData<String> getListdata(){
        return listdata;
    }

}
