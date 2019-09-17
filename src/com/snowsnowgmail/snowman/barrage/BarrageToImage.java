package com.snowsnowgmail.snowman.barrage;

import com.snowsnowgmail.snowman.barrage.Action.Action;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BarrageToImage {
    public static int size = 2000;
    public static List<Bullet> bullets = new LinkedList<>();

    public static void main(String[] args) {
        List<Action> actions = BulletManager.codeRead(BarrageToImage.loadCode());
        PointD location = new PointD(size / 2F, size / 2F);
        //EnemyLocation, PhotoFrame;
        Object[] taskObjects = new Object[]{location, 1};

        for (int i = 0; i < (Integer) taskObjects[1]; i++) {
            for (Action action : actions) {
                bullets.addAll(action.doTask(taskObjects));
            }
            Iterator<Bullet> iterator = bullets.iterator();
            while (iterator.hasNext()) {
                Bullet bullet = iterator.next();
                bullet.move(1);
                double x = bullet.location.x, y = bullet.location.y;
                if (x < 0 || x > size - 1 || y < 0 || y > size - 1) {
                    iterator.remove();
                }
            }
        }

        BufferedImage bufferedImage = BarrageImageCreater.imageCreate(size, bullets);
        try {
            ImageIO.write(bufferedImage, "png", new File("output.jpg"));
        } catch (IOException e) {
            System.err.println("書き込みに失敗");
        }
    }

    public static List<String> loadCode() {
        try {
            Path p = Paths.get("code.txt");
            return Files.readAllLines(p);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
