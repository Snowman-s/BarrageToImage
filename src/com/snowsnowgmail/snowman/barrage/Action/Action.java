package com.snowsnowgmail.snowman.barrage.Action;

import com.snowsnowgmail.snowman.barrage.Bullet;
import com.snowsnowgmail.snowman.barrage.PointD;

import java.util.ArrayList;
import java.util.List;

public abstract class Action {
    public int frame;
    public boolean retryByframe = false;
    private int taskCalledCount = 0;

    //1:enemy.location
    public final List<Bullet> doTask(Object[] objects) {
        assert objects[0] instanceof PointD;
        List<Bullet> bullets = new ArrayList<>();
        if (retryByframe) {
            if (taskCalledCount % frame == 0) {
                List<Bullet> returns = taskBody(objects);
                if(returns != null) {
                    bullets.addAll(returns);
                }
            }
        } else {
            if (taskCalledCount == frame) {
                List<Bullet> returns = taskBody(objects);
                if(returns != null) {
                    bullets.addAll(returns);
                }
            }
        }
        taskCalledCount++;
        return bullets;
    }

    public abstract List<Bullet> taskBody(Object[] objects);
}
