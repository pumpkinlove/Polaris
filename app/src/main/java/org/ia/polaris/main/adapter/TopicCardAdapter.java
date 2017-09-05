package org.ia.polaris.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ia.polaris.R;
import org.ia.polaris.main.model.TopicCard;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xu.nan on 2017/9/5.
 */

public class TopicCardAdapter extends RecyclerView.Adapter<TopicCardAdapter.ViewHolder> {

    private Context mContext;
    private List<TopicCard> mCardList;

    public TopicCardAdapter(Context mContext, List<TopicCard> mCardList) {
        this.mContext = mContext;
        this.mCardList = mCardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_topic_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        if (mCardList == null) {
            return;
        }
        TopicCard card = mCardList.get(position);
        if (card == null) {
            return;
        }
        holder.tvTopicCardTitle.setText(card.getTitle());

    }

    @Override
    public int getItemCount() {
        if (mCardList != null) {
            return mCardList.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_topic_card_title)
        TextView tvTopicCardTitle;
        @BindView(R.id.iv_topic_card_pic)
        ImageView ivTopicCardPic;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
