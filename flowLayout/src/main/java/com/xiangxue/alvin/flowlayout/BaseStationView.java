package com.xiangxue.alvin.flowlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhiwen.yang
 * date   : 2020/1/17
 * desc   :基站view
 */
public class BaseStationView extends View {

    private Paint mPaint;
    private List<Integer> mAngle;

    /**
     * 大圆半径
     */
    protected int mBigRadius;

    /**
     * 小圆半径
     */
    protected int mSmallRadius;

    /**
     * 基站方位颜色集合，方便区分不同的方向角
     */
    private int[] mColorSets = {Color.RED, Color.BLUE, Color.GREEN};

    public BaseStationView(Context context) {
        this(context, null);
    }

    public BaseStationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseStationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBigRadius = MyFlowLayout.dp2px(20);
        mSmallRadius = MyFlowLayout.dp2px(10);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mAngle = new ArrayList<>();
        mAngle.add(0);
        mAngle.add(120);
        mAngle.add(240);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        int saveLayer = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
        setBackgroundColor(Color.GRAY);
        canvas.translate(getWidth() / 2 - mBigRadius - mBigRadius / 2, getHeight() / 2 - mBigRadius - mBigRadius / 2);
        RectF bigR = new RectF(0, 0, mBigRadius * 2, mBigRadius * 2);
        RectF smallR = new RectF(mBigRadius - mSmallRadius, mBigRadius - mSmallRadius, mBigRadius + mSmallRadius, mBigRadius + mSmallRadius);

        for (int i = 0; i < mAngle.size(); i++) {
            float startAngle = mAngle.get(i);
            mPaint.setColor(mColorSets[i % mColorSets.length]);
            canvas.drawArc(bigR, startAngle, 60, true, mPaint);
//            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
//            canvas.drawArc(smallR, startAngle, 60, true, mPaint);
//            mPaint.setXfermode(null);
        }
        Path path = new Path();
        path.addCircle(smallR.centerX(), smallR.centerY(), mSmallRadius, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(path);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        canvas.restore();
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
//        canvas.drawCircle(smallR.centerX(), smallR.centerY(), mSmallRadius, mPaint);
//        mPaint.setXfermode(null);


        canvas.restoreToCount(saveLayer);
    }
}
