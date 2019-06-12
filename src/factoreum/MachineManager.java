package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MachineManager extends MouseAdapter{

    private static MachineManager ourInstance = new MachineManager();

    private static MachineManager single_instance = null;

    public static MachineManager getInstance()
    {
        if (single_instance == null)
            single_instance = new MachineManager();

        return single_instance;
    }

    private IBoard board = Board.getInstance();
    private Handler handler = Handler.getInstance();
    private IStorageRaw raw = Storage.getInstance();
    private IStorageItems items = Storage.getInstance();
    public static final int[] x = {20,125, 230, 335, 440, 545}, y = {60, 165, 270, 375, 480, 585};
    private ITEM[] craftingItem;
    private Machine temp;
    private int[] ore;

    private TYPE m;


    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (board.getOverlap() == OVERLAP.Field) {
            if (mousePos(mx, my, 665, 130, 265, 35)) {
                handler.deleteMachine(board.getBoardField()[board.getFx()][board.getFy()]);
                board.getBoardField()[board.getFx()][board.getFy()] = -1;
            }
            for (int i=0; i<handler.getMachine().size(); i++) {
                temp = handler.getMachine().get(i);



                if (temp.getId() == board.getBoardField()[board.getFx()][board.getFy()]) {
                    if (temp.type == TYPE.Solar) {
                        m = TYPE.Solar;
                        board.setFieldtype(Board.FIELDTYPE.FieldSolar);
                    } else if (temp.type == TYPE.Fuel) {
                        m = TYPE.Fuel;
                        board.setFieldtype(Board.FIELDTYPE.FieldFuel);
                    } else if (temp.type == TYPE.Nuclear) {
                        m = TYPE.Nuclear;
                        board.setFieldtype(Board.FIELDTYPE.FieldNuclear);
                    } else if (temp.type == TYPE.Miner) {
                        m = TYPE.Miner;
                        board.setFieldtype(Board.FIELDTYPE.FieldMiner);
                    } else if (temp.type == TYPE.AdvancedMiner) {
                        m = TYPE.AdvancedMiner;
                        board.setFieldtype(Board.FIELDTYPE.FieldAdvancedMiner);
                        if (mousePos(mx, my, 665, 220, 265, 35)) {
                            ore = board.getOre();
                            ore[temp.getId()] = 1;
                            board.setOre(ore);
                        }else if (mousePos(mx, my, 665, 260, 265, 35)){
                            ore = board.getOre();
                            ore[temp.getId()] = 2;
                            board.setOre(ore);
                        } else if (mousePos(mx, my, 665, 300, 265, 35)){
                            ore = board.getOre();
                            ore[temp.getId()] = 3;
                            board.setOre(ore);
                        } else if (mousePos(mx, my, 665, 340, 265, 35)){
                            ore = board.getOre();
                            ore[temp.getId()] = 4;
                            board.setOre(ore);
                        }

                    } else if (temp.type == TYPE.Crafter) {
                        m = TYPE.Crafter;
                        board.setFieldtype(Board.FIELDTYPE.FieldCrafter);

                        if (mousePos(mx, my, 665, 220, 265, 35)) {
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.graphite;
                            board.setItem(craftingItem);
                        }else if (mousePos(mx, my, 665, 260, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.graphiteRod;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 300, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.controlRod;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 340, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.titaniumPlate;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 380, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.fuelRod;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 420, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.advancedFuelRod;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 460, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.electronicParts;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 500, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.powerTransmiter;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 540, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.pureCrystal;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 580, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.reinforcedTiPlate;
                            board.setItem(craftingItem);
                        } else if (mousePos(mx, my, 665, 620, 265, 35)){
                            craftingItem = board.getItem();
                            craftingItem[temp.getId()] = ITEM.electronicCircute;
                            board.setItem(craftingItem);
                        }

                    }
//                    else if (temp.type == TYPE.Cooler) {
//                        m = TYPE.Cooler;
//                        board.setFieldtype(Board.FIELDTYPE.FieldCooler);
//                    }
                    if (mousePos(mx, my, 665, 170, 265, 35)) {
                        upgrade(temp);
                    }
                }
            }
        } else m = null;
    }

    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    private int to (int i) {
        if (i <= 0) {
            return 0;
        } else {
            return i;
        }
    }

    private void upgrade(Machine ma) {

        if (m == TYPE.Solar && ma.getLvl() < 10 && raw.getTitanium() >= 10 * ma.getLvl()
                && raw.getCrystals() >= 5 * to((ma.getLvl() - 2))
                && items.getGraphite() >= 5 * to((ma.getLvl() - 2))
                && items.getTitaniumPlate() >= 3 * to((ma.getLvl() - 4))
                && items.getElectronicParts() >= 2 * to((ma.getLvl() - 4))
                && items.getPowerTransmiter() >= to(ma.getLvl()- 6)
                && items.getReinforcedTiPlate() >= to(ma.getLvl() - 6)) {

                raw.setTitanium(raw.getTitanium() - to(10 * ma.getLvl()));
                raw.setCrystals(raw.getCrystals() - to((5 * (ma.getLvl() - 2))));
                items.setGraphite(items.getGraphite() - to(5 * (ma.getLvl() - 2)));
                items.setTitaniumPlate(items.getTitaniumPlate() - to(3 * (ma.getLvl() - 4)));
                items.setElectronicParts(items.getElectronicParts() - to(2 * (ma.getLvl() - 4)));
                items.setPowerTransmiter(items.getPowerTransmiter() - to(ma.getLvl()- 6));
                items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to(ma.getLvl() - 6));

                ma.setLvl(ma.getLvl() + 1);

        } else if (m == TYPE.Fuel && ma.getLvl() < 10 && raw.getTitanium() >= to((5 * (ma.getLvl())))
                && raw.getCoal() >= to((5 * (ma.getLvl())))
                && items.getElectronicParts() >= to((5 * (ma.getLvl() - 4)))
                && items.getTitaniumPlate() >= to((3 * (ma.getLvl() - 4)))
                && items.getPowerTransmiter() >= to((3 * (ma.getLvl() - 2)))
                && items.getReinforcedTiPlate() >= to((2 * (ma.getLvl() - 6)))
                && items.getElectronicCircute() >= to((2 * (ma.getLvl() - 6))) ) {

                raw.setTitanium(raw.getTitanium() - to((5 * (ma.getLvl()))));
                raw.setCoal(raw.getCoal() - to((5 * (ma.getLvl()))));
                items.setElectronicParts(items.getElectronicParts() - to((5 * (ma.getLvl() - 4))));
                items.setTitaniumPlate(items.getTitaniumPlate() - to((3 * (ma.getLvl() - 4))));
                items.setPowerTransmiter(items.getPowerTransmiter() - to((3 * (ma.getLvl() - 2))));
                items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((2 * (ma.getLvl() - 6))));
                items.setElectronicCircute(items.getElectronicCircute() - to((2 * (ma.getLvl() - 6))));

                ma.setLvl(ma.getLvl() + 1);
        } else if (m == TYPE.Nuclear && ma.getLvl() < 10
                && raw.getTitanium() >=- to((5 * (ma.getLvl())))
                && raw.getUranium() >= to((10 * (ma.getLvl())))
                && items.getGraphite() >= to((10 * (ma.getLvl())))
                && items.getTitaniumPlate() >= to((5 * (ma.getLvl() - 4)))
                && items.getGraphiteRod() >= to((5 * (ma.getLvl() - 4)))
                && items.getFuelRod() >= to((5 * (ma.getLvl() - 2)))
                && items.getReinforcedTiPlate() >= to((5 * (ma.getLvl() - 6)))
                && items.getControlRod() >= to((5 * (ma.getLvl() - 4)))
                && items.getAdvancedFuelRod() >= to((5 * (ma.getLvl() - 4)))
                && items.getPowerTransmiter() >= to(((ma.getLvl() - 4)))
                && items.getElectronicCircute() >= to(((ma.getLvl() - 4)))) {

                raw.setTitanium(raw.getTitanium() - to((5 * (ma.getLvl()))));
                raw.setUranium(raw.getUranium() - to((10 * (ma.getLvl()))));
                items.setGraphite(items.getGraphite() - to((10 * (ma.getLvl()))));
                items.setTitaniumPlate(items.getTitaniumPlate() - to((5 * (ma.getLvl() - 4))));
                items.setGraphiteRod(items.getGraphiteRod() - to((5 * (ma.getLvl() - 4))));
                items.setFuelRod(items.getFuelRod() - to((5 * (ma.getLvl() - 2))));
                items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((5 * (ma.getLvl() - 6))));
                items.setControlRod(items.getControlRod() - to((5 * (ma.getLvl() - 2))));
                items.setAdvancedFuelRod(items.getAdvancedFuelRod() - to((5 * (ma.getLvl() - 4))));
                items.setPowerTransmiter(items.getPowerTransmiter() - to(((ma.getLvl() - 4))));
                items.setElectronicCircute(items.getElectronicCircute() - to(((ma.getLvl() - 4))));

            ma.setLvl(ma.getLvl() + 1);
        } else if (m == TYPE.Miner && ma.getLvl() < 10) {

                raw.setTitanium(raw.getTitanium() - to((5 * (ma.getLvl() - 2))));
                raw.setCoal(raw.getCoal() - to((5 * (ma.getLvl() - 2))));
                items.setElectronicParts(items.getElectronicParts() - to((5 * (ma.getLvl() - 2))));
                items.setTitaniumPlate(items.getTitaniumPlate() - to((5 * (ma.getLvl() - 2))));
                items.setPowerTransmiter(items.getPowerTransmiter() - to((5 * (ma.getLvl() - 2))));
                items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((5 * (ma.getLvl() - 2))));
                items.setElectronicCircute(items.getElectronicCircute() - to((5 * (ma.getLvl() - 2))));

            ma.setLvl(ma.getLvl() + 1);
        } else if (m == TYPE.AdvancedMiner && ma.getLvl() < 10 && raw.getTitanium() >= (10 * ma.getLvl())
                && items.getElectronicParts() >= to((5 * (ma.getLvl() - 3)))
                && items.getTitaniumPlate() >= to((5 * (ma.getLvl() - 4)))
                && items.getReinforcedTiPlate() >= to((2 * (ma.getLvl() - 2)))
                && items.getElectronicCircute() >= to((ma.getLvl() - 6))) {

                raw.setTitanium(raw.getTitanium() - (10 * ma.getLvl()));
                items.setElectronicParts(items.getElectronicParts() - to((5 * (ma.getLvl() - 3))));
                items.setTitaniumPlate(items.getTitaniumPlate() - to((5 * (ma.getLvl() - 4))));
                items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((2 * (ma.getLvl() - 2))));
                items.setElectronicCircute(items.getElectronicCircute() - to((ma.getLvl() - 6)));

            ma.setLvl(ma.getLvl() + 1);
        } else if (m == TYPE.Crafter && ma.getLvl() < 10) {

            raw.setTitanium(raw.getTitanium() - (10 * ma.getLvl()));
            raw.setCoal(raw.getCoal() - (10 * ma.getLvl()));
            items.setElectronicParts(items.getElectronicParts() - to((5 * (ma.getLvl() - 2))));
            items.setTitaniumPlate(items.getTitaniumPlate() - to((5 * (ma.getLvl() - 2))));
            items.setPowerTransmiter(items.getPowerTransmiter() - to((5 * (ma.getLvl() - 2))));
            items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((5 * (ma.getLvl() - 2))));
            items.setElectronicCircute(items.getElectronicCircute() - to((5 * (ma.getLvl() - 2))));

            ma.setLvl(ma.getLvl() + 1);
        }
    }

    private boolean mousePos(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }

        public void tick() {

        }

        public void render(Graphics gr) {

            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.setColor(Color.white);
            gr.drawString("Destroy",                                   670, 155);
            gr.drawRect(                                                    665, 130, 265, 35);

            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.setColor(Color.white);
            gr.drawString("Upgrade",                                   670, 195);
            gr.drawRect(                                                    665, 170, 265, 35);

            if (m == TYPE.Solar) {

            } else if (m == TYPE.Fuel) {

            } else if (m == TYPE.Nuclear) {

            } else if (m == TYPE.Miner) {

            } else if (m == TYPE.AdvancedMiner) {

                gr.setColor(Color.white);
                gr.setFont(new Font("arial", Font.PLAIN, 20));
                gr.drawRect(665, 220, 265, 35);
                gr.drawRect(665, 260, 265, 35);
                gr.drawRect(665, 300, 265, 35);
                gr.drawRect(665, 340, 265, 35);

                gr.drawString("Coal: " + raw.getCoal(),                          670, 245);
                gr.drawString("Titanium: " + raw.getTitanium(),                    670, 285);
                gr.drawString("Crystals: " + raw.getCrystals(),                    670, 325);
                gr.drawString("Uranium: " + raw.getUranium(),                  670, 365);

            } else if (m == TYPE.Crafter) {

                gr.setColor(Color.white);
                gr.setFont(new Font("arial", Font.PLAIN, 20));
                gr.drawRect(665, 220, 265, 35);
                gr.drawRect(665, 260, 265, 35);
                gr.drawRect(665, 300, 265, 35);
                gr.drawRect(665, 340, 265, 35);
                gr.drawRect(665, 380, 265, 35);
                gr.drawRect(665, 420, 265, 35);
                gr.drawRect(665, 460, 265, 35);
                gr.drawRect(665, 500, 265, 35);
                gr.drawRect(665, 540, 265, 35);
                gr.drawRect(665, 580, 265, 35);
                gr.drawRect(665, 620, 265, 35);

                gr.drawString("Graphite: " + items.getGraphite(),                          670, 245);
                gr.drawString("Graphite rods: " + items.getGraphiteRod(),                  670, 285);
                gr.drawString("Control Rods: " + items.getControlRod(),                    670, 325);
                gr.drawString("Titanium plates: " + items.getTitaniumPlate(),              670, 365);
                gr.drawString("Fuel rods: " + items.getFuelRod(),                          670, 405);
                gr.drawString("Advanced fuel rods: " + items.getAdvancedFuelRod(),         670, 445);
                gr.drawString("Electronic parts: " + items.getElectronicParts(),           670, 485);
                gr.drawString("Power transmiters: " + items.getPowerTransmiter(),          670, 525);
                gr.drawString("Pure crystals: " + items.getPureCrystal(),                  670, 565);
                gr.drawString("Reinforced ti. plates: " + items.getReinforcedTiPlate(),    670, 605);
                gr.drawString("Electronic circutes: " + items.getElectronicCircute(),      670, 645);


            }
//            else if (m == TYPE.Cooler) {
//
//            }


        }

}

