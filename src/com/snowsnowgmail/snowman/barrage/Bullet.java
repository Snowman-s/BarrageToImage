package com.snowsnowgmail.snowman.barrage;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class Bullet {
    public Color color;

    public Bullet(Color color, PointD location, float speed, float angle) {
        this.color = color;
        this.location = new PointD(location);
        this.speed = speed;
        this.angle = angle;
    }

    public PointD location;
    public float speed;
    public float angle;

    public void move(int frame) {
        double rad = Math.toRadians(angle);
        double dx = Math.cos(rad) * speed * frame, dy = Math.sin(rad) * speed * frame;
        this.location.x += dx;
        this.location.y += dy;
    }

    public static List<Bullet> allWay(PointD location, int number, float speed, Color color) {
        List<Bullet> bullets = new LinkedList<>();
        for (float i = 0; i < 360F; i += 360F / number) {
            bullets.add(new Bullet(color, location, speed, i));
        }
        return bullets;
    }
}
