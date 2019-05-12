package com.main;

import java.awt.*;

public class FuelGen extends Generator {

    public FuelGen(int x, int y, int temperature, int lvl, ID id) {
        super(x, y, temperature, lvl, id);
    }
    private int lastLvl = lvl;
    private boolean p = false;
    private int fuelReq = lvl;

    public void tick() {
        if (GUI.getCoal()>= fuelReq && p == true){
            GUI.setCoal(GUI.getCoal()-fuelReq);
        } else if (GUI.getCoal() < fuelReq && p == true){
            GUI.setMaxPower(GUI.getMaxPower() - (lastLvl*lastLvl));
            p = false;
        }
        if(p != true && GUI.getCoal()>= fuelReq) {
            GUI.setMaxPower(GUI.getMaxPower() + (lvl*lvl));
            p = true;
        } else if(p == true && lastLvl != lvl) {
            GUI.setMaxPower(GUI.getMaxPower() - (lastLvl*lastLvl));
            p = false;
            lastLvl = lvl;
        }
    }

    private Color sol = new Color(66, 78, 98);

    public void render(Graphics gr) {

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Fuel gen.", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 15));
        gr.drawString("lvl: " + lvl, x +10, y +30);


    }
}
