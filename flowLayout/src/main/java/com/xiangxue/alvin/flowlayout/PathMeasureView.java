package com.xiangxue.alvin.flowlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Log;
import android.view.View;

/**
 * author : zhiwen.yang
 * date   : 2019/12/24
 * desc   :
 */
public class PathMeasureView extends View {

    private Paint mLinePaint;//坐标系
    private Paint mPaint;
    private Bitmap bitmap;


    public PathMeasureView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setColor(Color.RED);
        mLinePaint.setStrokeWidth(6);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(4);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 6;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.arrow, options);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mLinePaint);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), mLinePaint);
        canvas.translate(getWidth() / 2, getHeight() / 2);

//        Path path = new Path();
//        path.lineTo(0, 200);
//        path.lineTo(200, 200);
//        path.lineTo(200, 0);

        /**
         * PathMeasure 需要关联一个创建好的 path，forceClosed 会影响 path 的测量结果， 如果path 进行了调整，需要重新调用 setPath 方法进行重新关联
         */
//        PathMeasure pathMeasure = new PathMeasure();
//        pathMeasure.setPath(path, true);
//        Log.w("yuong", "forceClosed = true Line1 Length:" + pathMeasure.getLength());
//
//        PathMeasure pathMeasure2 = new PathMeasure();
//        pathMeasure2.setPath(path, false);
//        Log.w("yuong", "forceClosed = false Line2 Length:" + pathMeasure2.getLength());


//        Path path = new Path();
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//        Path dst = new Path();
//        dst.lineTo(-300, -300);//添加一条直线
//
//        PathMeasure pathMeasure = new PathMeasure(path, false);
//        //截取一部分存入 dst 中，并且使用 moveTo 方法保持截取到的 path 第一个点位置不变。
//        pathMeasure.getSegment(200, 1000, dst, true);
//
//        canvas.drawPath(path, mPaint);
//        canvas.drawPath(dst, mLinePaint);

//        Path path = new Path();
//        path.addRect(-100, -100, 100, 100, Path.Direction.CW);
//        path.addOval(-100, -100, 100, 100, Path.Direction.CW);
//        canvas.drawPath(path, mPaint);
//        PathMeasure pathMeasure = new PathMeasure(path, false);
//        Log.w("yuong", "forceClosed = false Line Length:" + pathMeasure.getLength());
//        //跳转到下一条曲线 pathMeasure.getLength()方法针对的是当前曲线而言的，即这里的第一条曲线
//        pathMeasure.nextContour();
//        Log.w("yuong", "forceClosed = false Line Length:" + pathMeasure.getLength());

        path.reset();
        path.addCircle(0, 0, 200, Path.Direction.CW);
        canvas.drawPath(path, mPaint);
        mFloat += 0.01;
        if (mFloat >= 1) {
            mFloat = 0;
        }

        PathMeasure pathMeasure = new PathMeasure(path, false);
//        pathMeasure.getPosTan(pathMeasure.getLength() * mFloat, pos, tan);
//        Log.w("yuong", "pos[0] = " + pos[0] + ", pos[1] = " + pos[1]);
//        Log.w("yuong", "tan[0] = " + tan[0] + ", tan[1] = " + tan[1]);
//
//        //计算出当前点的切线与X 轴夹角的度数
//        double degree = Math.atan2(tan[1], tan[0]) * 180 / Math.PI;
//        matrix.reset();
//        //进行角度旋转
//        matrix.postRotate((float) degree, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
//        //将图片的绘制点中心与当前点重合
//        matrix.postTranslate(pos[0] - bitmap.getWidth() / 2, pos[1] - bitmap.getHeight() / 2);
//        canvas.drawBitmap(bitmap, matrix, mPaint);

        //将 pos 位置信息和 tan 信息保存在 matrix 中
        pathMeasure.getMatrix(pathMeasure.getLength() * mFloat, matrix, PathMeasure.POSITION_MATRIX_FLAG | PathMeasure.TANGENT_MATRIX_FLAG);
        //将图片的旋转坐标调整到中心位置
        matrix.preTranslate(- bitmap.getWidth() / 2, - bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, matrix, mPaint);
        invalidate();
    }

    Path  path = new Path();

    private Matrix matrix = new Matrix();
    private float[] pos = new float[2];
    private float[] tan = new float[2];
    private float mFloat;
}
