package com.snowsnowgmail.snowman.barrage.Action;

import com.snowsnowgmail.snowman.barrage.Bullet;

import java.util.List;

public class PhotoTake extends Action {
    private int photoFrame;

    public PhotoTake(int photoFrame) {
        frame = 0;
        this.photoFrame = photoFrame;
    }

    @Override
    public List<Bullet> taskBody(int frame, Object[] objects) {
        objects[1] = photoFrame;
        return null;
    }
}
