package com.pagination.Repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.pagination.webservice.Api;
import com.pagination.webservice.Client;
import com.pagination.webservice.NetworkHelper;
import com.pagination.webservice.PageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageRepository {

    private static ImageRepository newsRepository;

    public static ImageRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new ImageRepository();
        }
        return newsRepository;
    }

    private Api api;

    public ImageRepository(){
        api = Client.createService(Api.class);
    }

    public MutableLiveData<List<PageResponse>> getNews(Context context){

        MutableLiveData<List<PageResponse>> newsData = new MutableLiveData<>();
        if(NetworkHelper.isConnected(context)){
            api.image("1").enqueue(new Callback<List<PageResponse>>() {
                @Override
                public void onResponse(Call<List<PageResponse>> call, Response<List<PageResponse>> response) {
                    if (response.isSuccessful()){
                        newsData.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<PageResponse>> call, Throwable t) {
                    newsData.setValue(null);
                }
            });
            return newsData;
        }else{
            Toast.makeText(context,"Internet is not connected",Toast.LENGTH_SHORT).show();
            return newsData;
        }

    }
}
