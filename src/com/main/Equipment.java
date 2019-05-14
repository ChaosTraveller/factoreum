package com.main;

import java.awt.*;

public class Equipment {

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


    public void tick(){



    }

    private Color c1 = new Color(253, 193, 57);

    public void render(Graphics gr) {

        gr.setColor(Color.black);
        gr.fillRect(660, 60, 275, 610);
        gr.setColor(c1);
        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr.drawString("Graphite: " + graphite,                          665, 120);
        gr.drawString("Graphite rods: " + graphiteRod,                  665, 145);
        gr.drawString("Controm Rods: " + controlRod,                    665, 170);
        gr.drawString("Titanium plates: " + titaniumPlate,              665, 195);
        gr.drawString("Fuel rods: " + fuelRod,                          665, 220);
        gr.drawString("Advanced fuel rods: " + advancedFuelRod,         665, 245);
        gr.drawString("Electronic parts: " + electronicParts,           665, 270);
        gr.drawString("Power transmiters: " + powerTransmiter,          665, 295);
        gr.drawString("Pure crystals: " + pureCrystal,                  665, 320);
        gr.drawString("Reinforced ti. plates: " + reinforcedTiPlate,    665, 345);
        gr.drawString("Electronic circutes: " + electronicCircute,      665, 370);

    }

    public static int getGraphite() { return graphite; }
    public static void setGraphite(int graphite) { Equipment.graphite = graphite; }
    public static int getGraphiteRod() { return graphiteRod; }
    public static void setGraphiteRod(int graphiteRod) { Equipment.graphiteRod = graphiteRod; }
    public static int getControlRod() { return controlRod; }
    public static void setControlRod(int controlRod) { Equipment.controlRod = controlRod; }
    public static int getTitaniumPlate() { return titaniumPlate; }
    public static void setTitaniumPlate(int titaniumPlate) { Equipment.titaniumPlate = titaniumPlate; }
    public static int getFuelRod() { return fuelRod; }
    public static void setFuelRod(int fuelRod) { Equipment.fuelRod = fuelRod; }
    public static int getAdvancedFuelRod() { return advancedFuelRod; }
    public static void setAdvancedFuelRod(int advancedFuelRod) { Equipment.advancedFuelRod = advancedFuelRod; }
    public static int getElectronicParts() { return electronicParts; }
    public static void setElectronicParts(int electronicParts) { Equipment.electronicParts = electronicParts; }
    public static int getPowerTransmiter() { return powerTransmiter; }
    public static void setPowerTransmiter(int powerTransmiter) { Equipment.powerTransmiter = powerTransmiter; }
    public static int getPureCrystal() { return pureCrystal; }
    public static void setPureCrystal(int pureCrystal) { Equipment.pureCrystal = pureCrystal; }
    public static int getReinforcedTiPlate() { return reinforcedTiPlate; }
    public static void setReinforcedTiPlate(int reinforcedTiPlate) { Equipment.reinforcedTiPlate = reinforcedTiPlate; }
    public static int getElectronicCircute() { return electronicCircute; }
    public static void setElectronicCircute(int electronicCircute) { Equipment.electronicCircute = electronicCircute; }
}
