package com.xiangxue.alvin.flowlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : zhiwen.yang
 * date   : 2020/1/17
 * desc   :
 */
public class SectorView extends View {
    public SectorView(Context context) {
        super(context);
    }

    public SectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SectorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private int color1= Color.WHITE;//外圈
    private int color2=Color.WHITE;//中间
    private int color3=Color.WHITE;//内圈
    private int color4=Color.WHITE;//背景


    private int color5=Color.WHITE;//线
    private int color6=Color.WHITE;//扇形




    public void setPaintColor(int color1,int color2,int color3,int color4,int color5,int color6){
        this.color1=color1;
        this.color2=color2;
        this.color3=color3;
        this.color4=color4;
        this.color5=color5;
        this.color6=color6;
    }

    private int with=200,height=200;
    private int proportion=24;//等分比例

    public void setWith(int with){
        this.with=with;
        this.height=with;
    }


    private double startTime=24;
    private double stopTime=24;
    private int angle=0;//旋转角度

    private double startX=getRoundX(with/2,with/2,with/2-12,startTime);
    private double startY=getRoundY(with/2,with/2,with/2-12,startTime);

    private double stopX=0;
    private double stopY=0;

    public void setTime(int startTime,int stopTime){
        this.startTime=(double) startTime;
        this.stopTime=(double) stopTime;

        startX = getRoundX(with/2,with/2,with/2-12,startTime);
        startY = getRoundY(with/2,with/2,with/2-12,startTime);

        stopX = getRoundX(with/2,with/2,with/2-12,stopTime);
        stopY = getRoundY(with/2,with/2,with/2-12,stopTime);

    }


    /**
     * x0 y0 圆点坐标
     * r 半径
     * time 计算角度
     * */
    private double getRoundX(double x0,double y0,double r,double time){
        double z_angle = time * 360/24-90;
        double x = x0 + r * Math.cos(z_angle * 3.14/180);
        return x;
    }


    private double getRoundY(double x0,double y0,double r,double time){
        double z_angle = time * 360/24-90;
        double y = y0 + r * Math.sin(z_angle * 3.14 / 180);
        return y;
    }


    int startAngle=0;
    /**
     * 设置旋转起始角度
     * */
    public void setStartAngle(int startAngle){
        this.startAngle=startAngle;
    }

    /**开始角度*/
    private int getStartangle(int time){
        int start_Angle = 360 / 24 * time - 90;
        return start_Angle;
    }


    /**
     * 计算冲突时间
     *
     * @param start1     档期开始时间
     * @param stop1      档期结束时间
     * @param start2     任务开始时间
     * @param stop2      任务结束时间
     * @param type       标记类型 !=0 即可
     *
     */
    private int type=0;
    private int start1=0;
    private int start2=0;
    private int stop2=0;
    private int stop1=0;

    public void setConflictTime(int start1,int stop1,int start2,int stop2,int type){
        this.type=type;
        this.start1=start1;
        this.stop2=stop2;
        this.start2=start2;
        this.stop1=stop1;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(with, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Paint p = new Paint();
            p.setStrokeWidth((float) 2.0);
            p.setAntiAlias(true);// 设置画笔的锯齿效果

            p.setColor(color1);
            canvas.drawCircle(with/2, height/2, with/2, p);

            p.setColor(color2);
            canvas.drawCircle(with/2, height/2,with/2-5, p);


            p.setColor(color3);
            canvas.drawCircle(with/2, height/2, with/2-11, p);


            p.setColor(color4);
            canvas.drawCircle(with/2, height/2, with/2-12, p);


            if(0!=type){

                int z_angle = 360  / 24 * (stop2 - start1);

                p.setColor(Color.parseColor("#F8F8F8"));
                RectF oval2 = new RectF(12, 12, with-12, with-12);
                canvas.drawArc(oval2, getStartangle(start1), z_angle, true, p);


                p.setColor(Color.parseColor("#E8E8E8"));
                double startX = getRoundX(with/2,with/2,with/2-12,start1);
                double startY = getRoundY(with/2,with/2,with/2-12,start1);

                double stopX = getRoundX(with/2,with/2,with/2-12,stop2);
                double stopY = getRoundY(with/2,with/2,with/2-12,stop2);
                canvas.drawLine(with/2, height/2, (float) startX, (float)startY, p);//开始竖线
                canvas.drawLine(with/2, height/2, (float)stopX, (float)stopY, p);//结束竖线

//////////////////////////////////////
                int x_angle = 360 / 24 * (stop1 - start2);

                p.setColor(color6);
                RectF oval1 = new RectF(12, 12, with-12, with-12);
                canvas.drawArc(oval1, getStartangle(start2), x_angle, true, p);


                p.setColor(color5);
                double startX1 = getRoundX(with/2,with/2,with/2-12,start2);
                double startY1 = getRoundY(with/2,with/2,with/2-12,start2);

                double stopX2 = getRoundX(with/2,with/2,with/2-12,stop1);
                double stopY2 = getRoundY(with/2,with/2,with/2-12,stop1);
                canvas.drawLine(with/2, height/2, (float) startX1, (float)startY1, p);//开始竖线
                canvas.drawLine(with/2, height/2, (float)stopX2, (float)stopY2, p);//结束竖线


            }else{
                p.setColor(color6);
                RectF oval2 = new RectF(12, 12, with-12, with-12);
                canvas.drawArc(oval2, getStartangle((int)startTime), angle, true, p);

                p.setColor(color5);
                double stopX = getRoundX(with/2,with/2,with/2-12,stopTime);
                double stopY = getRoundY(with/2,with/2,with/2-12,stopTime);
                canvas.drawLine(with/2, height/2, (float) stopX, (float)stopY, p);//结束竖线
                canvas.drawLine(with/2, height/2, (float) startX, (float)startY, p);//开始竖线
            }

        }catch (Exception p){
            p.printStackTrace();
        }
    }


    /**扇形动画*/
    public class task extends AsyncTask<Void, Float, Void> {

        private Handler handler;
        private double a=0;//旋转度数
        private double b=0;

        public task(Handler handler){
            this.handler=handler;
            if(startTime!=24){
                double num = stopTime - startTime;
                a=360*num/24;
            }else {
                a=360/24*stopTime;
            }
            b=stopTime;
        }


        @Override
        protected Void doInBackground(Void... params) {
            for(int i=1;i<=a;i++){
                try {
                    angle=i;
                    stopTime=startTime+((double)24)/360*i;
                    handler.sendEmptyMessage(1);
                    Thread.sleep((long) (1000/a));
                }catch (Exception p){
                    p.printStackTrace();
                }
            }
            return null;
        }
    }

    public void start(){
        new task(handler).execute();
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
        }
    };
}
