package com.main;

import java.awt.*;

public abstract class Machine {

    protected int x, y;
    protected int temperature;
    protected int lvl;
    protected ID id;

    public Machine(int x, int y, int temperature, int lvl, ID id) {
        this.x = x;
        this.y = y;
        this.temperature = temperature;
        this.lvl = lvl;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics gr);


    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    public int getTemperature() { return temperature; }
    public int getLvl() {
        return lvl;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public ID getId() {
        return id;
    }
    public void setX(int x) {this.x = x; }
    public int getX() { return x; }
    public void setY(int y) { this.y = y; }
    public int getY() { return y; }
}
