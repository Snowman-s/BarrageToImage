package com.snowsnowgmail.snowman.barrage.Action;

import com.snowsnowgmail.snowman.barrage.Bullet;
import com.snowsnowgmail.snowman.barrage.PointD;

import java.util.List;

public class EnemyMove extends Action {
    public float x, y;

    public EnemyMove(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<Bullet> taskBody(Object[] objects) {
        ((PointD) objects[0]).x = this.x;
        ((PointD) objects[0]).y = this.y;
        return null;
    }

    public EnemyMove clone() {
        EnemyMove copy = (EnemyMove) super.clone();
        copy.x = this.x;
        copy.y = this.y;
        return copy;
    }
}
