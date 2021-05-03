package com.pagination.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pagination.Repository.ImageRepository;
import com.pagination.webservice.PageResponse;

import java.util.List;


public class ImageViewModel extends ViewModel {

    private MutableLiveData<List<PageResponse>> mutableLiveData;
    private ImageRepository newsRepository;

    public void init(Context context){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = ImageRepository.getInstance();
        mutableLiveData = newsRepository.getNews(context);

    }

    public LiveData<List<PageResponse>> getNewsRepository() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        return mutableLiveData;
    }





}
