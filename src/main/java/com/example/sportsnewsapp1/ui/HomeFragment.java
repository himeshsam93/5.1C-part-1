package com.example.sportsnewsapp1.ui;

import android.os.Bundle;
import android.text.*;
import android.view.*;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import com.example.sportsnewsapp1.R;
import com.example.sportsnewsapp1.adapter.NewsAdapter;
import com.example.sportsnewsapp1.model.News;

import java.util.*;

public class HomeFragment extends Fragment {

    RecyclerView topRecycler, newsRecycler;
    EditText searchBar;

    List<News> newsList;
    NewsAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // connect UI
        topRecycler = view.findViewById(R.id.topRecycler);
        newsRecycler = view.findViewById(R.id.newsRecycler);
        searchBar = view.findViewById(R.id.searchBar);

        // dummy data
        newsList = new ArrayList<>();

        newsList.add(new News(
                "Football Match",
                "An intense football match between top teams with last-minute goals and thrilling moments.",
                R.drawable.football,
                "Football"
        ));

        newsList.add(new News(
                "Cricket Final",
                "A high-pressure cricket final featuring outstanding batting and dramatic wickets in the last overs.",
                R.drawable.cricket,
                "Cricket"
        ));

        newsList.add(new News(
                "Basketball Game",
                "A fast-paced basketball game with incredible dunks, teamwork, and a nail-biting finish.",
                R.drawable.basketball,
                "Basketball"
        ));

        newsList.add(new News(
                "Badminton Game",
                "An exciting badminton match showcasing quick reflexes, powerful smashes, and long rallies.",
                R.drawable.badminton,
                "Badminton"
        ));


        adapter = new NewsAdapter(newsList, (AppCompatActivity) getActivity());

        // Horizontal RecyclerView
        topRecycler.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)
        );
        topRecycler.setAdapter(adapter);

        // Vertical RecyclerView
        newsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsRecycler.setAdapter(adapter);

        // SEARCH FILTER
        searchBar.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                adapter.filter(s.toString());
            }
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {}
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }
}