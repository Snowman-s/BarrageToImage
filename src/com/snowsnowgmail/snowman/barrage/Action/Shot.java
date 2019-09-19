package com.snowsnowgmail.snowman.barrage.Action;

import com.snowsnowgmail.snowman.barrage.Bullet;
import com.snowsnowgmail.snowman.barrage.PointD;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class Shot extends Action {
    private Color color;
    private float speed;
    private float angle;

    public Shot(Color color, float speed, float angle) {
        this.color = color;
        this.speed = speed;
        this.angle = angle;
    }

    @Override
    public List<Bullet> taskBody(int frame, Object[] objects) {
        return Collections.singletonList(new Bullet(color, (PointD) objects[0], speed, angle, frame));
    }
}
