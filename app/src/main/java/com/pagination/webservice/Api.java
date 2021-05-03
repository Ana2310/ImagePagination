package com.pagination.webservice;

import com.pagination.samplepagination.AdminCompletedJobData;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("list")
    Call<List<PageResponse>> image(@Query("page") String methodName);
    @GET("Services.aspx")
    Call<AdminCompletedJobData> getCompletedJobs(@Query("MethodName") String methodName);
}
