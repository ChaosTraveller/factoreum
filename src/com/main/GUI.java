package com.main;

import java.awt.*;

public class GUI {

    private static int maxPower;
    private static int powerUsage;
    private static int units;
    private static int coal = 200;
    private static int titanium;
    private static int crystals;
    private static int uranium = 70;
    private static int coolingPower;
    private static int heatingPower;
    public Color c1 = new Color(0, 14, 33);
    public Color c2 = new Color(255, 172, 23);
    public Color c3 = new Color(255, 188, 91);

    public void tick(){

    }

    public void render(Graphics gr) {

        gr.setColor(c1);
        gr.fillRect(0, 0, 960, 40);
        gr.fillRect(10, 50, 630, 630);
        gr.fillRect(650, 50, 295, 630);
        gr.setColor(Color.black);
        gr.fillRect(660, 60, 275, 610);
        gr.setColor(c3);
        int spx=0, spy=0;
        for (int i=0; i<6; i++) {
            for (int j=0; j<6; j++) {
                gr.drawRect(10 + (j * 100) + spx,50 + (i * 100) + spy,100,100);
                spx += 5;
            }
            spx = 0;
            spy += 5;
        }


        gr.setColor(c2);
        gr.drawString("Power: " + (maxPower - powerUsage), 5, 20);
        gr.drawString("Units: " + units, 100, 20 );
        gr.drawString("Coal: " + coal, 200, 20);
        gr.drawString("Titanium: " + titanium, 300, 20);
        gr.drawString("Crystals: " + crystals, 400, 20);
        gr.drawString("Uranium: " + uranium, 500, 20);
        gr.drawString("Heating: " + heatingPower, 600, 20);
        gr.drawString("Cooling: " + coolingPower, 700, 20);
    }

    public static int getMaxPower() { return maxPower; }
    public static void setMaxPower(int maxPower) { GUI.maxPower = maxPower; }
    public static int getPowerUsage() { return powerUsage; }
    public static void setPowerUsage(int powerUsage) { GUI.powerUsage = powerUsage; }
    public static int getUnits() { return units; }
    public static void setUnits(int units) { GUI.units = units; }
    public static int getCoal() { return coal; }
    public static void setCoal(int coal) { GUI.coal = coal; }
    public static int getTitanium() { return titanium; }
    public static void setTitanium(int titanium) { GUI.titanium = titanium; }
    public static int getCrystals() { return crystals; }
    public static void setCrystals(int crystals) { GUI.crystals = crystals; }
    public static int getUranium() { return uranium; }
    public static void setUranium(int uranium) { GUI.uranium = uranium; }
    public static int getCoolingPower() { return coolingPower; }
    public static void setCoolingPower(int coolingPower) { GUI.coolingPower = coolingPower; }
    public static int getHeatingPower() { return heatingPower; }
    public static void setHeatingPower(int heatingPower) { GUI.heatingPower = heatingPower;}
}
