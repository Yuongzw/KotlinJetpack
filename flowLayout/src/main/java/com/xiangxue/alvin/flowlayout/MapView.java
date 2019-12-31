package com.xiangxue.alvin.flowlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.graphics.PathParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * author : zhiwen.yang
 * date   : 2019/12/30
 * desc   :
 */
public class MapView extends View {
    private List<ProvinceItem> provinceItems;
    private int[] colorArray = new int[]{0xFF239BD7, 0xFF30A9E5, 0xFF80CBF1, 0xFFFFFFFF};
    private Paint paint;
    private ProvinceItem select;
    private RectF mapRect;
    private float scale = 1.0f;

    public MapView(Context context) {
        super(context);
        init();
    }

    public MapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        provinceItems = new ArrayList<>();
        paint = new Paint();
        paint.setAntiAlias(true);

        loadSVGThread.start();
    }

    private Thread loadSVGThread = new Thread() {
        @SuppressLint("RestrictedApi")
        @Override
        public void run() {
            try {
                InputStream inputStream = getContext().getResources().openRawResource(R.raw.china);
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = null;
                builder = factory.newDocumentBuilder();
                Document doc = builder.parse(inputStream);
                Element rootElement = doc.getDocumentElement();
                NodeList items = rootElement.getElementsByTagName("path");
                float left = -1;
                float top = -1;
                float right = -1;
                float bottom = -1;
                List<ProvinceItem> list = new ArrayList<>();
                for (int i = 0; i < items.getLength(); i++) {
                    Element item = (Element) items.item(i);
                    String pathData = item.getAttribute("android:pathData");
                    Path path = PathParser.createPathFromPathData(pathData);
                    ProvinceItem provinceItem = new ProvinceItem(path);
                    provinceItem.setDrawColor(colorArray[i % 4 ]);
                    RectF rectF = new RectF();
                    path.computeBounds(rectF, true);//计算Path的边界
                    left = left == -1 ? rectF.left : Math.min(left, rectF.left);
                    top = top == -1 ? rectF.top : Math.min(top, rectF.top);
                    right = right == -1 ? rectF.right : Math.max(right, rectF.right);
                    bottom = bottom == -1 ? rectF.bottom : Math.max(bottom, rectF.bottom);
                    list.add(provinceItem);
                }
                provinceItems = list;
                mapRect = new RectF(left, top, right, bottom);
                //刷新界面
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        requestLayout();
                        invalidate();
                    }
                });
                postInvalidate();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

    private Handler handler = new Handler();

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取当前控件的宽高
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (mapRect != null) {
            double mapWidth = mapRect.width();
            scale = (float) (width / mapWidth);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (provinceItems != null) {
            canvas.save();
            canvas.scale(scale, scale);
            for (ProvinceItem provinceItem : provinceItems) {
                if (provinceItem != select) {
                    provinceItem.drawItem(canvas, paint, false);
                } else {
                    provinceItem.drawItem(canvas, paint, true);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        handleTouch(event.getX() / scale, event.getY() / scale);
        return super.onTouchEvent(event);
    }

    private void handleTouch(float x, float y) {
        if (provinceItems == null) {
            return;
        }
        ProvinceItem selectedItem = null;
        for (ProvinceItem item : provinceItems) {
            if (item.isTouch(x, y)) {
                selectedItem = item;
            }
        }
        if (selectedItem != null) {
            select = selectedItem;
            postInvalidate();
        }
    }
}
