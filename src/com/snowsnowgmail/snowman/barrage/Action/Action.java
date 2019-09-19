package com.snowsnowgmail.snowman.barrage.Action;

import com.snowsnowgmail.snowman.barrage.Bullet;
import com.snowsnowgmail.snowman.barrage.PointD;

import java.util.ArrayList;
import java.util.List;

public abstract class Action implements Cloneable {
    public int frame;
    public boolean retryByframe = false;

    //1:enemy.location
    public final List<Bullet> doTask(Object[] objects) {
        assert objects[0] instanceof PointD;
        List<Bullet> bullets = new ArrayList<>();
        if (retryByframe) {
            List<Bullet> returns = taskBody(frame, objects);
            if (returns != null) {
                bullets.addAll(returns);
            }
        } else {
            List<Bullet> returns = taskBody(frame, objects);
            if (returns != null) {
                bullets.addAll(returns);
            }
        }
        return bullets;
    }

    public abstract List<Bullet> taskBody(int frame, Object[] objects);

    public Action clone() {
        Action copy;
        try {
            copy = (Action) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.getMessage());
        }
        copy.retryByframe = this.retryByframe;
        copy.frame = this.frame;
        return copy;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[frame:" + frame + "]";
    }
}
