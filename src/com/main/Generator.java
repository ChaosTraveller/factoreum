package com.main;

import java.awt.*;

public abstract class Generator extends Machine {


    public Generator(int x, int y, int temperature, int lvl, ID id) {
        super(x, y, temperature, lvl, id);
    }


    public abstract void tick();
    public abstract void render(Graphics gr);

}
