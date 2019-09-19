package com.snowsnowgmail.snowman.barrage;

import java.awt.*;

public class Bullet {
    public Color color;

    public Bullet(Color color, PointD location, float speed, float angle, int createdFrame) {
        this.color = color;
        this.location = new PointD(location);
        this.speed = speed;
        this.angle = angle;
        this.createdFrame = createdFrame;
    }

    public PointD location;
    public float speed;
    public float angle;
    public int createdFrame = -1;

    public void move(int frame) {
        double rad = Math.toRadians(angle);
        double dx = Math.cos(rad) * speed * frame, dy = Math.sin(rad) * speed * frame;
        this.location.x += dx;
        this.location.y += dy;
    }
}
