package com.main;

import java.awt.*;



public class Solar extends Generator{


    public Solar(int x, int y, int temperature, int lvl, ID id){
        super(x, y, temperature, lvl, id);
    }
    private int lastLvl = lvl;
    private  boolean p = false;


    public void tick() {

        if(p != true) {
            GUI.setMaxPower(GUI.getMaxPower() + Math.round((float)lvl*lvl/2));
            p = true;
        } else if(p == true && lastLvl != lvl) {
            GUI.setMaxPower(GUI.getMaxPower() - Math.round((float)lastLvl*lastLvl/2));
            p = false;
            lastLvl = lvl;
        }


    }
    private Color sol = new Color(255, 242, 159);
    public void render(Graphics gr) {

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Solar generator", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 15));
        gr.drawString("lvl: " + lvl, x +10, y +30);

    }
}
