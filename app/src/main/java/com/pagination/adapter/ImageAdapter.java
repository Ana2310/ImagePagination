package com.pagination.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pagination.R;
import com.pagination.databinding.ImageViewLayoutBinding;
import com.pagination.webservice.PageResponse;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{

    private List<PageResponse> android;
    Context context;
    View.OnClickListener listener;


    public ImageAdapter( Context context, List<PageResponse>android) {
        this.android = android;
        this.context=context;
        //this.listener = listener;
    }



    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        ImageViewLayoutBinding imageViewLayoutBinding=ImageViewLayoutBinding.inflate(layoutInflater,viewGroup,false);
        return new ViewHolder(imageViewLayoutBinding);
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder holder, int i) {
        holder.imageViewLayoutBinding.setViewmodel(android.get(i));
        holder.imageViewLayoutBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageViewLayoutBinding imageViewLayoutBinding;

        public ViewHolder(@NonNull ImageViewLayoutBinding imageViewLayoutBinding) {
            super(imageViewLayoutBinding.getRoot());
            this.imageViewLayoutBinding=imageViewLayoutBinding;
        }
    }
}
