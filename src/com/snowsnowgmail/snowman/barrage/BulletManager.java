package com.snowsnowgmail.snowman.barrage;

import com.snowsnowgmail.snowman.barrage.Action.Action;
import com.snowsnowgmail.snowman.barrage.Action.AllWay;
import com.snowsnowgmail.snowman.barrage.Action.EnemyMove;
import com.snowsnowgmail.snowman.barrage.Action.PhotoTake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public final class BulletManager {
    private BulletManager() {
    }

    public static List<Bullet> allWay(PointD location, int number, float speed, Color color, float start) {
        List<Bullet> bullets = new LinkedList<>();
        for (float i = start; i < 360F + start; i += 360F / number) {
            bullets.add(new Bullet(color, location, speed, i));
        }
        return bullets;
    }

    public static Color getColor(String head) {
        head = head.toUpperCase();
        switch (head) {
            case "W":
                return Color.WHITE;
            case "R":
                return Color.RED;
            case "G":
                return Color.GREEN;
            case "B":
                return Color.BLUE;
            case "Y":
                return Color.YELLOW;
            case "P":
                return Color.MAGENTA;
            case "C":
                return Color.CYAN;
            default: //今はWhiteですが代替手段を考えます。
                return Color.WHITE;
        }
    }

    public static List<Action> codeRead(List<String> code) throws IllegalArgumentException {
        List<Action> actions = new LinkedList<>();
        for (int i = 0; i < code.size(); i++) {
            String article = code.get(i);
            if (article.isBlank()) {
                continue;
            }
            String[] words = article.split(" ");
            try {
                if (i == 0) {
                    if (words.length > 0 && words[0].equals("#barragephoto")) {
                        actions.add(new PhotoTake(Integer.parseInt(words[1])));
                    } else {
                        throw new IllegalArgumentException("#barragephotoから開始してください。");
                    }
                }
                switch (words[0]) {
                    case "enemyset": {
                        Action action = new EnemyMove(Float.parseFloat(words[2]), Float.parseFloat(words[3]));
                        action.frame = Integer.parseInt(words[1]);
                        actions.add(action);
                        break;
                    }
                    case "allway": {
                        Action action = new AllWay(getColor(words[2]), Float.parseFloat(words[3]),
                                Integer.parseInt(words[4]), Float.parseFloat(words[5]));
                        action.frame = Integer.parseInt(words[1]);
                        actions.add(action);
                        break;
                    }
                    case "copy": {
                        Action action = actions.get(actions.size() - 1).clone();
                        action.frame = Integer.parseInt(words[1]);
                        actions.add(action);
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException(words[0] + "の引数が足りません。");
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(words[0] + "には数値の引数が必要です。");
            }
        }
        return actions;
    }
}
