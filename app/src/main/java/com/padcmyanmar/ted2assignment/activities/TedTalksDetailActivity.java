package com.padcmyanmar.ted2assignment.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.ted2assignment.R;
import com.padcmyanmar.ted2assignment.adapters.WatchAdapter;

public class TedTalksDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        RecyclerView recyclerView=findViewById(R.id.rv_watch);
        WatchAdapter watchAdapter=new WatchAdapter();
        recyclerView.setAdapter(watchAdapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false)));
    }
}
