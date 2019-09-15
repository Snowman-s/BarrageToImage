package com.snowsnowgmail.snowman.barrage;

import java.awt.image.BufferedImage;
import java.util.List;

public final class BarrageImageCreater {
    public static BufferedImage imageCreate(int size, List<Bullet> bullets) {
        BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        for (Bullet bullet : bullets) {
            bufferedImage.setRGB((int) bullet.location.x, (int) bullet.location.y, bullet.color.getRGB());
        }
        return bufferedImage;
    }
}
