package factoreum;

import java.awt.*;

public abstract class Machine implements IMachine{

    protected int x, y;
    protected int temperature;
    protected int lvl;
    protected TYPE type;
    protected IStorageRaw IGuiRaw = Storage.getInstance();
    protected int id;
    protected boolean state;

    public Machine(int x, int y, int temperature, int lvl, TYPE type, int id, boolean state) {
        this.x = x;
        this.y = y;
        this.temperature = temperature;
        this.lvl = lvl;
        this.type = type;
        this.id = id;
        this.state = state;
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
    public void setType(TYPE id) {
        this.type = type;
    }
    public TYPE getType() {
        return type;
    }
    public void setX(int x) {this.x = x; }
    public int getX() { return x; }
    public void setY(int y) { this.y = y; }
    public int getY() { return y; }
    public void setId(int id) {this.id = id; }
    public int getId() { return id;
    }
}
