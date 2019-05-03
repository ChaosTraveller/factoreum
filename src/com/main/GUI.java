package com.main;

import java.awt.*;

public class GUI {

    public static int power;
    public static int units;
    public static int coal;
    public static int titanium;
    public static int crystals;
    public static int uranium;
    public static int coolingPower;
    public static int heatingPower;

    public void tick(){

    }

    public void render(Graphics gr) {

        gr.setColor(Color.gray);
        gr.fillRect(0, 0, 960, 40);

        gr.drawString("Power: " + power, 5, 5);

    }
}
