package com.xiangxue.alvin.flowlayout;


import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> datas = new ArrayList<>();
    private MyFlowLayout flowLayout;
    private RecyclerView recyclerView;
    private FeedAdapter adapter;
    private RelativeLayout rl_suspen;
    private CircleImageView iv_avatar;
    private TextView tv_nickname;
    private int susPendHeight;
    private int mCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Density.setDensity(getApplication(), this);
        setContentView(R.layout.activity_main5);
//        setContentView(new SplitView(this));
//        flowLayout = findViewById(R.id.flowLayout);
//        initDatas();
//        flowLayout.setDatas(datas);
//        flowLayout.setTagClickListener(new MyFlowLayout.OnTagClickListener() {
//            @Override
//            public void onTagClick(String text) {
//                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
//            }
//        });

//        recyclerView = findViewById(R.id.recyclerView);
//        rl_suspen = findViewById(R.id.rl_suspen);
//        iv_avatar = findViewById(R.id.iv_avatar);
//        tv_nickname = findViewById(R.id.tv_nickname);
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new FeedAdapter();
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                //获取悬浮条的高度
//                susPendHeight = rl_suspen.getHeight();
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                //对悬浮条的位置进行调整
//                //找到下一个 item
//                View view = layoutManager.findViewByPosition(mCurrentPosition + 1);
//                if (view != null) {
//                    if (view.getTop() <= susPendHeight) {
//                        //移动悬浮条
//                        rl_suspen.setY(-(susPendHeight - view.getTop()));
//                    } else {//保持原来的位置
//                        rl_suspen.setY(0);
//                    }
//                }
//                if (mCurrentPosition != layoutManager.findFirstVisibleItemPosition()) {
//                    mCurrentPosition = layoutManager.findFirstVisibleItemPosition();
//                    updateSuspensionBar();
//                }
//            }
//        });

    }

    private void updateSuspensionBar() {
        //用户头像
        Picasso.with(this)
                .load(getAvatarResId(mCurrentPosition))
                .centerInside()
                .fit()
                .into(iv_avatar);
        tv_nickname.setText("NetEase " + mCurrentPosition);
    }

    private int getAvatarResId(int position){
        switch (position % 4){
            case 0:
                return R.drawable.avatar1;
            case 1:
                return R.drawable.avatar2;
            case 2:
                return R.drawable.avatar3;
            case 3:
                return R.drawable.avatar4;
        }
        return 0;
    }

    /**
     * 获取手机网络类型
     *
     * @see TelephonyManager ;
     */
    public int getNetWorkType(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(TELEPHONY_SERVICE);
        return tm.getNetworkType();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    private void initDatas() {
        datas.add("惠氏3段");
        datas.add("奶粉2段");
        datas.add("图书勋章日");
        datas.add("伯爵茶");
        datas.add("阿迪5折秒杀");
        datas.add("蓝胖子");
        datas.add("婴儿洗衣机");
        datas.add("小度在家");
        datas.add("遥控车可坐");
        datas.add("搬家袋");
        datas.add("剪刀车");
        datas.add("滑板车儿童");
        datas.add("空调风扇");
        datas.add("空鼓锤");
        datas.add("笔记本电脑");
    }
}
