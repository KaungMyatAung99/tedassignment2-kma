package com.padcmyanmar.ted2assignment.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.ted2assignment.R;
import com.padcmyanmar.ted2assignment.adapters.WatchAdapter;
import com.padcmyanmar.ted2assignment.data.models.TedTalkModel;
import com.padcmyanmar.ted2assignment.data.vos.TedTalksVO;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TedTalksDetailActivity extends BaseActivity {


    @BindView(R.id.iv_news_backdrop_image)
    ImageView ivBackDrop;

    @BindView(R.id.tv_speaker_name)
    TextView tvSpeakerName;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_brief)
    TextView tvBrief;

    @BindView(R.id.tv_duration)
    TextView tvDuration;

    @BindView(R.id.tv_about_speaker_name)
    TextView tvAboutSpeakerName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        ButterKnife.bind(this, this);

        String talkId = getIntent().getStringExtra("talksId");

        TedTalksVO talks = TedTalkModel.getObjInstance().getTalksById(talkId);
        BindData(talks);

        RecyclerView recyclerView = findViewById(R.id.rv_watch);
        WatchAdapter watchAdapter = new WatchAdapter();
        recyclerView.setAdapter(watchAdapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false)));
    }

    private void BindData(TedTalksVO talks) {
        Glide.with(ivBackDrop.getContext()).load(talks.getImageUrl()).into(ivBackDrop);
        tvSpeakerName.setText(talks.getSpeakerVOs().getSpeakerName());
        tvTitle.setText(talks.getTitle());
        tvBrief.setText(talks.getDescription());
        tvDuration.setText(talks.getDurationInSec());
        tvAboutSpeakerName.setText(talks.getSpeakerVOs().getSpeakerName());
    }
}
