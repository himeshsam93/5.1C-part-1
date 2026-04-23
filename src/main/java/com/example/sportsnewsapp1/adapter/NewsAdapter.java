package com.example.sportsnewsapp1.adapter;


import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsnewsapp1.R;
import com.example.sportsnewsapp1.model.News;
import com.example.sportsnewsapp1.ui.DetailFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<News> list, fullList;
    AppCompatActivity activity;

    public NewsAdapter(List<News> list, AppCompatActivity activity) {
        this.list = list;
        this.fullList = new ArrayList<>(list);
        this.activity = activity;
    }

    // FILTER
    public void filter(String text) {
        list.clear();
        for (News n : fullList) {
            if (n.category.toLowerCase().contains(text.toLowerCase())) {
                list.add(n);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = list.get(position);

        holder.title.setText(news.title);
        holder.image.setImageResource(news.image);

        // CLICK → DETAIL
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", news.title);
            bundle.putString("desc", news.description);
            bundle.putInt("image", news.image);

            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(bundle);

            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
        }
    }
}