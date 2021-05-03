package com.pagination.samplepagination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pagination.R;
import com.pagination.webservice.Api;
import com.pagination.webservice.Cl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

public class SAmpleActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    PaginationAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    RecyclerView recyclerView;
    ProgressBar progressBar;
    NestedScrollView nested;

    int page = 0, limit = 2;
    Retrofit mClient1;
    Api mApi;
    private ArrayList<AdminCompletedJobData.CompletedJobs> jobs;
    LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_ample);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        nested =  findViewById(R.id.nested);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);
        getJobs();
        nested.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // on scroll change we are checking when users scroll as bottom.
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    // in this method we are incrementing page number,
                    // making progress bar visible and calling get data method.
                    page++;
                    progressBar.setVisibility(View.VISIBLE);
                    getJobs();
                }
            }
        });
    }

    private void getJobs() {

        if (page > limit) {
            // checking if the page number is greater than limit.
            // displaying toast message in this case when page>limit.
            Toast.makeText(this, "That's all the data..", Toast.LENGTH_SHORT).show();

            // hiding our progress bar.
            progressBar.setVisibility(View.GONE);
            return;
        }

        mClient1= Cl.getClient();
        mApi=mClient1.create( Api.class );
        mApi.getCompletedJobs("GetAllCompletedJobs").enqueue(new Callback<AdminCompletedJobData>() {
                @Override
                public void onResponse(Call<AdminCompletedJobData> call, Response<AdminCompletedJobData> response) {
                    try {
                        if (response != null) {
                            AdminCompletedJobData jobList = response.body();
                           // int i=jobList.CompletedJobs.size();
                            jobs = new ArrayList<>();
                            /*if (jobList.CompletedJobs != null){

                                jobs.addAll(jobList.CompletedJobs);
                                show();
                            }*/
                           /* for (int i = 0; i < jobList.CompletedJobs.size(); i++) {

                                jobs.add(new AdminCompletedJobData.CompletedJobs(jobList.CompletedJobs.get(i).Jobdetail));
                                show();

                            }*/

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<AdminCompletedJobData> call, Throwable t) {

                }
            });

    }

    private void show() {
         manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        //recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setHasFixedSize(true);
        adapter = new PaginationAdapter(getApplicationContext(), jobs);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);
    }

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = manager.getChildCount();
            int totalItemCount = manager.getItemCount();
            int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();

           /* if (!isLoading && !isLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) {
                    loadMoreItems();
                }
            }*/
        }
    };

}