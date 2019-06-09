package factoreum;

import java.awt.*;

public class Crafter extends Machine implements IMachine {
    public Crafter(int x, int y, int temperature, int lvl, TYPE type, int id, boolean state) {
        super(x, y, temperature, lvl, type, id, state);
    }

    protected int powerU = 0;
    private int lastLvl = lvl;
    private  boolean p = false;
    private int time = 0;

    protected IBoard board = Board.getInstance();
    private IStorageRaw raw = Storage.getInstance();
    private IStorageItems item = Storage.getInstance();


    private ITEM it = ITEM.none;


    public void tick() {

        if(p != true) {
            powerU = (lvl * lvl * lvl);
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() + powerU);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() - (lvl * lvl * lvl));
            p = false;
            lastLvl = lvl;
        }

        if (IGuiRaw.getMaxPower() >= IGuiRaw.getPowerUsage() && time == 0) {

            if (board.getItem()[id] == ITEM.graphite && raw.getCoal() >= (lvl*10)) {
                raw.setCoal(raw.getCoal() - (lvl*10));
                item.setGraphite(item.getGraphite() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.graphiteRod && item.getGraphite() >= (lvl*10)) {
                item.setGraphite(item.getGraphite() - (lvl*10));
                item.setGraphiteRod(item.getGraphiteRod() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.controlRod && item.getGraphiteRod() >= (lvl*10)) {
                item.setControlRod(item.getControlRod() - (lvl*10));
                item.setControlRod(item.getControlRod() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.titaniumPlate && raw.getTitanium() >= (lvl*10)) {
                raw.setTitanium(raw.getTitanium() - (lvl*10));
                item.setTitaniumPlate(item.getTitaniumPlate() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.fuelRod && raw.getUranium() >= (lvl*10)) {
                raw.setUranium(raw.getUranium() - (lvl*10));
                item.setFuelRod(item.getFuelRod() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.advancedFuelRod && item.getFuelRod() >= (lvl*10)) {
                item.setFuelRod(item.getFuelRod() - (lvl*10));
                item.setAdvancedFuelRod(item.getAdvancedFuelRod() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.electronicParts && raw.getTitanium() >= (lvl*5) && raw.getCrystals() >= (lvl*5)) {
                raw.setTitanium(raw.getTitanium() - (lvl*5));
                raw.setCrystals(raw.getCrystals() - (lvl*5));
                time = 50;
                item.setElectronicParts(item.getElectronicParts() + lvl);
            } else if (board.getItem()[id] == ITEM.powerTransmiter && item.getPureCrystal() >= lvl && item.getElectronicParts() >= (lvl*5)) {
                item.setPureCrystal(item.getPureCrystal() - lvl);
                item.setElectronicParts(item.getElectronicParts() - (lvl*5));
                item.setPowerTransmiter(item.getPowerTransmiter() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.pureCrystal && raw.getCrystals() >= (lvl*50)) {
                raw.setCrystals(raw.getCrystals() - (lvl*50));
                item.setPureCrystal(item.getPureCrystal() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.reinforcedTiPlate && item.getTitaniumPlate() >= (lvl*10)) {
                item.setTitaniumPlate(item.getTitaniumPlate() - (lvl*10));
                item.setReinforcedTiPlate(item.getReinforcedTiPlate() + lvl);
                time = 50;
            } else if (board.getItem()[id] == ITEM.powerTransmiter && item.getPureCrystal() >= lvl && item.getElectronicParts() >= (lvl*20) && item.getGraphite() >= (lvl*20)) {
                item.setPureCrystal(item.getPureCrystal() - lvl);
                item.setElectronicParts(item.getElectronicParts() - (lvl*20));
                item.setGraphite(item.getGraphite() - (lvl*20));
                item.setElectronicCircute(item.getElectronicCircute() + lvl);
                time = 50;
            }

        } else if (IGuiRaw.getMaxPower() >= IGuiRaw.getPowerUsage() && time != 0) {
            time--;
        }

    }

    private Color c1 = new Color(208, 143, 72);
    public void render(Graphics gr) {

        gr.setColor(c1);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Crafter", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x +3, y +25);
        gr.drawString("Power: -" + powerU, x+3, y+53);
        gr.drawString("Temp: " + temperature, x+3, y+68);




        if (board.getOverlap() == OVERLAP.Field) {
            gr.setFont(new Font("arial", Font.PLAIN, 20));
            if (board.getItem()[id] == ITEM.graphite) {
                gr.setColor(Color.red);
                gr.drawString("Graphite: " + item.getGraphite(),                          670, 245);
            } else if (board.getItem()[id] == ITEM.graphiteRod) {
                gr.setColor(Color.red);
                gr.drawString("Graphite rods: " + item.getGraphiteRod(),                  670, 285);
            } else if (board.getItem()[id] == ITEM.controlRod) {
                gr.setColor(Color.red);
                gr.drawString("Control Rods: " + item.getControlRod(),                    670, 325);
            } else if (board.getItem()[id] == ITEM.titaniumPlate) {
                gr.setColor(Color.red);
                gr.drawString("Titanium plates: " + item.getTitaniumPlate(),              670, 365);
            } else if (board.getItem()[id] == ITEM.fuelRod) {
                gr.setColor(Color.red);
                gr.drawString("Fuel rods: " + item.getFuelRod(),                          670, 405);
            } else if (board.getItem()[id] == ITEM.advancedFuelRod) {
                gr.setColor(Color.red);
                gr.drawString("Advanced fuel rods: " + item.getAdvancedFuelRod(),         670, 445);
            } else if (board.getItem()[id] == ITEM.electronicParts) {
                gr.setColor(Color.red);
                gr.drawString("Electronic parts: " + item.getElectronicParts(),           670, 485);
            } else if (board.getItem()[id] == ITEM.powerTransmiter) {
                gr.setColor(Color.red);
                gr.drawString("Power transmiters: " + item.getPowerTransmiter(),          670, 525);
            } else if (board.getItem()[id] == ITEM.pureCrystal) {
                gr.setColor(Color.red);
                gr.drawString("Pure crystals: " + item.getPureCrystal(),                  670, 565);
            } else if (board.getItem()[id] == ITEM.reinforcedTiPlate) {
                gr.setColor(Color.red);
                gr.drawString("Reinforced ti. plates: " + item.getReinforcedTiPlate(),    670, 605);
            } else if (board.getItem()[id] == ITEM.powerTransmiter) {
                gr.setColor(Color.red);
                gr.drawString("Electronic circutes: " + item.getElectronicCircute(),      670, 645);
            }
        }
    }
}
