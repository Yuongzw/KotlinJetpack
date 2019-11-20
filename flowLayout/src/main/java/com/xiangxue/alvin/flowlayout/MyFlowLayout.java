package com.xiangxue.alvin.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/**
 * author : zhiwen.yang
 * date   : 2019/11/20
 * desc   :
 */
public class MyFlowLayout extends ViewGroup {

    public MyFlowLayout(Context context) {
        super(context);
    }

    public MyFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 测量View的大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        //1、测量子View的大小
        //获取所有子View
        for (int i = 0; i < getChildCount(); i++) {
            View childView  = getChildAt(i);
            LayoutParams childParams = childView.getLayoutParams();
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childParams.width);
            int childHeightMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingTop + paddingBottom, childParams.height);
            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            //获取子view测量后的宽高
            int childMeasuredWidth = childView.getMeasuredWidth();
            int childMeasuredHeight = childView.getMeasuredHeight();
        }

        //2、测量自己的大小
    }

    /*
        自定义View 主要实现 onMeasure  + onDraw
        自定义ViewGroup 主要实现 onMeasure + onLayout
     */
    /**
     * 确定子View布局
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
