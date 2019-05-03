package com.main;

import java.awt.*;

public class Solar extends Generator{

    public int power = 0;
    long timer = System.currentTimeMillis();

    public Solar(int x, int y, int temperature, int lvl, ID id){
        super(x, y, temperature, lvl, id);
    }

    public void tick() {

        genPower();

    }

    public void render(Graphics gr) {

        gr.setColor(Color.red);
        gr.fillRect(x, y, 20, 20);

    }

    public int genPower() {

        power++;
        if (System.currentTimeMillis() - timer > 4000) {
            timer += 4000;
            System.out.println("Power: " + power);
        }
        return power;
    }
}
