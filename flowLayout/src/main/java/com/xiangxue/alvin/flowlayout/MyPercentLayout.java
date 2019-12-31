package com.xiangxue.alvin.flowlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * author : zhiwen.yang
 * date   : 2019/12/26
 * desc   :
 */
public class MyPercentLayout extends RelativeLayout {
    public MyPercentLayout(Context context) {
        super(context);
    }

    public MyPercentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPercentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取父容器宽高
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            if (checkLayoutParams(layoutParams)) {//如果是百分比布局属性
                MyLayoutParams params = (MyLayoutParams) layoutParams;
                float widthPercent = params.widthPercent;
                float heightPercent = params.heightPercent;
                float marginLeftPercent = params.marginLeftPercent;
                float marginRightPercent = params.marginRightPercent;
                float marginTopPercent = params.marginTopPercent;
                float marginBottomPercent = params.marginBottomPercent;

                if (widthPercent > 0) {
                    layoutParams.width = (int) (parentWidth * widthPercent);
                }
                if (heightPercent > 0) {
                    layoutParams.height = (int) (parentHeight * heightPercent);
                }
                if (marginLeftPercent > 0) {
                    ((MyLayoutParams) layoutParams).leftMargin = (int) (parentWidth * marginLeftPercent);
                }
                if (marginRightPercent > 0) {
                    ((MyLayoutParams) layoutParams).rightMargin = (int) (parentWidth * marginRightPercent);
                }
                if (marginTopPercent > 0) {
                    ((MyLayoutParams) layoutParams).topMargin = (int) (parentHeight * marginTopPercent);
                }
                if (marginBottomPercent > 0) {
                    ((MyLayoutParams) layoutParams).bottomMargin = (int) (parentHeight * marginBottomPercent);
                }

            }

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof MyLayoutParams;
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MyLayoutParams(getContext(), attrs);
    }

    class MyLayoutParams extends RelativeLayout.LayoutParams {
        private float widthPercent;
        private float heightPercent;
        private float marginLeftPercent;
        private float marginRightPercent;
        private float marginTopPercent;
        private float marginBottomPercent;

        @SuppressLint("CustomViewStyleable")
        public MyLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.MyPercentLayout);
            widthPercent = a.getFloat(R.styleable.MyPercentLayout_widthPercent, 0);
            heightPercent = a.getFloat(R.styleable.MyPercentLayout_heightPercent, 0);
            marginLeftPercent = a.getFloat(R.styleable.MyPercentLayout_marginLeftPercent, 0);
            marginRightPercent = a.getFloat(R.styleable.MyPercentLayout_marginRightPercent, 0);
            marginTopPercent = a.getFloat(R.styleable.MyPercentLayout_marginTopPercent, 0);
            marginBottomPercent = a.getFloat(R.styleable.MyPercentLayout_marginBottomPercent, 0);
            a.recycle();
        }
    }
}
