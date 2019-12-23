package com.xiangxue.alvin.flowlayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * author : zhiwen.yang
 * date   : 2019/12/18
 * desc   : 爆炸粒子
 */
public class SplitView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private int width, height;
    private float d = 3;//粒子的直径
    private List<Ball> mBalls;
    private ValueAnimator mAnimator;

    public SplitView(Context context) {
        this(context, null);
    }

    public SplitView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SplitView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mBalls = new ArrayList<>();
        width = mBitmap.getWidth();
        height = mBitmap.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Ball ball = new Ball();
                ball.setColor(mBitmap.getPixel(i, j));
                ball.setX(i * d + d / 2);
                ball.setY(j * d + d / 2);
                ball.setR(d / 2);
                ball.setvX((float) (Math.pow(-1, Math.ceil(Math.random() * 1000)) * 70 * Math.random()));//-70 到70之间的随机值
                ball.setvY(rangInt(-15, 35));
                ball.setaX(0);
                ball.setaY(0.98f);
                mBalls.add(ball);
            }
        }
        mAnimator = ValueAnimator.ofFloat(0 ,1);
        mAnimator.setRepeatCount(-1);
        mAnimator.setDuration(1000);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                updateBall();
                invalidate();
            }
        });
    }

    private float rangInt(int i, int i1) {
        int max = Math.max(i, i1);
        int min = Math.min(i, i1) -1;
        return (float) (min + Math.ceil(Math.random() * (max - min)));
    }

    /**
     * 更新粒子的位置
     */
    private void updateBall() {
        for (Ball ball : mBalls) {
            ball.setX(ball.getX() + ball.getvX());
            ball.setY(ball.getY() + ball.getvY());

            ball.setvX(ball.getvX() + ball.getaX());
            ball.setvY(ball.getvY() + ball.getaY());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(300,400);
        for (Ball ball : mBalls) {
            mPaint.setColor(ball.getColor());
            canvas.drawCircle(ball.getX(), ball.getY(), ball.getR(), mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //执行动画
            mAnimator.start();
        }
        return super.onTouchEvent(event);
    }
}
