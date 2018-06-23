package com.padcmyanmar.ted2assignment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.ted2assignment.R;
import com.padcmyanmar.ted2assignment.data.vos.TedTalksVO;
import com.padcmyanmar.ted2assignment.delegates.TedDelegate;
import com.padcmyanmar.ted2assignment.viewHolders.TedTalksViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TedTalkAdapter extends RecyclerView.Adapter<TedTalksViewHolder> {

    private TedDelegate tedDelegate;
    private List<TedTalksVO> mTalksList;

    public TedTalkAdapter(TedDelegate tedDelegate) {
        this.tedDelegate = tedDelegate;
        mTalksList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TedTalksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_ted, parent, false);

        return new TedTalksViewHolder(view, tedDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull TedTalksViewHolder holder, int position) {
        holder.setTalksData(mTalksList.get(position));
    }

    @Override
    public int getItemCount() {
        return mTalksList.size();
    }

    public void setTalksList(List<TedTalksVO> newsList) {
        mTalksList = newsList;
        notifyDataSetChanged();
    }
}
