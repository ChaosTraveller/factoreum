package com.main;

import java.awt.*;

public class FuelGen extends Machine {

    public FuelGen(int x, int y, int temperature, int lvl, ID id) {
        super(x, y, temperature, lvl, id);
    }
    private int lastLvl = lvl;
    private boolean p = false;
    private int fuelReq = lvl;
    private int time = 0;
    private int power = 0;

    public void tick() {
        if (GUI.getCoal()>= fuelReq && p == true && time == 0){
            GUI.setCoal(GUI.getCoal()-fuelReq);
            time = 50;
        } else if (GUI.getCoal() < fuelReq && p == true){
            GUI.setMaxPower(GUI.getMaxPower() - (lastLvl*lastLvl));
            p = false;
        } else if(p == true)time--;
        if(p != true && GUI.getCoal()>= fuelReq) {
            power = (lvl*lvl);
            GUI.setMaxPower(GUI.getMaxPower() + power);
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
        gr.drawString("lvl: " + lvl, x +3, y +30);
        gr.drawString("Power: " +power, x+3, y+50);

    }
}
