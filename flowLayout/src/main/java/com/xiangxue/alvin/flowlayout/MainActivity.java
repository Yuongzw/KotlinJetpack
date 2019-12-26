package com.xiangxue.alvin.flowlayout;


import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> datas = new ArrayList<>();
    private MyFlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
