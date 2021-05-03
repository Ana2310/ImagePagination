package com.pagination.samplepagination;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pagination.R;

import java.util.ArrayList;
import java.util.List;

public class PaginationAdapter extends RecyclerView.Adapter<PaginationAdapter.ViewHolder>  {
    private List<AdminCompletedJobData.CompletedJobs> android;
    Context context;



    public PaginationAdapter( Context context, List<AdminCompletedJobData.CompletedJobs>android) {
        this.android = android;
        this.context=context;

    }


    @Override
    public PaginationAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.view_holder_job_admin_complist, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PaginationAdapter.ViewHolder holder, int i) {

        holder.lblType.setText( android.get(i).Jobdetail);

    }

    @Override
    public int getItemCount() {
        return android.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView lblType;

        public ViewHolder(View view) {
            super(view);

            lblType = view.findViewById(R.id.lblType);




        }
    }
}
