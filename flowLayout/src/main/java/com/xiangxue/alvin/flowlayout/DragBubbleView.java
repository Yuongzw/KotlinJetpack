package com.xiangxue.alvin.flowlayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import androidx.annotation.Nullable;

/**
 * author : zhiwen.yang
 * date   : 2019/12/24
 * desc   : 仿QQ气泡
 */
public class DragBubbleView extends View {
    /**
     * 气泡默认状态 -- 静止
     */
    private final int BUBBLE_STATE_DEFAULT = 0;
    /**
     * 气泡相连状态
     */
    private final int BUBBLE_STATE_CONNECT = 1;
    /**
     * 气泡分离状态
     */
    private final int BUBBLE_STATE_APART = 2;
    /**
     * 气泡消失状态
     */
    private final int BUBBLE_STATE_DISMISS = 3;
    /**
     * 气泡半径
     */
    private float mBubbleRadius;
    /**
     * 气泡颜色
     */
    private int mBubbleColor;
    /**
     * 气泡文字
     */
    private String mTextStr;
    /**
     * 气泡文字大小
     */
    private float mTextSize;
    /**
     * 字体颜色
     */
    private int mTextColor;
    /**
     * 不动气泡半径
     */
    private float mBubbleFixedRadius;
    /**
     * 可动气泡半径
     */
    private float mBubbleMoveRadius;
    /**
     * 不动气泡的圆心
     */
    private PointF mBubbleFixedCenter;
    /**
     * 可动气泡的圆心
     */
    private PointF mBubbleMoveCenter;
    /**
     * 气泡画笔
     */
    private Paint mBubblePaint;
    /**
     * 贝塞尔曲线
     */
    private Path mBezierPath;
    /**
     * 消息画笔
     */
    private Paint mTextPain;
    /**
     * 文本绘制区域
     */
    private Rect mTextRect;
    /**
     * 爆炸画笔
     */
    private Paint mBurstPaint;
    /**
     * 爆炸绘制区域
     */
    private Rect mBurstRect;
    /**
     * 气泡状态
     */
    private int mBubbleState = BUBBLE_STATE_DEFAULT;
    /**
     * 两气泡圆心距离
     */
    private float mDist;
    /**
     * 气泡相连状态最大圆心距离
     */
    private float mMaxDist;
    /**
     * 手指触摸偏移量
     */
    private float MOVE_OFFSET = 10;
    /**
     * 气泡爆炸的 bitmap 数组
     */
    private Bitmap[] mBurstBitmapArray;
    /**
     * 是否在执行气泡爆炸动画
     */
    private boolean mIsBurstAnimStart = false;
    /**
     * 当前气泡爆炸图片 Index
     */
    private int mCurDrawableIndex;
    /**
     * 气泡爆炸的图片 id 数组
     */
    private int[] mBurstDrawablesArray = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    public DragBubbleView(Context context) {
        this(context, null);
    }

    public DragBubbleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragBubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.DragBubbleView, defStyleAttr, 0);
        mBubbleRadius = array.getDimension(R.styleable.DragBubbleView_bubble_radius, mBubbleRadius);
        mBubbleColor = array.getColor(R.styleable.DragBubbleView_bubble_color, Color.RED);
        mTextStr = array.getString(R.styleable.DragBubbleView_bubble_text);
        mTextSize = array.getDimension(R.styleable.DragBubbleView_bubble_textSize, mTextSize);
        mTextColor = array.getColor(R.styleable.DragBubbleView_bubble_textColor, Color.WHITE);
        array.recycle();

        //两个圆半径大小一致
        mBubbleFixedRadius = mBubbleRadius;
        mBubbleMoveRadius = mBubbleFixedRadius;
        mMaxDist = 8 * mBubbleRadius;

        MOVE_OFFSET = mMaxDist / 4;

        //气泡画笔  抗拒齿
        mBubblePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBubblePaint.setColor(mBubbleColor);
        mBubblePaint.setStyle(Paint.Style.FILL);

        mBezierPath = new Path();

        //文本画笔
        mTextPain = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPain.setColor(mTextColor);
        mTextPain.setTextSize(mTextSize);
        mTextRect = new Rect();

        //爆炸画笔
        mBurstPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBurstPaint.setFilterBitmap(true);
        mBurstRect = new Rect();
        mBurstBitmapArray = new Bitmap[mBurstDrawablesArray.length];
        for (int i = 0; i < mBurstDrawablesArray.length; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), mBurstDrawablesArray[i]);
            mBurstBitmapArray[i] = bitmap;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //不动气泡圆心
        if (mBubbleFixedCenter == null) {
            mBubbleFixedCenter = new PointF(w / 2, h / 2);
        } else {
            mBubbleFixedCenter.set(w / 2, h / 2);
        }
        if (mBubbleMoveCenter == null) {
            mBubbleMoveCenter = new PointF(w / 2, h / 2);
        } else {
            mBubbleMoveCenter.set(w / 2, h / 2);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mBubbleState == BUBBLE_STATE_CONNECT) {
            //绘制不动气泡
            canvas.drawCircle(mBubbleFixedCenter.x, mBubbleFixedCenter.y, mBubbleFixedRadius, mBubblePaint);
            //绘制贝塞尔曲线
            //控制点坐标
            int controlPointX = (int) ((mBubbleFixedCenter.x + mBubbleMoveCenter.x) / 2);
            int controlPointY = (int) ((mBubbleFixedCenter.y + mBubbleMoveCenter.y) / 2);

            float sinTheta = (mBubbleMoveCenter.y - mBubbleFixedCenter.y) / mDist;
            float cosTheta = (mBubbleMoveCenter.x - mBubbleFixedCenter.x) / mDist;

            //B
            float mBubbleMoveStartX = mBubbleMoveCenter.x + sinTheta * mBubbleMoveRadius;
            float mBubbleMoveStartY = mBubbleMoveCenter.y - cosTheta * mBubbleMoveRadius;

            //A
            float mBubbleFixEndX = mBubbleFixedCenter.x + sinTheta * mBubbleFixedRadius;
            float mBubbleFixEndY = mBubbleFixedCenter.y - cosTheta * mBubbleFixedRadius;

            //C
            float mBubbleMoveEndX = mBubbleMoveCenter.x - sinTheta * mBubbleMoveRadius;
            float mBubbleMoveEndY = mBubbleMoveCenter.y + cosTheta * mBubbleMoveRadius;

            //D
            float mBubbleFixStartX = mBubbleFixedCenter.x - sinTheta * mBubbleFixedRadius;
            float mBubbleFixStartY = mBubbleFixedCenter.y + cosTheta * mBubbleFixedRadius;

            mBezierPath.reset();
            mBezierPath.moveTo(mBubbleFixStartX, mBubbleFixStartY);
            mBezierPath.quadTo(controlPointX, controlPointY, mBubbleMoveEndX, mBubbleMoveEndY);
            //移动到B点
            mBezierPath.lineTo(mBubbleMoveStartX, mBubbleMoveStartY);
            mBezierPath.quadTo(controlPointX, controlPointY, mBubbleFixEndX, mBubbleFixEndY);
            mBezierPath.close();
            canvas.drawPath(mBezierPath, mBubblePaint);

        }
        if (mBubbleState != BUBBLE_STATE_DISMISS) {
            //绘制一个气泡 + 消息数
            canvas.drawCircle(mBubbleMoveCenter.x, mBubbleMoveCenter.y, mBubbleMoveRadius, mBubblePaint);
            mTextPain.getTextBounds(mTextStr, 0, mTextStr.length(), mTextRect);
            canvas.drawText(mTextStr, mBubbleMoveCenter.x - mTextRect.width() / 2, mBubbleMoveCenter.y + mTextRect.height() / 2, mTextPain);

        }
        if (mBubbleState == BUBBLE_STATE_DISMISS && mCurDrawableIndex < mBurstBitmapArray.length) {
            mBurstRect.set(
                    (int)(mBubbleMoveCenter.x - mBubbleMoveRadius),
                    (int)(mBubbleMoveCenter.y - mBubbleMoveRadius),
                    (int)(mBubbleMoveCenter.x + mBubbleMoveRadius),
                    (int)(mBubbleMoveCenter.y + mBubbleMoveRadius)
                    );
            canvas.drawBitmap(mBurstBitmapArray[mCurDrawableIndex],null, mBurstRect, mBubblePaint);
        }

        //1、静止状态，一个气泡 + 消息数
        //2、连接状态，一个小球 + 消息数 + 贝塞尔曲线 + 本身位置上的小球，大小可变化
        //3、分离状态，一个气泡 + 消息数
        //4、消失状态，爆炸效果
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mBubbleState != BUBBLE_STATE_DISMISS) {
                    mDist = (float) Math.hypot(event.getX() - mBubbleFixedCenter.x, event.getY() - mBubbleFixedCenter.y);
                    //如果是点在了圆上
                    if (mDist < mBubbleRadius + MOVE_OFFSET) {  //加上 MOVE_OFFSET 是为了方便拖拽
                        mBubbleState = BUBBLE_STATE_CONNECT;
                    } else {//否则就是点在了圆外
                        mBubbleState = BUBBLE_STATE_DEFAULT;
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mBubbleState != BUBBLE_STATE_DEFAULT) {
                    mDist = (float) Math.hypot(event.getX() - mBubbleFixedCenter.x, event.getY() - mBubbleFixedCenter.y);
                    mBubbleMoveCenter.x = event.getX();
                    mBubbleMoveCenter.y = event.getY();
                    if (mBubbleState == BUBBLE_STATE_CONNECT) {
                        if (mDist < mMaxDist - MOVE_OFFSET) {//如果拖拽长度还在指定范围内，调整不动气泡半径
                            mBubbleFixedRadius = mBubbleRadius - mDist / 8;
                        } else {//如果拖拽长度超过指定范围
                            mBubbleState = BUBBLE_STATE_APART;
                        }
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mBubbleState == BUBBLE_STATE_CONNECT) {
                    //橡皮筋回弹效果
                    startBubbleResetAnim();
                } else if (mBubbleState == BUBBLE_STATE_APART) {
                    if (mDist < 2 * mBubbleRadius) {
                        startBubbleResetAnim();
                    } else {
                        //爆炸效果
                        startBubbleBurstAnim();
                    }
                }
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 爆炸效果
     */
    private void startBubbleBurstAnim() {
        mBubbleState = BUBBLE_STATE_DISMISS;
        ValueAnimator animator = ValueAnimator.ofInt(0, mBurstBitmapArray.length);
        animator.setDuration(500);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurDrawableIndex = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }

    /**
     * 橡皮筋效果
     */
    private void startBubbleResetAnim() {
        ValueAnimator animator = ValueAnimator.ofObject(new PointFEvaluator(),
                new PointF(mBubbleMoveCenter.x, mBubbleMoveCenter.y),//起始点
                new PointF(mBubbleFixedCenter.x, mBubbleFixedCenter.y));//终止点
        animator.setDuration(200);
        animator.setInterpolator(new OvershootInterpolator(5));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mBubbleMoveCenter = (PointF) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mBubbleState = BUBBLE_STATE_DEFAULT;
            }
        });
        animator.start();
    }
}
