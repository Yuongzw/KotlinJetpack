package com.xiangxue.alvin.flowlayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;


/**
 * author : zhiwen.yang
 * date   : 2019/12/31
 * desc   :
 */
public class PathLoadingView extends View {
    private Path path;
    private Path pathHook;
    private Paint paint;

    private PathMeasure pathMeasure;
    private PathMeasure pathMeasure2;
    private float pathLength;
    private float pathLength2;
    private Path destPath;
    private Path destPath2;
    float animatedValue1;
    float animatedValue2;
    ValueAnimator animator1;
    ValueAnimator animator2;

    public PathLoadingView(Context context) {
        this(context, null);
    }

    public PathLoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(10f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        path = new Path();
        path.addCircle(300f, 300f, 100f, Path.Direction.CW);
        path.moveTo(250, 280);
        path.lineTo(280, 340);
        path.lineTo(370, 260);

        pathHook = new Path();
        pathHook.moveTo(250, 280);
        pathHook.lineTo(280, 340);
        pathHook.lineTo(370, 260);

        pathMeasure = new PathMeasure(path, false);
        pathMeasure2 = new PathMeasure(pathHook, false);
        pathLength = pathMeasure.getLength();
        pathLength2 = pathMeasure2.getLength();
        destPath = new Path();
        destPath2 = new Path();
        animator1 = ValueAnimator.ofFloat(0, 1);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取动画执行的进度
                animatedValue1  = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animator2.start();
            }
        });
        animator1.setDuration(2000);
//        animator.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        animator1.start();

        animator2 = ValueAnimator.ofFloat(0, 1);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取动画执行的进度
                animatedValue2  = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator2.setDuration(1000);
//        animator.setRepeatCount(ValueAnimator.INFINITE);//无限循环
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        destPath.reset();

        float distance = animatedValue1 * pathLength;
        float start = (float) (distance - ((0.5 - Math.abs(animatedValue1 - 0.5)) * pathLength));

        pathMeasure.getSegment(0, distance, destPath, true);
        canvas.drawPath(destPath, paint);

        float distance2 = animatedValue2 * pathLength2;

        pathMeasure2.getSegment(0, distance2, destPath2, true);
        canvas.drawPath(destPath, paint);
        canvas.drawPath(destPath2, paint);
    }
}
