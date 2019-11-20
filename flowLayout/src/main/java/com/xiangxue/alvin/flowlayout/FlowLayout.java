package com.xiangxue.alvin.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 享学课堂 Alvin
 * @package com.xiangxue.alvin.flowlayout
 * @fileName flowLayout
 * @date on 2019/11/18
 * @qq 2464061231
 **/
public class FlowLayout extends ViewGroup {

    private int mHorizontalSpacing = dp2px(16); //每个item横向间距
    private int mVerticalSpacing = dp2px(8); //每个item横向间距

    private List<List<View>> allLines;// 记录所有的行，一行一行的存储
    private List<Integer> heights; // 记录每一行的行高

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initMeasureParams() {
        allLines = new ArrayList<>();
        heights = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        initMeasureParams();
        int selfWidth = MeasureSpec.getSize(widthMeasureSpec);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int childCount = getChildCount();
        int lineWidthUsed = 0;
        int lineHeight = 0;

        List<View> lineViews = new ArrayList<>();
        int parentNeededWidth = 0;
        int parentNeededHeight = 0;

        for (int i = 0; i < childCount; i++) {
            //获取子View；
            View childView = getChildAt(i);
            LayoutParams childLP = childView.getLayoutParams();
            //子View和父viewGroup商量买房子的事（尺寸）
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,paddingLeft + paddingRight, childLP.width);
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childLP.height);
            //设置子View的尺寸
            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);


            //确定是否换行
            int childMeasureWidth = childView.getMeasuredWidth();
            int childMeasureHeight = childView.getMeasuredHeight();
            if (childMeasureWidth + lineWidthUsed + mHorizontalSpacing > selfWidth) {
                allLines.add(lineViews);
                heights.add(lineHeight);

                parentNeededHeight = parentNeededHeight + lineHeight + mVerticalSpacing;
                parentNeededWidth = Math.max(parentNeededWidth, lineWidthUsed + mHorizontalSpacing);
                lineViews = new ArrayList<>();
                lineWidthUsed = 0;
                lineHeight = 0;

            }

            lineViews.add(childView);
            lineWidthUsed = lineWidthUsed + childMeasureWidth + mHorizontalSpacing;
            lineHeight = Math.max(lineHeight, childMeasureHeight);

        }

        //确定流式布局自身的宽高
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int selfHeight = MeasureSpec.getSize(heightMeasureSpec);

        int realWidth = (widthMode == MeasureSpec.EXACTLY) ? selfWidth : parentNeededWidth;
        int realHeight = (heightMode == MeasureSpec.EXACTLY) ? selfHeight : parentNeededHeight;
        setMeasuredDimension(realWidth,realHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int lineCount = allLines.size();
        int curX = getLeft();
        int curT = 0;

        for (int i = 0; i < lineCount; i++) {
            List<View> lineViews = allLines.get(i);
            int lineHeight = heights.get(i);
            for (int j = 0; j < lineViews.size(); j++) {
                View view = lineViews.get(j);
                int left = curX;
                int top = curT;
                int right = left + view.getMeasuredWidth();
                int bottom = top + view.getMeasuredHeight();
                view.layout(left, top, right, bottom);
                curX = right + mHorizontalSpacing;
            }
            curT = curT + lineHeight + mVerticalSpacing;
            curX = getLeft();
        }
    }

    private String getModeString(int mode) {
        String result = "Unknow";
        switch (mode) {
            case MeasureSpec.UNSPECIFIED :
                result = "Unspecified";
                break;
            case MeasureSpec.EXACTLY:
                result = "EXACTLY";
                break;
            case MeasureSpec.AT_MOST:
                result = "AT_MOST";
                break;
            default:
        }
        return  result;
    }

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
