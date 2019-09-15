package com.snowsnowgmail.snowman.barrage;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class Bullet {
    public Color color;

    public Bullet(Color color, Point2D.Float location, float speed, float angle) {
        this.color = color;
        this.location = location;
        this.speed = speed;
        this.angle = angle;
    }

    public Point2D.Float location;
    public float speed;
    public float angle;

    public void move() {
        location.x += Math.cos(Math.toRadians(angle)) * speed;
        location.y += Math.sin(Math.toRadians(angle)) * speed;
    }

    public static List<Bullet> allWay(Point2D.Float location, int number, float speed, Color color) {
        List<Bullet> bullets = new LinkedList<>();
        for (float i = 0; i < 360F; i += 360F / number) {
            bullets.add(new Bullet(color, location, speed, i));
        }
        return bullets;
    }
}
