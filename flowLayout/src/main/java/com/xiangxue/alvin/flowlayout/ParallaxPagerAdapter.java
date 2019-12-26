package com.xiangxue.alvin.flowlayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author : zhiwen.yang
 * date   : 2019/12/26
 * desc   :
 */
public class ParallaxPagerAdapter extends FragmentPagerAdapter {
    List<ParallaxFragment> fragments;

    public ParallaxPagerAdapter(FragmentManager fm, List<ParallaxFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
