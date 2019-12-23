package com.xiangxue.alvin.flowlayout;

/**
 * author : zhiwen.yang
 * date   : 2019/12/18
 * desc   : 粒子封装对象
 */
public class Ball {
    private int color;//粒子颜色
    private float x;//粒子圆心坐标 x
    private float y;//粒子圆心坐标 y
    private float r;//粒子半径

    private float vX;//水平方向的速度
    private float vY;//竖直方向的速度
    private float aX;//水平方向的加速度
    private float aY;//竖直方向的加速度

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getvX() {
        return vX;
    }

    public void setvX(float vX) {
        this.vX = vX;
    }

    public float getvY() {
        return vY;
    }

    public void setvY(float vY) {
        this.vY = vY;
    }

    public float getaX() {
        return aX;
    }

    public void setaX(float aX) {
        this.aX = aX;
    }

    public float getaY() {
        return aY;
    }

    public void setaY(float aY) {
        this.aY = aY;
    }
}
