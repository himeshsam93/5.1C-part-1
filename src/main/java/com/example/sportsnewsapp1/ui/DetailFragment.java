package com.example.sportsnewsapp1.ui;

import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsnewsapp1.R;
import com.example.sportsnewsapp1.adapter.NewsAdapter;
import com.example.sportsnewsapp1.model.News;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ImageView image = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.title);
        TextView desc = view.findViewById(R.id.desc);
        RecyclerView related = view.findViewById(R.id.relatedRecycler);
        Button bookmarkBtn = view.findViewById(R.id.bookmarkBtn);

        // GET DATA FROM BUNDLE
        Bundle b = getArguments();

        if (b != null) {
            title.setText(b.getString("title"));
            desc.setText(b.getString("desc"));
            image.setImageResource(b.getInt("image"));
        }

        // RELATED STORIES (DUMMY)
        List<News> relatedList = new ArrayList<>();
        relatedList.add(new News("Related Football News", "Short description", R.drawable.ic_launcher_background, "Football"));
        relatedList.add(new News("Another Match Update", "Quick update", R.drawable.ic_launcher_background, "Football"));

        // SET RECYCLER
        related.setLayoutManager(new LinearLayoutManager(getActivity()));
        related.setAdapter(new NewsAdapter(relatedList, (AppCompatActivity) getActivity()));

        // BOOKMARK CLICK (simple demo)
        bookmarkBtn.setOnClickListener(v -> {
            bookmarkBtn.setText("Bookmarked ✅");
        });

        return view;
    }
}
