package com.main;

import java.awt.*;
import java.util.*;

public class Miner extends Machine {

    private int ore = 0;
    Random r = new Random();
    private boolean p = false;
    private int lastLvl = lvl;
    private int time = 0;
    private String oreName = "";
    private int powerU = 0;


    public Miner(int x, int y, int temperature, int lvl, ID id) {
        super(x, y, temperature, lvl, id);
    }

    private int n = r.nextInt(100) + 1;
    private void ore(int i) {

        if (i <= 50) {
            ore = 1;
            oreName = "Coal";
        } else if (i > 50 && i <= 80) {
            ore = 2;
            oreName = "Titanium";
        } else if (i > 80 && i <= 95) {
            ore = 3;
            oreName = "Crystals";
        } else {
            ore = 4;
            oreName = "Uranium";
        }

    }

    public void tick() {
        if (ore == 0){
            ore(n);
        }
        powerU = Math.round((float)Math.pow(2, (float)(lvl/2)));

        if(p != true) {
            GUI.setPowerUsage(GUI.getPowerUsage() + powerU);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            GUI.setPowerUsage(GUI.getPowerUsage() - Math.round((float)Math.pow(2, (float)(lastLvl/2))));
            p = false;
            lastLvl = lvl;
        }

        if (GUI.getMaxPower() >= GUI.getPowerUsage() && time == 0) {
            switch (ore) {
                case 1: {
                    GUI.setCoal(GUI.getCoal() + lvl);
                    time = 50;
                    break;
                }
                case 2: {
                    GUI.setTitanium(GUI.getTitanium() + lvl);
                    time = 60;
                    break;
                }
                case 3: {
                    GUI.setCrystals(GUI.getCrystals() + lvl);
                    time = 80;
                    break;
                }
                case 4: {
                    GUI.setUranium(GUI.getUranium() + lvl);
                    time = 100;
                    break;
                }
            }
        } else time--;
    }

    private Color sol = new Color(117, 112, 148);
    public void render(Graphics gr) {

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Miner", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x +3, y +25);
        gr.drawString(oreName, x+3, y+40);
        gr.drawString("Power: -" + powerU, x+3, y+53);
        gr.drawString("Temp: " + temperature, x+3, y+68);
    }
}
