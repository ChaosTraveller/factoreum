package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private IHandler handler = Handler.getInstance();
    private IStorageRaw raw = Storage.getInstance();
    private IStorageItems items = Storage.getInstance();
    public static final int[] x = {20,125, 230, 335, 440, 545}, y = {60, 165, 270, 375, 480, 585};
    private ITEM[] craftingItem;
    private Machine temp;
    private int[] ore;

    private Machine m;


    public void mouseReleased(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (board.getOverlap() == OVERLAP.Field) {
            if (mousePos(mx, my, 665, 170, 265, 35)) {
                handler.deleteMachine(board.getBoardField()[board.getFx()][board.getFy()]);
                board.getBoardField()[board.getFx()][board.getFy()] = -1;
            }
            for (int i=0; i<handler.getMachine().size(); i++) {
                temp = handler.getMachine().get(i);



                if (temp.getId() == board.getBoardField()[board.getFx()][board.getFy()]) {
                    if (temp.type == TYPE.Solar) {
                        m = temp;
                        board.setFieldtype(Board.FIELDTYPE.FieldSolar);
                    } else if (temp.type == TYPE.Fuel) {
                        m = temp;
                        board.setFieldtype(Board.FIELDTYPE.FieldFuel);
                    } else if (temp.type == TYPE.Nuclear) {
                        m = temp;
                        board.setFieldtype(Board.FIELDTYPE.FieldNuclear);
                    } else if (temp.type == TYPE.Miner) {
                        m = temp;
                        board.setFieldtype(Board.FIELDTYPE.FieldMiner);
                    } else if (temp.type == TYPE.AdvancedMiner) {
                        m = temp;
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
                        m = temp;
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
                    if (mousePos(mx, my, 665, 110, 265, 55)) {
                        upgrade(temp);
                    }
                    if (mousePos(mx, my, 756, 65, 81, 35) && (m.getType() == TYPE.Crafter || m.getType() == TYPE.Miner || m.getType() == TYPE.AdvancedMiner)) {
                        if (m.getState() == true) {
                            m.setState(false);
                        } else if (m.getState() == false) {
                            m.setState(true);
                        }
                    }
                }
            }
        } else m = null;
    }


    private int to (int i) {        //funkcja zwraca zero jeśli int < 0
        if (i <= 0) {
            return 0;
        } else {
            return i;
        }
    }

    private void upgrade(Machine ma) {      //Upgradeowanie maszyny

        if (m.getType() == TYPE.Solar && ma.getLvl() < 10 && raw.getTitanium() >= 10 * ma.getLvl()
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

                m.setLvl(m.getLvl() + 1);

        } else if (m.getType() == TYPE.Fuel && ma.getLvl() < 10 && raw.getTitanium() >= to((5 * (ma.getLvl())))
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

                m.setLvl(m.getLvl() + 1);

        } else if (m.getType() == TYPE.Nuclear && ma.getLvl() < 10
                && raw.getUranium() >= to((10 * (ma.getLvl())))
                && items.getGraphite() >= to((10 * (ma.getLvl())))
                && items.getTitaniumPlate() >= to((5 * (ma.getLvl())))
                && items.getGraphiteRod() >= to((5 * (ma.getLvl() - 4)))
                && items.getFuelRod() >= to((5 * (ma.getLvl() - 2)))
                && items.getReinforcedTiPlate() >= to((5 * (ma.getLvl() - 6)))
                && items.getControlRod() >= to((5 * (ma.getLvl() - 4)))
                && items.getAdvancedFuelRod() >= to((5 * (ma.getLvl() - 4)))
                && items.getPowerTransmiter() >= to(((ma.getLvl() - 4)))
                && items.getElectronicCircute() >= to(((ma.getLvl() - 4)))) {

                raw.setUranium(raw.getUranium() - to((10 * (ma.getLvl()))));
                items.setGraphite(items.getGraphite() - to((10 * (ma.getLvl()))));
                items.setTitaniumPlate(items.getTitaniumPlate() - to((5 * (ma.getLvl()))));
                items.setGraphiteRod(items.getGraphiteRod() - to((5 * (ma.getLvl() - 4))));
                items.setFuelRod(items.getFuelRod() - to((5 * (ma.getLvl() - 2))));
                items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((5 * (ma.getLvl() - 6))));
                items.setControlRod(items.getControlRod() - to((5 * (ma.getLvl() - 2))));
                items.setAdvancedFuelRod(items.getAdvancedFuelRod() - to((5 * (ma.getLvl() - 4))));
                items.setPowerTransmiter(items.getPowerTransmiter() - to(((ma.getLvl() - 4))));
                items.setElectronicCircute(items.getElectronicCircute() - to(((ma.getLvl() - 4))));

                m.setLvl(m.getLvl() + 1);
        } else if (m.getType() == TYPE.Miner && ma.getLvl() < 10
                && raw.getTitanium() >= to((5 * (ma.getLvl())))
                && items.getElectronicParts() >= to((3 * (ma.getLvl() - 4)))
                && items.getTitaniumPlate() >= to((5 * (ma.getLvl() - 5)))
                && items.getReinforcedTiPlate() >= to((2 * (ma.getLvl() - 7)))
                && items.getElectronicCircute() >= to(((ma.getLvl() - 7)))) {

                raw.setTitanium(raw.getTitanium() - to((5 * (ma.getLvl()))));
                items.setElectronicParts(items.getElectronicParts() - to((3 * (ma.getLvl() - 4))));
                items.setTitaniumPlate(items.getTitaniumPlate() - to((5 * (ma.getLvl() - 5))));
                items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((2 * (ma.getLvl() - 7))));
                items.setElectronicCircute(items.getElectronicCircute() - to(((ma.getLvl() - 7))));

            ma.setLvl(ma.getLvl() + 1);
        } else if (m.getType() == TYPE.AdvancedMiner && ma.getLvl() < 10 && raw.getTitanium() >= (10 * ma.getLvl())
                && items.getElectronicParts() >= to((5 * (ma.getLvl() - 3)))
                && items.getTitaniumPlate() >= to((5 * (ma.getLvl() - 4)))
                && items.getReinforcedTiPlate() >= to((2 * (ma.getLvl() - 2)))
                && items.getPowerTransmiter() >= to((2 * (ma.getLvl() - 5)))
                && items.getElectronicCircute() >= to((ma.getLvl() - 6))) {

                raw.setTitanium(raw.getTitanium() - (10 * ma.getLvl()));
                items.setPowerTransmiter(items.getPowerTransmiter() - to((2 * (ma.getLvl() - 5))));
                items.setElectronicParts(items.getElectronicParts() - to((5 * (ma.getLvl() - 3))));
                items.setTitaniumPlate(items.getTitaniumPlate() - to((5 * (ma.getLvl() - 4))));
                items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((2 * (ma.getLvl() - 2))));
                items.setElectronicCircute(items.getElectronicCircute() - to((ma.getLvl() - 6)));

            m.setLvl(m.getLvl() + 1);
        } else if (m.getType() == TYPE.Crafter && ma.getLvl() < 10
                && raw.getTitanium() >= (10 * ma.getLvl())
                && raw.getCrystals() >= to((5 * (ma.getLvl())))
                && items.getElectronicParts() >= to((5 * (ma.getLvl() - 3)))
                && items.getTitaniumPlate() >= to((10 * (ma.getLvl() - 3)))
                && items.getPowerTransmiter() >= to((3 * (ma.getLvl() - 3)))
                && items.getReinforcedTiPlate() >= to((2 * (ma.getLvl() - 4)))
                && items.getElectronicCircute() >= to((2 * (ma.getLvl() - 4)))
                && items.getPureCrystal() >= to((2 * (ma.getLvl() - 4)))) {

            raw.setTitanium(raw.getTitanium() - (10 * ma.getLvl()));
            raw.setCrystals(raw.getCrystals() - to((5 * (ma.getLvl()))));
            items.setElectronicParts(items.getElectronicParts() - to((5 * (ma.getLvl() - 3))));
            items.setTitaniumPlate(items.getTitaniumPlate() - to((10 * (ma.getLvl() - 3))));
            items.setPowerTransmiter(items.getPowerTransmiter() - to((3 * (ma.getLvl() - 3))));
            items.setReinforcedTiPlate(items.getReinforcedTiPlate() - to((2 * (ma.getLvl() - 4))));
            items.setElectronicCircute(items.getElectronicCircute() - to((2 * (ma.getLvl() - 4))));
            items.setPureCrystal(items.getPureCrystal() - to((2 * (ma.getLvl() - 4))));

            m.setLvl(ma.getLvl() + 1);
        }
    }

    private boolean mousePos(int mx, int my, int x, int y, int width, int height) {     //Sprawdzanie pozycji kursora na ekranie
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
            gr.drawString("Upgrade",                                   670, 145);
            gr.drawRect(                                                    665, 110, 265, 55);
            gr.drawRect(                                                    665, 110, 90, 55);

            gr.setFont(new Font("arial", Font.PLAIN, 20));
            gr.setColor(Color.red);
            gr.drawString("Destroy",                                   670, 195);
            gr.setColor(Color.white);
            gr.drawRect(                                                    665, 170, 265, 35);



            if (m.getType() == TYPE.Crafter || m.getType() == TYPE.Miner || m.getType() == TYPE.AdvancedMiner) {
                if (m.getState() == true) {
                    gr.setColor(Color.green);
                } else gr.setColor(Color.red);
                gr.setFont(new Font("arial", Font.PLAIN, 20));
                gr.drawRect(756, 65, 81, 35);
                gr.drawString("ON/OFF", 761, 90);
            }


            if (m.getType() == TYPE.Solar ) {
                gr.setFont(new Font("arial", Font.PLAIN, 10));
                gr.setColor(Color.white);
                gr.drawString("Titanium " + to(10 * m.getLvl()), 760, 120);
                gr.drawString("Crystals " + to((5 * (m.getLvl() - 2))), 760, 130);
                gr.drawString("Grafite " + to(5 * (m.getLvl() - 2)), 760, 140);
                gr.drawString("Ti Plate " + to(3 * (m.getLvl() - 4)), 760, 150);
                gr.drawString("El Parts " + to(2 * (m.getLvl() - 4)), 760, 160);
                gr.drawString("P Transmiter " + to(m.getLvl()- 6), 847, 120);
                gr.drawString("R Ti Plate " + to(m.getLvl() - 6), 847, 130);

            } else if (m.getType() == TYPE.Fuel) {



                gr.setFont(new Font("arial", Font.PLAIN, 10));
                gr.setColor(Color.white);
                gr.drawString("Titanium " + to((5 * (m.getLvl()))), 760, 120);
                gr.drawString("Coal " + to((5 * (m.getLvl()))), 760, 130);
                gr.drawString("El Parts " + to((5 * (m.getLvl() - 4))), 760, 140);
                gr.drawString("Ti Plate " + to((3 * (m.getLvl() - 4))), 760, 150);
                gr.drawString("P Transmiter " + to((3 * (m.getLvl() - 2))), 760, 160);
                gr.drawString("R Ti Plate " + to((2 * (m.getLvl() - 6))), 847, 120);
                gr.drawString("E Circutes " + to((2 * (m.getLvl() - 6))), 847, 130);

            } else if (m.getType() == TYPE.Nuclear) {


                gr.setFont(new Font("arial", Font.PLAIN, 10));
                gr.setColor(Color.white);
                gr.drawString("Uranium " + to((10 * (m.getLvl()))), 760, 120);
                gr.drawString("Graphite " + to((10 * (m.getLvl()))), 760, 130);
                gr.drawString("Ti Plate " + to((5 * (m.getLvl()))), 760, 140);
                gr.drawString("Gr Rod " + to((5 * (m.getLvl() - 4))), 760, 150);
                gr.drawString("Fuel Rod " + to((5 * (m.getLvl() - 2))), 760, 160);
                gr.drawString("R Ti Plate " + to((5 * (m.getLvl() - 6))), 847, 120);
                gr.drawString("C Rod " + to((5 * (m.getLvl() - 2))), 847, 130);
                gr.drawString("A Fuel Rod " + to((5 * (m.getLvl() - 4))), 847, 140);
                gr.drawString("P Transmiter " + to(((m.getLvl() - 4))), 847, 150);
                gr.drawString("E Circutes " + to(((m.getLvl() - 4))), 847, 160);

            } else if (m.getType() == TYPE.Miner) {

                gr.setFont(new Font("arial", Font.PLAIN, 10));
                gr.setColor(Color.white);
                gr.drawString("Titanium " + to((5 * (m.getLvl()))), 760, 120);
                gr.drawString("El Parts " + to((3 * (m.getLvl() - 4))), 760, 130);
                gr.drawString("Ti Plate " + to((5 * (m.getLvl() - 5))), 760, 140);
                gr.drawString("R Ti Plate " + to((2 * (m.getLvl() - 7))), 760, 150);
                gr.drawString("E Circutes " + to(((m.getLvl() - 7))), 760, 160);


            } else if (m.getType() == TYPE.AdvancedMiner) {

                gr.setFont(new Font("arial", Font.PLAIN, 10));
                gr.setColor(Color.white);
                gr.drawString("Titanium " + to(10 * m.getLvl()), 760, 120);
                gr.drawString("P Transmiter " + to((2 * (m.getLvl() - 5))), 760, 130);
                gr.drawString("El Parts " + to((5 * (m.getLvl() - 3))), 760, 140);
                gr.drawString("Ti Plate " + to((5 * (m.getLvl() - 4))), 760, 150);
                gr.drawString("R Ti Plate " + to((2 * (m.getLvl() - 2))), 760, 160);
                gr.drawString("E Circutes " + to((m.getLvl() - 6)), 847, 120);


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

            } else if (m.getType() == TYPE.Crafter) {

                gr.setFont(new Font("arial", Font.PLAIN, 10));
                gr.setColor(Color.white);
                gr.drawString("Titanium " + to(10 * m.getLvl()), 760, 120);
                gr.drawString("Crystals " + to((5 * (m.getLvl()))), 760, 130);
                gr.drawString("El Parts " + to((5 * (m.getLvl() - 3))), 760, 140);
                gr.drawString("Ti Plate " + to((10 * (m.getLvl() - 3))), 760, 150);
                gr.drawString("P Transmiter " + to((3 * (m.getLvl() - 3))), 760, 160);
                gr.drawString("R Ti Plate " + to((2 * (m.getLvl() - 4))), 847, 120);
                gr.drawString("E Circutes " + to((2 * (m.getLvl() - 4))), 847, 130);
                gr.drawString("Pure Crystal " + to((2 * (m.getLvl() - 4))), 847, 140);

                gr.setColor(Color.white);
                gr.setFont(new Font("arial", Font.PLAIN, 15));
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

                gr.drawString("Graphite: 10Coal   " + items.getGraphite(),                          670, 245);
                gr.drawString("Graphite rods: 10Graf.   " + items.getGraphiteRod(),                  670, 285);
                gr.drawString("Control Rods: 10GrRod   " + items.getControlRod(),                    670, 325);
                gr.drawString("Titanium plates: 10Tit.  " + items.getTitaniumPlate(),              670, 365);
                gr.drawString("Fuel rods: 10U   " + items.getFuelRod(),                          670, 405);
                gr.drawString("Advanced fuel rods: 10FRod   " + items.getAdvancedFuelRod(),         670, 445);
                gr.drawString("Electronic parts: 5Cr. 5Ti   " + items.getElectronicParts(),           670, 485);
                gr.drawString("Power transmiters: 1Pc 5Ep   " + items.getPowerTransmiter(),          670, 525);
                gr.drawString("Pure crystals: 50xCr   " + items.getPureCrystal(),                  670, 565);
                gr.drawString("Reinforced ti. plates: 10TiPl   " + items.getReinforcedTiPlate(),    670, 605);
                gr.drawString("Electronic cir.: 1pcr 20gr 20ep   " + items.getElectronicCircute(),      670, 645);


            }
//            else if (m == TYPE.Cooler) {
//
//            }


        }

}

