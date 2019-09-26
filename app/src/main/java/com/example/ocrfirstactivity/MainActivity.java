package com.example.ocrfirstactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
 //   private RecyclerView mRecyclerView;
 //   private List<FakeNewsList> fakeNewsList = new ArrayList<>();
 //   private MyFakeNewsAdapter myFakeNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Actualité Gorafi");

        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewarticle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyFakeNewsAdapter());

    }
}
