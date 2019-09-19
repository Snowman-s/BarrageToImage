package com.snowsnowgmail.snowman.barrage.Action;

import com.snowsnowgmail.snowman.barrage.Bullet;
import com.snowsnowgmail.snowman.barrage.BulletManager;
import com.snowsnowgmail.snowman.barrage.PointD;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//allway <framen> <color> <speed> <way> <startangle>

public class AllWay extends Action {
    private Color color;
    private float speed;
    private int way;
    private float startangle;

    public AllWay(Color color, float speed, int way, float startangle) {
        this.color = color;
        this.speed = speed;
        this.way = way;
        this.startangle = startangle;
    }

    @Override
    public List<Bullet> taskBody(int frame, Object[] objects) {
        return BulletManager.allWay(frame, (PointD) objects[0], way, speed, color, startangle);
    }

    public AllWay clone() {
        AllWay copy = (AllWay) super.clone();
        copy.color = this.color;
        copy.speed = this.speed;
        copy.way = this.way;
        copy.startangle = this.startangle;
        return copy;
    }
}
