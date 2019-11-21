package com.xiangxue.alvin.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * author : zhiwen.yang
 * date   : 2019/11/20
 * desc   :
 */
public class MyFlowLayout extends ViewGroup {

    private int mHorizontalSpacing = dp2px(16);
    private int mVerticalSpacing = dp2px(8);
    private List<List<View>> allLines;
    private List<Integer> lineHeights;
    private List<String> datas;
    private OnTagClickListener tagClickListener;

    public MyFlowLayout(Context context) {
        super(context);
    }

    public MyFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTagClickListener(OnTagClickListener tagClickListener) {
        this.tagClickListener = tagClickListener;
    }

    private void initMeasureParams() {
        allLines = new ArrayList<>();
        lineHeights = new ArrayList<>();
    }

    /**
     * 测量View的大小
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        initMeasureParams();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        List<View> lineViews = new ArrayList<>();   //保存一行中所有的View
        int lineWidthUsed = 0;  //记录这行已经使用了多宽
        int lineHeight = 0; //一行的高
        int selfWidth = MeasureSpec.getSize(widthMeasureSpec);//ViewGroup 解析的宽度
        int selfHeight = MeasureSpec.getSize(heightMeasureSpec);//ViewGroup 解析的宽度
        int parentNeedWidth = 0;
        int parentNeedHeight = 0;

        //1、测量子View的大小
        //获取所有子View
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            LayoutParams childParams = childView.getLayoutParams();
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childParams.width);
            int childHeightMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingTop + paddingBottom, childParams.height);
            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            //获取子view测量后的宽高
            int childMeasuredWidth = childView.getMeasuredWidth();
            int childMeasuredHeight = childView.getMeasuredHeight();


            //通过宽度来判断是否需要换行，通过换行后的每行的行高类获取整个ViewGroup的行高
            //如果需要换行
            if (childMeasuredWidth + lineWidthUsed + mHorizontalSpacing > selfWidth) { //判断现在的宽度是否大于父View的宽度，如果大于就要换行
                allLines.add(lineViews);
                lineHeights.add(lineHeight);

                parentNeedHeight = parentNeedHeight + lineHeight + mVerticalSpacing;
                parentNeedWidth = Math.max(parentNeedWidth, lineWidthUsed + mVerticalSpacing);

                lineViews = new ArrayList<>();
                lineWidthUsed = 0;
                lineHeight = 0;
            }
            lineViews.add(childView);
            lineWidthUsed = lineWidthUsed + childMeasuredWidth + mHorizontalSpacing;
            lineHeight = Math.max(lineHeight, childMeasuredHeight);
            if (i == getChildCount() - 1) {
                lineHeights.add(lineHeight);
                allLines.add(lineViews);
                parentNeedWidth = Math.max(parentNeedWidth, lineWidthUsed);
                parentNeedHeight += lineHeight;
            }
        }

        //2、测量自己的大小
        //作为一个ViewGroup ，自己本身也是一个View，它的大小也需要根据它的父View 给它提供的宽高来度量
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int realWidth = (widthMode == MeasureSpec.EXACTLY) ? selfWidth : parentNeedWidth ;
        int realHeight = (heightMode == MeasureSpec.EXACTLY) ? selfHeight : parentNeedHeight + paddingTop + paddingBottom;
        setMeasuredDimension(realWidth, realHeight);
    }

    /*
        自定义View 主要实现 onMeasure  + onDraw
        自定义ViewGroup 主要实现 onMeasure + onLayout

     */
    /*
        在measure()过程结束后就可以获取 getMeasuredWidth()、getMeasuredHeight()的值
        通过 setMeasuredDimension()方法来进行设置的

        在layout()过程结束后才能获取到 getWidth()、getHeight()的值
        通过视图右边的坐标减去左边的坐标计算出来的
     */

    /**
     * 确定子View布局
     * 由于FlowLayout 自己没有特殊的要求，所以不需要对自己布局
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int curL = getLeft();
        int curT = 0;
        for (int i = 0; i < allLines.size(); i++) {
            List<View> lineViews = allLines.get(i);
            Integer lineHeight = lineHeights.get(i);
            for (int j = 0; j < lineViews.size(); j++) {
                View childView = lineViews.get(j);
                int left = curL;
                int top = curT;
                int right = left + childView.getMeasuredWidth();
                int bottom = top + childView.getMeasuredHeight();

                childView.layout(left, top, right, bottom);
                curL = right + mHorizontalSpacing;
            }
            curL = getLeft();
            curT = curT + lineHeight + mVerticalSpacing;
        }
    }

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

    /**
     * 设置数据源
     * @param datas
     */
    public void setDatas(List<String> datas) {
        this.datas = datas;
        for (int i = 0; i < datas.size(); i++) {
            final TextView textView = new TextView(getContext());
            textView.setBackground(getResources().getDrawable(R.drawable.textview_selector));
            textView.setText(datas.get(i));
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    tagClickListener.onTagClick(textView.getText().toString());
                }
            });
            addView(textView);
        }
    }

    interface OnTagClickListener {
        void onTagClick(String text);
    }

}
