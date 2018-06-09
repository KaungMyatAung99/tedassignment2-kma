package com.padcmyanmar.ted2assignment.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.ted2assignment.delegates.TedDelegate;

public class TedTalksViewHolder extends RecyclerView.ViewHolder {

    private TedDelegate tedDelegate;


    public TedTalksViewHolder(View itemView, final TedDelegate tedDelegate)
    {
        super(itemView);
        this.tedDelegate=tedDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tedDelegate.onTapList();
            }
        });
    }
}
