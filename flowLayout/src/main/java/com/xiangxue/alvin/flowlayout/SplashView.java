package com.xiangxue.alvin.flowlayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import androidx.annotation.Nullable;

/**
 * author : zhiwen.yang
 * date   : 2019/12/19
 * desc   :
 */
public class SplashView extends View {

    private Paint mPaint;//旋转圆的画笔

    private Paint mHolePaint;//扩散圆的画笔

    private ValueAnimator mValueAnimator;//属性动画

    private int mBackground = Color.WHITE;//背景色
    private int[] mCircleColors;//小球颜色数组

    //旋转圆的中心坐标
    private float mCenterX;
    private float mCenterY;

    private float mDistance;//表示斜对角线长度的一般，扩散圆最大半径

    private float mCircleRadius = 18;//6个小球的半径

    private float mRotateRadius = 90;//旋转圆的半径

    private float mCurrentRotateAngle = 0f;//当前大圆的旋转角度

    private float mCurrentRotateRadius = mRotateRadius;//当前大圆的半径

    private float mCurrentHoleRadius = 0f;//扩散圆的半径

    private int mRotateDuration = 1200;//动画时长

    public SplashView(Context context) {
        this(context, null);
    }

    public SplashView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SplashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHolePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHolePaint.setStyle(Paint.Style.STROKE);
        mHolePaint.setColor(mBackground);
        mCircleColors = getContext().getResources().getIntArray(R.array.splash_circle_colors);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w * 1f / 2;
        mCenterY = h * 1f / 2;
        mDistance = (float) (Math.hypot(w, h) / 2);
    }

    private SplashState mState;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mState == null) {
            mState = new RotateState();
        }
        mState.drawState(canvas);
    }

    private void drawBackground(Canvas canvas) {
        if (mCurrentHoleRadius > 0) {
            //绘制空心圆
            float strokeWidth = mDistance - mCurrentHoleRadius;
            float radius = strokeWidth / 2 + mCurrentHoleRadius;
            mHolePaint.setStrokeWidth(strokeWidth);
            canvas.drawCircle(mCenterX, mCenterY, radius, mHolePaint);
        }else {
            canvas.drawColor(mBackground);
        }
    }


    private void drawCircles(Canvas canvas) {
        float rotateAngle = (float) (Math.PI * 2 / mCircleColors.length);
        for (int i = 0; i < mCircleColors.length; i++) {
            //x = r * cos(a) + centX
            //y = r * sin(a) + centY
            float angle = i * rotateAngle + mCurrentRotateAngle;
            float cX = (float) (Math.cos(angle) * mCurrentRotateRadius + mCenterX);
            float cY = (float) (Math.sin(angle) * mCurrentRotateRadius + mCenterY);
            mPaint.setColor(mCircleColors[i]);
            canvas.drawCircle(cX, cY, mCircleRadius, mPaint);
        }
    }

    abstract class SplashState {
        abstract void drawState(Canvas canvas);
    }

    //1、旋转
    class RotateState extends SplashState {

        public RotateState() {
            mValueAnimator = ValueAnimator.ofFloat(0, (float) (Math.PI * 2));
            mValueAnimator.setRepeatCount(2);
            mValueAnimator.setDuration(mRotateDuration);
            mValueAnimator.setInterpolator(new LinearInterpolator());
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotateAngle = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mValueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mState = new MerginState();
                }
            });
            mValueAnimator.start();
        }

        @Override
        void drawState(Canvas canvas) {
            //绘制背景
            drawBackground(canvas);
            //绘制6个小球
            drawCircles(canvas);
        }
    }


    //2、扩散聚合
    class MerginState extends SplashState {

        public MerginState() {
            mValueAnimator = ValueAnimator.ofFloat(mCircleRadius, mRotateRadius);
            mValueAnimator.setDuration(mRotateDuration);
            mValueAnimator.setInterpolator(new OvershootInterpolator(10f));
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotateRadius = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mValueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mState = new HoleState();
                }
            });
            mValueAnimator.reverse();
        }

        @Override
        void drawState(Canvas canvas) {
            drawBackground(canvas);
            drawCircles(canvas);
        }
    }

    //3、水波纹效果
    class HoleState extends SplashState{

        public HoleState() {
            mValueAnimator = ValueAnimator.ofFloat(mCircleRadius, mDistance);
            mValueAnimator.setDuration(mRotateDuration);
            mValueAnimator.setInterpolator(new LinearInterpolator());
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentHoleRadius = (float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            mValueAnimator.start();
        }

        @Override
        void drawState(Canvas canvas) {
            drawBackground(canvas);
        }
    }

}
