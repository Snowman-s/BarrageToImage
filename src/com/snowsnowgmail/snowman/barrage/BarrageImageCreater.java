package com.snowsnowgmail.snowman.barrage;

import java.awt.image.BufferedImage;
import java.util.List;

public final class BarrageImageCreater {
    public static BufferedImage imageCreate(int size, List<Bullet> bullets) {
        BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        for (Bullet bullet : bullets) {
            for (int i = -2; i <= 2; i++) {
                for (int i2 = -2; i2 <= 2; i2++) {
                    try {
                        bufferedImage.setRGB((int) bullet.location.x + i, (int) bullet.location.y + i2, bullet.color.getRGB());
                    }catch (ArrayIndexOutOfBoundsException e){
                        //何もしない
                    }
                }
            }
        }
        return bufferedImage;
    }
}
