package org.ia.polaris.main.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.ia.polaris.R;
import org.ia.polaris.main.model.TopicCard;

import java.util.List;

/**
 * Created by xu.nan on 2017/9/7.
 */

public class MainVpAdapter extends PagerAdapter {

    private List<TopicCard> mCardList;
    private Context mContext;
    private TopicCardAdapter.TopicClickListener listener;

    public MainVpAdapter(List<TopicCard> mCardList, Context mContext, TopicCardAdapter.TopicClickListener listener) {
        this.mCardList = mCardList;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % mCardList.size();
        RelativeLayout banner = new RelativeLayout(mContext);

        SimpleDraweeView mDraweeView = new SimpleDraweeView (mContext);
        mDraweeView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mDraweeView.setImageURI(Uri.parse(mCardList.get(position).getPicture()));
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mDraweeView.setLayoutParams(params1);
        final int finalI = position;
        mDraweeView.setClickable(true);
        mDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTopicClicked(v, finalI);
            }
        });

        banner.addView(mDraweeView);

        TextView tvTitle = new TextView(mContext);
        tvTitle.setText(mCardList.get(position).getTitle());
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimensionPixelSize(R.dimen.banner_title_font_size));
        tvTitle.setTextColor(mContext.getColor(R.color.white));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.leftMargin = mContext.getResources().getDimensionPixelOffset(R.dimen.banner_title_margin_horizontal);
        params.rightMargin = mContext.getResources().getDimensionPixelOffset(R.dimen.banner_title_margin_horizontal);
        params.bottomMargin = mContext.getResources().getDimensionPixelOffset(R.dimen.banner_title_margin_bottom);

        tvTitle.setLayoutParams(params);
        banner.addView(tvTitle);

        container.addView(banner);
        return banner;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
