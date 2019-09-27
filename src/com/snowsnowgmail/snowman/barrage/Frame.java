package com.snowsnowgmail.snowman.barrage;

public class Frame {
    public int frame = 0;
    public boolean replay = false;

    public void setInfo(String s) throws NumberFormatException {
        this.replay = s.endsWith("n");
        this.frame = Integer.parseInt(s.replace("n", ""));
    }

    public Frame() {
    }

    public Frame(Frame frame) {
        this.frame = frame.frame;
        this.replay = frame.replay;
    }
}
