package com.burhan.livetv.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.burhan.livetv.R;
import com.burhan.livetv.model.Channel;
import com.burhan.livetv.ui.main.mvp.MainView;

/**
 * Created by Burhan on 10/08/2017.
 */

class ChannelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = ChannelViewHolder.class.getName();
    private ImageView ivChannel;
    private MainView view;
    private Channel channel;

    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public ChannelViewHolder(View itemView) {
        super(itemView);
        ivChannel = (ImageView) itemView.findViewById(R.id.iv_channel);
        itemView.setOnClickListener(this);
    }

    public void bind(Channel channel) {
        this.channel = channel;
        if (channel == null) return;
        Glide.with(ivChannel.getContext()).load(channel.getLogo()).into(ivChannel);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() called with: v = [" + getAdapterPosition() + "]");
        if(this.channel!= null && getView()!= null){
            getView().onChannelSelected(channel);
        }
    }
}
