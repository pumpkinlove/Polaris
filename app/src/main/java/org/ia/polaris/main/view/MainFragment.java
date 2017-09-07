package org.ia.polaris.main.view;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.ia.polaris.R;
import org.ia.polaris.main.adapter.TopicCardAdapter;
import org.ia.polaris.main.model.TopicCard;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private String picUrl1 = "https://pic1.zhimg.com/v2-909e900716442a4b177b812bb941f5a0.jpg";
    private String picUrl2 = "https://pic2.zhimg.com/v2-9a9360c045261e816a69a0ae7428e15d.jpg";
    private String picUrl3 = "https://pic1.zhimg.com/v2-4b0ba46aac6c6f755ee0b8c250b8f75c.jpg";
    private String picUrl4 = "https://pic3.zhimg.com/v2-fcff7b50dff2e90af1bc0af0c83a3d36.jpg";
    private String picUrl5 = "https://pic1.zhimg.com/v2-19cfcb102b2c7f6989bc61e18e21bc64.jpg";

    private String[] picUrls = {picUrl4, picUrl3, picUrl2, picUrl1,picUrl5};

    @BindView(R.id.rv_topic_card)
    RecyclerView rvTopicCard;
    Unbinder unbinder;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        testView();
    }

    void testView() {
        List<TopicCard> mCardList = new ArrayList<>();
        for (int i=0; i<15; i++) {
            TopicCard card = new TopicCard();
            card.setTitle("测试文章标题 " + i);
            if (i < 6) {
                card.setDate("09月07日 星期四");
            } else if (i < 10) {
                card.setDate("09月06日 星期三");
            } else {
                card.setDate("09月05日 星期二");
            }
            mCardList.add(card);
        }

        List<TopicCard> mHeadCardList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            TopicCard card = new TopicCard();
            card.setTitle("被孩子的『为什么为什么为什么』问得焦头烂额，忍住，千万忍住");
            card.setPicture(picUrls[i]);
            mHeadCardList.add(card);
        }

        TopicCardAdapter adapter = new TopicCardAdapter(getContext(), mCardList, mHeadCardList, new TopicCardAdapter.TopicClickListener() {
            @Override
            public void onTopicClicked(View view, int position) {
                Toast.makeText(getContext(), "position : " + position, Toast.LENGTH_SHORT).show();
            }
        });
        rvTopicCard.setAdapter(adapter);
        rvTopicCard.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
