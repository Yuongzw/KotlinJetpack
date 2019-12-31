package com.xiangxue.alvin.flowlayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;


/**
 * author : zhiwen.yang
 * date   : 2019/12/31
 * desc   :
 */
public class PathLoadingView extends View {
    private Path path;
    private Paint paint;

    private PathMeasure pathMeasure;
    private float pathLength;
    private Path destPath;
    float animatedValue;
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
        paint.setColor(Color.parseColor("#FF4081"));
        paint.setStrokeWidth(10f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        path = new Path();
        path.addCircle(300f, 300f, 100f, Path.Direction.CW);

        pathMeasure = new PathMeasure(path, false);
        pathLength = pathMeasure.getLength();
        destPath = new Path();
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取动画执行的进度
                animatedValue  = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        destPath.reset();

        float distance = animatedValue * pathLength;
        float start = (float) (distance - ((0.5 - Math.abs(animatedValue - 0.5)) * pathLength));

        pathMeasure.getSegment(start, distance, destPath, true);
        canvas.drawPath(destPath, paint);
    }
}
