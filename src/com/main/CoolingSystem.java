package com.main;

import java.awt.*;

public class CoolingSystem extends Machine {

    public CoolingSystem(int x, int y, int temperature, int lvl, ID id) {
        super(x, y, temperature, lvl, id);
    }
    private int lastLvl = lvl;
    private  boolean p = false;
    private int power = 0;
    private int cPower = 0;


    public void tick(){



    }

    private Color sol = new Color(133, 188, 189);

    public void render(Graphics gr){

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Cooling sys.", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x +3, y +25);
        gr.drawString("Power: " + power, x+3, y+40);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("cooling: " + cPower, x+3, y+53);
        gr.drawString("Temp: " + temperature, x+3, y+68);

    }
}
