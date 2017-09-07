package org.ia.polaris.main.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.ia.polaris.R;
import org.ia.polaris.main.model.TopicCard;
import org.ia.polaris.utils.DateUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    private List<TopicCard> mHeadCardList;
    private TopicClickListener listener;

    public TopicCardAdapter(Context mContext, List<TopicCard> mCardList, List<TopicCard> mHeadCardList, TopicClickListener listener) {
        this.mContext = mContext;
        this.mCardList = mCardList;
        this.mHeadCardList = mHeadCardList;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.head_topic_card, parent, false);
            return new HeadViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_topic_card, parent, false);
            return new TopicCardViewHolder(itemView, listener);
        }
    }

    private boolean inited;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadViewHolder) {
            if (!inited) {
                HeadViewHolder headHolder = (HeadViewHolder) holder;
                initHeadBanner(headHolder);
            }
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
            if (position == 1 || !card.getDate().equals(mCardList.get(position - 2).getDate())) {
                cardHolder.tvDateStamp.setVisibility(View.VISIBLE);
                if (DateUtil.getTodayStamp().equals(card.getDate())) {
                    cardHolder.tvDateStamp.setText("今日热闻");
                } else {
                    cardHolder.tvDateStamp.setText(card.getDate());
                }
            } else {
                cardHolder.tvDateStamp.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public int getItemCount() {
        if (mCardList != null) {
            return mCardList.size() + 1;
        }
        return 1;
    }

    private void initHeadBanner(final HeadViewHolder headHolder) {
        MainVpAdapter mainVpAdapter = new MainVpAdapter(mHeadCardList, mContext, listener);
        headHolder.vpMain.setAdapter(mainVpAdapter);
        for (int i=0; i<mHeadCardList.size(); i++) {
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(mContext);
            simpleDraweeView.setImageResource(R.drawable.point_selector);
            int pointSize = mContext.getResources().getDimensionPixelSize(R.dimen.point_size);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(pointSize, pointSize);
            params.leftMargin = pointSize / 2;
            params.rightMargin = pointSize / 2;
            simpleDraweeView.setLayoutParams(params);
            if (i > 0) {
                simpleDraweeView.setSelected(false);
            } else {
                simpleDraweeView.setSelected(true);
            }
            headHolder.llPoints.addView(simpleDraweeView);
        }

        headHolder.vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            int lastPosition;
            @Override
            public void onPageSelected(int position) {
                position = position % mHeadCardList.size();
                headHolder.llPoints.getChildAt(position).setSelected(true);
                headHolder.llPoints.getChildAt(lastPosition).setSelected(false);
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        final Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentPosition = headHolder.vpMain.getCurrentItem();

                if(currentPosition == headHolder.vpMain.getAdapter().getCount() - 1){
                    // 最后一页
                    headHolder.vpMain.setCurrentItem(0);
                }else{
                    headHolder.vpMain.setCurrentItem(currentPosition + 1);
                }

                // 一直给自己发消息
                mHandler.postDelayed(this, 5000);
            }
        }, 5000);

        inited = true;
    }

    static class TopicCardViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_topic_card_title)
        TextView tvTopicCardTitle;
        @BindView(R.id.iv_topic_card_pic)
        ImageView ivTopicCardPic;
        @BindView(R.id.tv_date_stamp)
        TextView tvDateStamp;

        private TopicClickListener listener;

        TopicCardViewHolder(View view, TopicClickListener listener) {
            super(view);
            this.listener = listener;
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cv_topic)
        void onTopicClick(View view) {
            listener.onTopicClicked(view, getPosition());
        }
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.vp_main)
        ViewPager vpMain;

        @BindView(R.id.ll_points)
        LinearLayout llPoints;

        HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface TopicClickListener {
        void onTopicClicked(View view, int position);
    }
}
