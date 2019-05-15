package factoreum;

import java.awt.*;

public class GUI implements IGuiRaw, IGuiItems {

    private  int maxPower = 0;
    private  int powerUsage = 0;
    private  int units = 0;
    private  int coal = 0;
    private  int titanium = 0;
    private  int crystals = 0;
    private  int uranium = 0;
    private  int coolingPower = 0;
    private  int heatingPower = 0;

    private  int graphite = 0;
    private  int graphiteRod = 0;
    private  int controlRod = 0;
    private  int titaniumPlate = 0;
    private  int fuelRod = 0;
    private  int advancedFuelRod = 0;
    private  int electronicParts = 0;
    private  int powerTransmiter = 0;
    private  int pureCrystal = 0;
    private  int reinforcedTiPlate = 0;
    private  int electronicCircute = 0;

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

    public int getMaxPower() { return maxPower; }
    public void setMaxPower(int maxPower) { this.maxPower = maxPower; }
    public int getPowerUsage() { return powerUsage; }
    public void setPowerUsage(int powerUsage) { this.powerUsage = powerUsage; }
    public int getUnits() { return units; }
    public void setUnits(int units) { this.units = units; }
    public int getCoal() { return coal; }
    public void setCoal(int coal) { this.coal = coal; }
    public int getTitanium() { return titanium; }
    public void setTitanium(int titanium) { this.titanium = titanium; }
    public int getCrystals() { return crystals; }
    public void setCrystals(int crystals) { this.crystals = crystals; }
    public int getUranium() { return uranium; }
    public void setUranium(int uranium) { this.uranium = uranium; }
    public int getCoolingPower() { return coolingPower; }
    public void setCoolingPower(int coolingPower) { this.coolingPower = coolingPower; }
    public int getHeatingPower() { return heatingPower; }
    public void setHeatingPower(int heatingPower) { this.heatingPower = heatingPower;}

    public int getGraphite() { return graphite; }
    public void setGraphite(int graphite) { this.graphite = graphite; }
    public int getGraphiteRod() { return graphiteRod; }
    public void setGraphiteRod(int graphiteRod) { this.graphiteRod = graphiteRod; }
    public int getControlRod() { return controlRod; }
    public void setControlRod(int controlRod) { this.controlRod = controlRod; }
    public int getTitaniumPlate() { return titaniumPlate; }
    public void setTitaniumPlate(int titaniumPlate) { this.titaniumPlate = titaniumPlate; }
    public int getFuelRod() { return fuelRod; }
    public void setFuelRod(int fuelRod) { this.fuelRod = fuelRod; }
    public int getAdvancedFuelRod() { return advancedFuelRod; }
    public void setAdvancedFuelRod(int advancedFuelRod) { this.advancedFuelRod = advancedFuelRod; }
    public int getElectronicParts() { return electronicParts; }
    public void setElectronicParts(int electronicParts) { this.electronicParts = electronicParts; }
    public int getPowerTransmiter() { return powerTransmiter; }
    public void setPowerTransmiter(int powerTransmiter) { this.powerTransmiter = powerTransmiter; }
    public int getPureCrystal() { return pureCrystal; }
    public void setPureCrystal(int pureCrystal) { this.pureCrystal = pureCrystal; }
    public int getReinforcedTiPlate() { return reinforcedTiPlate; }
    public void setReinforcedTiPlate(int reinforcedTiPlate) { this.reinforcedTiPlate = reinforcedTiPlate; }
    public int getElectronicCircute() { return electronicCircute; }
    public void setElectronicCircute(int electronicCircute) { this.electronicCircute = electronicCircute; }
}
