package com.xiangxue.alvin.flowlayout;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * author : zhiwen.yang
 * date   : 2019/12/26
 * desc   :
 */
public class ParallaxContainer extends FrameLayout implements ViewPager.OnPageChangeListener {
    private ParallaxPagerAdapter adapter;
    private List<ParallaxFragment> fragments;
    private ImageView ivMan;

    public ParallaxContainer(@NonNull Context context) {
        super(context);
    }

    public ParallaxContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallaxContainer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setIvMan(ImageView ivMan) {
        this.ivMan = ivMan;
    }

    public void setUP(int... childIds) {
        fragments = new ArrayList<>();
        for (int i = 0; i < childIds.length; i++) {
            ParallaxFragment fragment = new ParallaxFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("layoutId", childIds[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        ViewPager viewPager = new ViewPager(getContext());
        viewPager.setId(R.id.parallax_pager);
        viewPager.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        adapter = new ParallaxPagerAdapter(((SplashActivity) getContext()).getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        addView(viewPager, 0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int containerWidth = getWidth();
        ParallaxFragment outFragment = null;
        try {
            outFragment = fragments.get(position - 1);
        } catch (Exception e) {
        }
        ParallaxFragment inFragment = null;
        try {
            inFragment = fragments.get(position);
        } catch (Exception e) {
        }
        if (outFragment != null) {
            List<View> outViews = outFragment.getParallaxViews();
            //开始执行动画
            if (outViews != null) {
                for (View outView : outViews) {
                    ParallaxViewTag tag = (ParallaxViewTag) outView.getTag(R.id.parallax_view_tag);
                    if (tag == null) {
                        continue;
                    }
                    ViewHelper.setTranslationY(outView, (containerWidth - positionOffsetPixels) * tag.yIn);
                    ViewHelper.setTranslationX(outView, (containerWidth - positionOffsetPixels) * tag.xIn);
                }
            }
        }
        if (inFragment != null) {
            List<View> inViews = inFragment.getParallaxViews();
            //开始执行动画
            if (inViews != null) {
                for (View inView : inViews) {
                    ParallaxViewTag tag = (ParallaxViewTag) inView.getTag(R.id.parallax_view_tag);
                    if (tag == null) {
                        continue;
                    }
                    ViewHelper.setTranslationY(inView, 0 - positionOffsetPixels * tag.yOut);
                    ViewHelper.setTranslationX(inView, 0 - positionOffsetPixels * tag.xOut);
                }
            }
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (position == adapter.getCount() - 1) {
            ivMan.setVisibility(INVISIBLE);
        } else {
            ivMan.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        AnimationDrawable animationDrawable = (AnimationDrawable) ivMan.getBackground();
        switch (state) {
            case ViewPager.SCROLL_STATE_DRAGGING:
                animationDrawable.start();
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                animationDrawable.stop();
                break;
            default:
                break;
        }
    }
}
