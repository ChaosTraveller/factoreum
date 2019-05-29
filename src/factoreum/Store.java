package factoreum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Store extends MouseAdapter {

    protected IStorageRaw IGuiRaw = Storage.getInstance();
    protected IStorageItems IGuiItems = Storage.getInstance();
    protected IBoardCoord gui = Board.getInstance();
    public Color c2 = new Color(255, 172, 23);


    int[] mX = {665,665,665,665,665,665,665,665,665,665,665,665,665,665,665};
    private float[] amount = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private final int[] price = {1, 2, 4, 5, 15, 160, 20, 80, 500, 50, 100, 500, 100, 300};
    private int i = 0;

    private static final Store instance = new Store();

    private Store() {
    }

    public static Store getInstance() {
        return instance;
    }

    public void mouseClicked(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();
        if (gui.getOverlap() == OVERLAP.Store) {
            if (mousePos2(mx, my, 800, 115, 130, 18) && IGuiRaw.getCoal() >= amount[0]) {
                IGuiRaw.setCoal(IGuiRaw.getCoal() - (int)amount[0]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[0] * price[0]));
            } else if (mousePos2(mx, my, 800, 150, 130, 18) && IGuiRaw.getTitanium() >= amount[1]) {
                IGuiRaw.setTitanium(IGuiRaw.getTitanium() - (int)amount[1]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[1] * price[1]));
            } else if (mousePos2(mx, my, 800, 185, 130, 18) && IGuiRaw.getCrystals() >= amount[2]) {
                IGuiRaw.setCrystals(IGuiRaw.getCrystals() - (int)amount[2]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[2] * price[2]));
            } else if (mousePos2(mx, my, 800, 220, 130, 18) && IGuiRaw.getUranium() >= amount[3]) {
                IGuiRaw.setUranium(IGuiRaw.getUranium() - (int)amount[3]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[3] * price[3]));
            } else if (mousePos2(mx, my, 800, 255, 130, 18) && IGuiItems.getGraphite() >= amount[4]) {
                IGuiItems.setGraphite(IGuiItems.getGraphite() - (int)amount[4]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[4] * price[4]));
            } else if (mousePos2(mx, my, 800, 290, 130, 18) && IGuiItems.getGraphiteRod() >= amount[5]) {
                IGuiItems.setGraphiteRod(IGuiItems.getGraphiteRod() - (int)amount[5]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[5] * price[5]));
            } else if (mousePos2(mx, my, 800, 325, 130, 18) && IGuiItems.getControlRod() >= amount[6]) {
                IGuiItems.setControlRod(IGuiItems.getControlRod() - (int)amount[6]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[6] * price[6]));
            } else if (mousePos2(mx, my, 800, 360, 130, 18) && IGuiItems.getTitaniumPlate() >= amount[7]) {
                IGuiItems.setTitaniumPlate(IGuiItems.getTitaniumPlate() - (int)amount[7]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[7] * price[7]));
            } else if (mousePos2(mx, my, 800, 395, 130, 18) && IGuiItems.getFuelRod() >= amount[8]) {
                IGuiItems.setFuelRod(IGuiItems.getFuelRod() - (int)amount[8]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[8] * price[8]));
            } else if (mousePos2(mx, my, 800, 430, 130, 18) && IGuiItems.getAdvancedFuelRod() >= amount[9]) {
                IGuiItems.setAdvancedFuelRod(IGuiItems.getAdvancedFuelRod() - (int)amount[9]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[9] * price[9]));
            } else if (mousePos2(mx, my, 800, 465, 130, 18) && IGuiItems.getElectronicParts() >= amount[10]) {
                IGuiItems.setElectronicParts(IGuiItems.getElectronicParts() - (int)amount[10]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[10] * price[10]));
            } else if (mousePos2(mx, my, 800, 500, 130, 18) && IGuiItems.getPowerTransmiter() >= amount[11]) {
                IGuiItems.setPowerTransmiter(IGuiItems.getPowerTransmiter() - (int)amount[11]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[11] * price[11]));
            } else if (mousePos2(mx, my, 800, 535, 130, 18) && IGuiItems.getPureCrystal() >= amount[12]) {
                IGuiItems.setPureCrystal(IGuiItems.getPureCrystal() - (int)amount[12]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[12] * price[12]));
            } else if (mousePos2(mx, my, 800, 570, 130, 18) && IGuiItems.getReinforcedTiPlate() >= amount[13]) {
                IGuiItems.setReinforcedTiPlate(IGuiItems.getReinforcedTiPlate() - (int)amount[13]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[13] * price[13]));
            } else if (mousePos2(mx, my, 800, 605, 130, 18) && IGuiItems.getElectronicCircute() >= amount[14]) {
                IGuiItems.setElectronicCircute(IGuiItems.getElectronicCircute() - (int)amount[14]);
                IGuiRaw.setUnits(IGuiRaw.getUnits() + ((int)amount[14] * price[14]));
            }

        }

    }


    public void mouseDragged(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (gui.getOverlap() == OVERLAP.Store) {
            if (mousePos2(mx, my, 665, 135, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 0;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiRaw.getCoal();
            } else if (mousePos2(mx, my, 665, 170, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 1;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiRaw.getTitanium();
            }else if (mousePos2(mx, my, 665, 205, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 2;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiRaw.getCrystals();
            }else if (mousePos2(mx, my, 665, 240, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 3;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiRaw.getUranium();
            }else if (mousePos2(mx, my, 665, 275, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 4;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getGraphite();
            }else if (mousePos2(mx, my, 665, 310, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 5;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getGraphiteRod();
            }else if (mousePos2(mx, my, 665, 345, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 6;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getControlRod();
            }else if (mousePos2(mx, my, 665, 380, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 7;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getTitaniumPlate();
            }else if (mousePos2(mx, my, 665, 415, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 8;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getFuelRod();
            }else if (mousePos2(mx, my, 665, 450, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 9;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getAdvancedFuelRod();
            }else if (mousePos2(mx, my, 665, 485, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 10;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getElectronicParts();
            }else if (mousePos2(mx, my, 665, 520, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 11;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getPowerTransmiter();
            }else if (mousePos2(mx, my, 665, 555, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 12;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getPureCrystal();
            }else if (mousePos2(mx, my, 665, 590, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 13;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getReinforcedTiPlate();
            }else if (mousePos2(mx, my, 665, 625, 265, 15)) {
                Arrays.fill(amount, 0);
                i = 14;
                amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiItems.getElectronicCircute();
            }

            if (mx <= 665) {
                Arrays.fill(mX, 665);
                mX[i] = 665;
            } else if (mx >=930) {
                Arrays.fill(mX, 665);
                mX[i] = 930;
            } else {
                Arrays.fill(mX, 665);
                mX[i] = mx;
            }
//            amount[i] = (float)((float)(mX[i] - 665)/265) * IGuiRaw.getCoal();
        }


    }

    private boolean mousePos2(int mx, int my, int x, int y, int width, int height) {
        if (mx > x - 5 && mx < x + width + 5) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }




    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    public void tick() {

    }

    public void render(Graphics gr) {

        gr.setColor(c2);
        gr.setFont(new Font("arial", Font.PLAIN, 13));

        gr.drawString("Coal: " + IGuiRaw.getCoal(),                                  665, 130);
        gr.drawString("Sell: " + (int)amount[0], 805, 130);
        gr.drawRect(                                                        800, 115, 130, 18);
        gr.drawRect(                                                        665, 135, 265, 15);

        gr.drawString("Titanium: " + IGuiRaw.getTitanium(),                          665, 165);
        gr.drawString("Sell: " + (int)amount[1], 805, 165);
        gr.drawRect(                                                        800, 150, 130, 18);
        gr.drawRect(                                                        665, 170, 265, 15);

        gr.drawString("Crystals: " + IGuiRaw.getCrystals(),                          665, 200);
        gr.drawString("Sell: " + (int)amount[2], 805, 200);
        gr.drawRect(                                                        800, 185, 130, 18);
        gr.drawRect(                                                        665, 205, 265, 15);

        gr.drawString("Uranium: " + IGuiRaw.getUranium(),                            665, 235);
        gr.drawString("Sell: " + (int)amount[3], 805, 235);
        gr.drawRect(                                                        800, 220, 130, 18);
        gr.drawRect(                                                        665, 240, 265, 15);

        gr.drawString("Graphite: " + IGuiItems.getGraphite(),                          665, 270);
        gr.drawString("Sell: " + (int)amount[4], 805, 270);
        gr.drawRect(                                                        800, 255, 130, 18);
        gr.drawRect(                                                        665, 275, 265, 15);

        gr.drawString("Graphite rods: " + IGuiItems.getGraphiteRod(),                  665, 305);
        gr.drawString("Sell: " + (int)amount[5], 805, 305);
        gr.drawRect(                                                        800, 290, 130, 18);
        gr.drawRect(                                                        665, 310, 265, 15);

        gr.drawString("Controm Rods: " + IGuiItems.getControlRod(),                    665, 340);
        gr.drawString("Sell: " + (int)amount[6], 805, 340);
        gr.drawRect(                                                        800, 325, 130, 18);
        gr.drawRect(                                                        665, 345, 265, 15);

        gr.drawString("Titanium plates: " + IGuiItems.getTitaniumPlate(),              665, 375);
        gr.drawString("Sell: " + (int)amount[7], 805, 375);
        gr.drawRect(                                                        800, 360, 130, 18);
        gr.drawRect(                                                        665, 380, 265, 15);

        gr.drawString("Fuel rods: " + IGuiItems.getFuelRod(),                          665, 410);
        gr.drawString("Sell: " + (int)amount[8], 805, 410);
        gr.drawRect(                                                        800, 395, 130, 18);
        gr.drawRect(                                                        665, 415, 265, 15);

        gr.drawString("Advanced fuel rods: " + IGuiItems.getAdvancedFuelRod(),         665, 445);
        gr.drawString("Sell: " + (int)amount[9], 805, 445);
        gr.drawRect(                                                        800, 430, 130, 18);
        gr.drawRect(                                                        665, 450, 265, 15);

        gr.drawString("Electronic parts: " + IGuiItems.getElectronicParts(),           665, 480);
        gr.drawString("Sell: " + (int)amount[10], 805, 480);
        gr.drawRect(                                                        800, 465, 130, 18);
        gr.drawRect(                                                        665, 485, 265, 15);

        gr.drawString("Power transmiters: " + IGuiItems.getPowerTransmiter(),          665, 515);
        gr.drawString("Sell: " + (int)amount[11], 805, 515);
        gr.drawRect(                                                        800, 500, 130, 18);
        gr.drawRect(                                                        665, 520, 265, 15);

        gr.drawString("Pure crystals: " + IGuiItems.getPureCrystal(),                  665, 550);
        gr.drawString("Sell: " + (int)amount[12], 805, 550);
        gr.drawRect(                                                        800, 535, 130, 18);
        gr.drawRect(                                                        665, 555, 265, 15);

        gr.drawString("Reinforced ti. plates: " + IGuiItems.getReinforcedTiPlate(),    665, 585);
        gr.drawString("Sell: " + (int)amount[13], 805, 585);
        gr.drawRect(                                                        800, 570, 130, 18);
        gr.drawRect(                                                        665, 590, 265, 15);

        gr.drawString("Electronic circutes: " + IGuiItems.getElectronicCircute(),      665, 620);
        gr.drawString("Sell: " + (int)amount[14], 805, 620);
        gr.drawRect(                                                        800, 605, 130, 18);
        gr.drawRect(                                                        665, 625, 265, 15);


        gr.setColor(Color.red);
        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr.drawRect(847, 65, 81, 35);
        gr.drawString("Store", 862, 90);
        gr.setColor(Color.red);
        gr.drawRect(mX[0], 135, 2,15);
        gr.drawRect(mX[1], 170, 2,15);
        gr.drawRect(mX[2], 205, 2,15);
        gr.drawRect(mX[3], 240, 2,15);
        gr.drawRect(mX[4], 275, 2,15);
        gr.drawRect(mX[5], 310, 2,15);
        gr.drawRect(mX[6], 345, 2,15);
        gr.drawRect(mX[7], 380, 2,15);
        gr.drawRect(mX[8], 415, 2,15);
        gr.drawRect(mX[9], 450, 2,15);
        gr.drawRect(mX[10], 485, 2,15);
        gr.drawRect(mX[11], 520, 2,15);
        gr.drawRect(mX[12], 555, 2,15);
        gr.drawRect(mX[13], 590, 2,15);
        gr.drawRect(mX[14], 625, 2,15);




    }

}
