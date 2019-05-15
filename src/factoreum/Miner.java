package factoreum;

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
    private IGuiRaw IGuiRaw = new GUI();


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
        powerU = 2*lvl /*Math.round((float)(Math.pow(2, lvl/2)))*/;

        if(p != true) {
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() + powerU);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() - Math.round((float)Math.pow(2, (float)(lastLvl/2))));
            p = false;
            lastLvl = lvl;
        }

        if (IGuiRaw.getMaxPower() >= IGuiRaw.getPowerUsage() && time == 0) {
            switch (ore) {
                case 1: {
                    IGuiRaw.setCoal(IGuiRaw.getCoal() + lvl);
                    time = 50;
                    break;
                }
                case 2: {
                    IGuiRaw.setTitanium(IGuiRaw.getTitanium() + lvl);
                    time = 60;
                    break;
                }
                case 3: {
                    IGuiRaw.setCrystals(IGuiRaw.getCrystals() + lvl);
                    time = 80;
                    break;
                }
                case 4: {
                    IGuiRaw.setUranium(IGuiRaw.getUranium() + lvl);
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

//    public int getMaxPower() { return maxPower; }
//    public void setMaxPower(int maxPower) { this.maxPower = maxPower; }
//    public int getPowerUsage() { return powerUsage; }
//    public void setPowerUsage(int powerUsage) { this.powerUsage = powerUsage; }
//    public int getUnits() { return units; }
//    public void setUnits(int units) { this.units = units; }
//    public int getCoal() { return coal; }
//    public void setCoal(int coal) { this.coal = coal; }
//    public int getTitanium() { return titanium; }
//    public void setTitanium(int titanium) { this.titanium = titanium; }
//    public int getCrystals() { return crystals; }
//    public void setCrystals(int crystals) { this.crystals = crystals; }
//    public int getUranium() { return uranium; }
//    public void setUranium(int uranium) { this.uranium = uranium; }
//    public int getCoolingPower() { return coolingPower; }
//    public void setCoolingPower(int coolingPower) { this.coolingPower = coolingPower; }
//    public int getHeatingPower() { return heatingPower; }
//    public void setHeatingPower(int heatingPower) { this.heatingPower = heatingPower;}
//
//    public int getGraphite() { return graphite; }
//    public void setGraphite(int graphite) { this.graphite = graphite; }
//    public int getGraphiteRod() { return graphiteRod; }
//    public void setGraphiteRod(int graphiteRod) { this.graphiteRod = graphiteRod; }
//    public int getControlRod() { return controlRod; }
//    public void setControlRod(int controlRod) { this.controlRod = controlRod; }
//    public int getTitaniumPlate() { return titaniumPlate; }
//    public void setTitaniumPlate(int titaniumPlate) { this.titaniumPlate = titaniumPlate; }
//    public int getFuelRod() { return fuelRod; }
//    public void setFuelRod(int fuelRod) { this.fuelRod = fuelRod; }
//    public int getAdvancedFuelRod() { return advancedFuelRod; }
//    public void setAdvancedFuelRod(int advancedFuelRod) { this.advancedFuelRod = advancedFuelRod; }
//    public int getElectronicParts() { return electronicParts; }
//    public void setElectronicParts(int electronicParts) { this.electronicParts = electronicParts; }
//    public int getPowerTransmiter() { return powerTransmiter; }
//    public void setPowerTransmiter(int powerTransmiter) { this.powerTransmiter = powerTransmiter; }
//    public int getPureCrystal() { return pureCrystal; }
//    public void setPureCrystal(int pureCrystal) { this.pureCrystal = pureCrystal; }
//    public int getReinforcedTiPlate() { return reinforcedTiPlate; }
//    public void setReinforcedTiPlate(int reinforcedTiPlate) { this.reinforcedTiPlate = reinforcedTiPlate; }
//    public int getElectronicCircute() { return electronicCircute; }
//    public void setElectronicCircute(int electronicCircute) { this.electronicCircute = electronicCircute; }
}
