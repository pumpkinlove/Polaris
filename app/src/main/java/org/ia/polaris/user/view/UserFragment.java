package org.ia.polaris.user.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ia.polaris.R;
import org.ia.polaris.user.adapter.UserFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment implements IUserView {


    @BindView(R.id.tl_user)
    TabLayout tlUser;
    @BindView(R.id.vp_user)
    ViewPager vpUser;
    Unbinder unbinder;

    private List<Fragment>  fragmentList;
    private UserFragmentAdapter adapter;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new LoginFragment());
        fragmentList.add(new RegisterFragment());
        adapter = new UserFragmentAdapter(getChildFragmentManager(), fragmentList);
    }

    void initView() {
        vpUser.setAdapter(adapter);
        vpUser.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlUser));
        tlUser.setupWithViewPager(vpUser);
        vpUser.setOffscreenPageLimit(10);

        String[] titles = {"登录","注册"};

        for (int i=0; i< tlUser.getTabCount(); i++) {
            TabLayout.Tab tab = tlUser.getTabAt(i);
            if (tab != null) {
                tab.setText(titles[i]);
            }
        }
    }


    @Override
    public void backToMain() {

    }

    @Override
    public void toWeChatLogin() {

    }

    @Override
    public void toQQLogin() {

    }

    @Override
    public void toWeiboLogin() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
