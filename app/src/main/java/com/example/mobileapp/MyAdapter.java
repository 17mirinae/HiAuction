package com.example.mobileapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Post> items = new ArrayList<Post>();

    static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView image;
        AppCompatTextView title, postNum, writer;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (AppCompatImageView) itemView.findViewById(R.id.imageViewPostCard);
            title = (AppCompatTextView) itemView.findViewById(R.id.titleTextPostCard);
            postNum = (AppCompatTextView) itemView.findViewById(R.id.postNumTextPostCard);
            writer = (AppCompatTextView) itemView.findViewById(R.id.writerTextPostCard);
        }
    }

    public void setData(Post data) {
        items.add(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
