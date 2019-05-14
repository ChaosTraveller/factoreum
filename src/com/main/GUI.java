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

    private static int graphite;
    private static int graphiteRod;
    private static int controlRod;
    private static int titaniumPlate;
    private static int fuelRod;
    private static int advancedFuelRod;
    private static int electronicParts;
    private static int powerTransmiter;
    private static int pureCrystal;
    private static int reinforcedTiPlate;
    private static int electronicCircute;

    public Color c1 = new Color(0, 14, 33);
    public Color c2 = new Color(255, 172, 23);
    public Color c3 = new Color(255, 188, 91);

    public enum OVERLAP {
        Menu,
        Items,
        Crafting,
        Store
    }

    public OVERLAP overlap = OVERLAP.Menu;

    public void tick(){

    }

    public void render(Graphics gr) {

        gr.setColor(c1);
        gr.fillRect(0, 0, 960, 40);
        gr.fillRect(10, 50, 630, 630);
        gr.fillRect(650, 50, 295, 630);
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
        gr.setColor(Color.black);
        gr.fillRect(660, 60, 275, 610);
        gr.setColor(Color.white);
        gr. drawRect(880, 0, 70, 35);
        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr. drawString("Menu", 890, 25);
        gr.drawRect(665, 65, 81, 35);
        gr.drawString("Storage", 670, 90);
        gr.drawRect(756, 65, 81, 35);
        gr.drawString("Crafting", 761, 90);
        gr.drawRect(847, 65, 81, 35);
        gr.drawString("Store", 862, 90);

        if (overlap == OVERLAP.Items) {
            gr.setColor(c2);
            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.drawString("Graphite: " + graphite,                          665, 130);
            gr.drawString("Graphite rods: " + graphiteRod,                  665, 155);
            gr.drawString("Controm Rods: " + controlRod,                    665, 180);
            gr.drawString("Titanium plates: " + titaniumPlate,              665, 205);
            gr.drawString("Fuel rods: " + fuelRod,                          665, 230);
            gr.drawString("Advanced fuel rods: " + advancedFuelRod,         665, 255);
            gr.drawString("Electronic parts: " + electronicParts,           665, 280);
            gr.drawString("Power transmiters: " + powerTransmiter,          665, 305);
            gr.drawString("Pure crystals: " + pureCrystal,                  665, 330);
            gr.drawString("Reinforced ti. plates: " + reinforcedTiPlate,    665, 355);
            gr.drawString("Electronic circutes: " + electronicCircute,      665, 380);
        } else if (overlap == OVERLAP.Crafting) {

        } else if (overlap == OVERLAP.Store) {
            gr.setColor(c2);
            gr.setFont(new Font("arial", Font.PLAIN, 18));
            gr.drawString("Graphite: " + graphite,                          665, 130);
            gr.drawRect(                                                        665, 138, 265, 20);
            gr.drawString("Graphite rods: " + graphiteRod,                  665, 180);
            gr.drawRect(                                                        665, 188, 265, 20);
            gr.drawString("Controm Rods: " + controlRod,                    665, 230);
            gr.drawRect(                                                        665, 238, 265, 20);
            gr.drawString("Titanium plates: " + titaniumPlate,              665, 280);
            gr.drawRect(                                                        665, 288, 265, 20);
            gr.drawString("Fuel rods: " + fuelRod,                          665, 330);
            gr.drawRect(                                                        665, 338, 265, 20);
            gr.drawString("Advanced fuel rods: " + advancedFuelRod,         665, 380);
            gr.drawRect(                                                        665, 388, 265, 20);
            gr.drawString("Electronic parts: " + electronicParts,           665, 430);
            gr.drawRect(                                                        665, 438, 265, 20);
            gr.drawString("Power transmiters: " + powerTransmiter,          665, 480);
            gr.drawRect(                                                        665, 488, 265, 20);
            gr.drawString("Pure crystals: " + pureCrystal,                  665, 530);
            gr.drawRect(                                                        665, 538, 265, 20);
            gr.drawString("Reinforced ti. plates: " + reinforcedTiPlate,    665, 580);
            gr.drawRect(                                                        665, 588, 265, 20);
            gr.drawString("Electronic circutes: " + electronicCircute,      665, 630);
            gr.drawRect(                                                        665, 638, 265, 20);
        } else if (overlap == OVERLAP.Menu) {
            gr.setColor(Color.white);
            gr.drawString("Save game",                                      670, 155);
            gr.drawRect(                                                        665, 130, 265, 35);
            gr.drawString("Load game",                                      670, 205);
            gr.drawRect(                                                        665, 180, 265, 35);
            gr.drawString("Exit" ,                                          670, 255);
            gr.drawRect(                                                        665, 230, 265, 35);
        }



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

    public static int getGraphite() { return graphite; }
    public static void setGraphite(int graphite) { GUI.graphite = graphite; }
    public static int getGraphiteRod() { return graphiteRod; }
    public static void setGraphiteRod(int graphiteRod) { GUI.graphiteRod = graphiteRod; }
    public static int getControlRod() { return controlRod; }
    public static void setControlRod(int controlRod) { GUI.controlRod = controlRod; }
    public static int getTitaniumPlate() { return titaniumPlate; }
    public static void setTitaniumPlate(int titaniumPlate) { GUI.titaniumPlate = titaniumPlate; }
    public static int getFuelRod() { return fuelRod; }
    public static void setFuelRod(int fuelRod) { GUI.fuelRod = fuelRod; }
    public static int getAdvancedFuelRod() { return advancedFuelRod; }
    public static void setAdvancedFuelRod(int advancedFuelRod) { GUI.advancedFuelRod = advancedFuelRod; }
    public static int getElectronicParts() { return electronicParts; }
    public static void setElectronicParts(int electronicParts) { GUI.electronicParts = electronicParts; }
    public static int getPowerTransmiter() { return powerTransmiter; }
    public static void setPowerTransmiter(int powerTransmiter) { GUI.powerTransmiter = powerTransmiter; }
    public static int getPureCrystal() { return pureCrystal; }
    public static void setPureCrystal(int pureCrystal) { GUI.pureCrystal = pureCrystal; }
    public static int getReinforcedTiPlate() { return reinforcedTiPlate; }
    public static void setReinforcedTiPlate(int reinforcedTiPlate) { GUI.reinforcedTiPlate = reinforcedTiPlate; }
    public static int getElectronicCircute() { return electronicCircute; }
    public static void setElectronicCircute(int electronicCircute) { GUI.electronicCircute = electronicCircute; }
}
