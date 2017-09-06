package org.ia.polaris.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
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

public class TopicCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEAD = 1;
    private static final int TYPE_ITEM = 2;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else {
            return TYPE_ITEM;
        }
    }

    private Context mContext;
    private List<TopicCard> mCardList;

    public TopicCardAdapter(Context mContext, List<TopicCard> mCardList) {
        this.mContext = mContext;
        this.mCardList = mCardList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.head_topic_card, parent, false);
            return new HeadViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_topic_card, parent, false);
            return new TopicCardViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        if (holder instanceof HeadViewHolder) {
            HeadViewHolder headHolder = (HeadViewHolder) holder;
        } else if (holder instanceof TopicCardViewHolder) {
            TopicCardViewHolder cardHolder = (TopicCardViewHolder) holder;
            if (mCardList == null) {
                return;
            }
            TopicCard card = mCardList.get(position - 1);
            if (card == null) {
                return;
            }
            cardHolder.tvTopicCardTitle.setText(card.getTitle());
        }

    }

    @Override
    public int getItemCount() {
        if (mCardList != null) {
            return mCardList.size() + 1;
        }
        return 1;
    }

    static class TopicCardViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_topic_card_title)
        TextView tvTopicCardTitle;
        @BindView(R.id.iv_topic_card_pic)
        ImageView ivTopicCardPic;

        TopicCardViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.is_head)
        ImageSwitcher isHead;
        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
