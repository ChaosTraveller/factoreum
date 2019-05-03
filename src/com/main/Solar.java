package com.main;

import java.awt.*;

public class Solar extends Generator {

    public Solar(int x, int y, int temperature, int lvl, ID id){
        super(x, y, temperature, lvl, id);
    }

    public void tick() {


    }

    public void render(Graphics gr) {

        gr.setColor(Color.red);
        gr.fillRect(x, y, 20, 20);

    }

    public void genPower() {

    }
}
