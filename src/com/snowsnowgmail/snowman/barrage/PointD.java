package com.snowsnowgmail.snowman.barrage;

public class PointD {
    public double x, y;

    public PointD(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public PointD(PointD p) {
        this.x = p.x;
        this.y = p.y;
    }

    @Override
    public String toString() {
        return "PointD[x:" + x + ",y:" + y + "]";
    }
}