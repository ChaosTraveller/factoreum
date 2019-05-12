package com.main;

import java.awt.*;

public class NuclearGen extends Machine {

    public NuclearGen(int x, int y, int temperature, int lvl, ID id) {
        super(x, y, temperature, lvl, id);
    }
    private int lastLvl = lvl;
    private boolean p = false;
    private int fuelReq = 10*lvl;
    private int fuelTime = 0;
    private int power = 0;

    public void tick() {
        if (GUI.getUranium()>= fuelReq && p == true){
            if(fuelTime == 0) {
                GUI.setUranium(GUI.getUranium()-fuelReq);
                fuelTime = 500;
            } else fuelTime--;
        } else if (GUI.getUranium() < fuelReq && p == true){
            if (fuelTime == 0){
                GUI.setMaxPower(GUI.getMaxPower() - (lastLvl*lastLvl*lastLvl));
                p = false;
            }
            fuelTime--;
        }
        if(p != true && GUI.getUranium()>= fuelReq) {
            power = (lvl*lvl*lvl);
            GUI.setMaxPower(GUI.getMaxPower() + power);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            GUI.setMaxPower(GUI.getMaxPower() - (lastLvl*lastLvl*lastLvl));
            p = false;
            lastLvl = lvl;
        }
    }

    private Color sol = new Color(66, 101, 89);

    public void render(Graphics gr) {

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Nuclear gen.", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 15));
        gr.drawString("lvl: " + lvl, x +3, y +30);
        gr.drawString("Power: " +power, x+3, y+50);
    }
}
