package com.xiangxue.alvin.flowlayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * author : zhiwen.yang
 * date   : 2019/12/26
 * desc   :
 */
public class SplashActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ParallaxContainer container = findViewById(R.id.container);
        ImageView ivMan = findViewById(R.id.iv_man);

        container.setIvMan(ivMan);
        container.setUP(new int[] {
                R.layout.view_intro_1,
                R.layout.view_intro_2,
                R.layout.view_intro_3,
                R.layout.view_intro_4,
                R.layout.view_intro_5,
                R.layout.view_login,
        });
    }
}
