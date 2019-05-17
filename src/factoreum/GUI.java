package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends MouseAdapter implements IGuiRaw, IGuiItems {

    private static GUI ourInstance = new GUI();

    private static GUI single_instance = null;

    public static GUI getInstance()
    {
        if (single_instance == null)
            single_instance = new GUI();

        return single_instance;
    }

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

    private int[] minX = {0, 0, 0, 0, 0, 0};
    private int[] minY = {0, 0, 0, 0, 0, 0};
    public int[][] boardField = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, };
    public int fx, fy;

    public enum OVERLAP {
        Menu,
        Items,
        Crafting,
        Store,
        Field,
        FieldEmpty;

    }
    private Handler handler = Handler.getInstance();

    public boolean menu, items, crafting, store, upgrade;

    public OVERLAP overlap = OVERLAP.Items;

    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mousePos(mx, my, 880, 0, 70, 35)) {
            overlap = OVERLAP.Menu;

        } else if (mousePos(mx, my, 665, 65, 81, 35)) {
            overlap = OVERLAP.Items;

        } else if (mousePos(mx, my, 756, 65, 81, 35)) {
            overlap = OVERLAP.Crafting;

        } else if (mousePos(mx, my, 847, 65, 81, 35)) {
            overlap = OVERLAP.Store;

        } else if (mousePos(mx, my, 10, 50, 630, 630)) {
            mouseBoardPos(mx, my);
        }


    }

    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    private boolean mousePos(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    private void mouseBoardPos(int mx, int my) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (mx > minX[j] && mx < minX[j] + 100) {
                    if (my > minY[i] && my < minY[i] + 100) {
                        fx = j;
                        fy = i;
                        if (boardField[j][i] == 0) {
                            overlap = OVERLAP.FieldEmpty;
                        } else {
                            overlap = OVERLAP.Field;
                        }
                    }
                }
            }
        }
    }


    public void tick(){
        if (minY[5] == 0) {
            int spx = 0, spy = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    minX[j] = 10 + (j * 100) + spx;
                    minY[i] = 50 + (i * 100) + spy;
                    spx += 5;
                }
                spx = 0;
                spy += 5;
            }
        }
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
        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr. drawRect(880, 0, 70, 35);
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
            gr.setColor(Color.red);
            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.drawRect(665, 65, 81, 35);
            gr.drawString("Storage", 670, 90);
        } else if (overlap == OVERLAP.Crafting) {


            gr.setColor(Color.red);
            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.drawRect(756, 65, 81, 35);
            gr.drawString("Crafting", 761, 90);
        } else if (overlap == OVERLAP.Store) {
            Main.store.render(gr);
        } else if (overlap == OVERLAP.Menu) {
            Main.menu.render(gr);
        } else if (overlap == OVERLAP.Field) {
            gr.setColor(Color.red);
            gr.drawRect(minX[fx], minY[fy], 100, 100);
            Main.upgrade.render(gr);
        } else if (overlap == OVERLAP.FieldEmpty) {
            gr.setColor(Color.green);
            gr.drawRect(minX[fx], minY[fy], 100, 100);
            Main.build.render(gr);
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
