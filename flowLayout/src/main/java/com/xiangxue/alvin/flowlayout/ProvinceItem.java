package com.xiangxue.alvin.flowlayout;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;

/**
 * author : zhiwen.yang
 * date   : 2019/12/30
 * desc   : 省份封装对象
 */
public class ProvinceItem {
    private Path path;

    /**
     * 绘制颜色
     */
    private int drawColor;

    public ProvinceItem(Path path) {
        this.path = path;
    }

    public void setDrawColor(int drawColor) {
        this.drawColor = drawColor;
    }

    public void drawItem(Canvas canvas, Paint paint, boolean isSelected) {
        if (isSelected) {
            //选中时，绘制内部的颜色
            paint.clearShadowLayer();
            paint.setStrokeWidth(1);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(drawColor);
            canvas.drawPath(path, paint);

            //绘制边界
            paint.setStyle(Paint.Style.STROKE);
            int strokeColor = Color.RED;
            paint.setColor(strokeColor);
            canvas.drawPath(path, paint);
        } else {
            //绘制内部
            paint.setShadowLayer(8, 0, 0, 0xffffff);
            paint.setStrokeWidth(2);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLACK);
            canvas.drawPath(path, paint);

            //绘制边界
            paint.clearShadowLayer();
            paint.setStrokeWidth(2);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(drawColor);
            canvas.drawPath(path, paint);
        }
    }

    public boolean isTouch(float x, float y) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);//计算Path的边界

        Region region = new Region();
        region.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return region.contains((int)x, (int)y);
    }
}
