package com.padcmyanmar.ted2assignment.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.ted2assignment.R;
import com.padcmyanmar.ted2assignment.data.vos.TedTalksVO;
import com.padcmyanmar.ted2assignment.delegates.TedDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TedTalksViewHolder extends RecyclerView.ViewHolder {

    private TedDelegate nTalksDelegate;
    private TedTalksVO mTalks;

    private TedDelegate tedDelegate;

    @BindView(R.id.iv_talks)
    ImageView ivtalks;

    @BindView(R.id.tv_name)
    TextView tvSpeakerName;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_time)
    TextView tvDuration;

    public TedTalksViewHolder(View itemView, final TedDelegate tedDelegate) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.tedDelegate = tedDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tedDelegate.onTapList(mTalks);
            }
        });
    }

    public void setTalksData(TedTalksVO talks) {

        mTalks = talks;

        Glide.with(ivtalks.getContext()).load(talks.getImageUrl()).into(ivtalks);
        tvSpeakerName.setText(talks.getSpeakerVOs().getSpeakerName());
        tvTitle.setText(talks.getTitle());
        tvDuration.setText(talks.getDurationInSec());
    }
}
