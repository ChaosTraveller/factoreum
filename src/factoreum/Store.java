package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Store extends MouseAdapter {

    private GUI gui = GUI.getInstance();
    protected IGuiRaw IGuiRaw = GUI.getInstance();
    protected IGuiItems IGuiItems = GUI.getInstance();
    public Color c2 = new Color(255, 172, 23);


    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
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
        gr.drawRect(                                                        665, 135, 265, 15);
        gr.drawString("Titanium: " + IGuiRaw.getTitanium(),                          665, 165);
        gr.drawRect(                                                        665, 170, 265, 15);
        gr.drawString("Crystals: " + IGuiRaw.getCrystals(),                          665, 200);
        gr.drawRect(                                                        665, 205, 265, 15);
        gr.drawString("Uranium: " + IGuiRaw.getUranium(),                            665, 235);
        gr.drawRect(                                                        665, 240, 265, 15);
        gr.drawString("Graphite: " + IGuiItems.getGraphite(),                          665, 270);
        gr.drawRect(                                                        665, 275, 265, 15);
        gr.drawString("Graphite rods: " + IGuiItems.getGraphiteRod(),                  665, 305);
        gr.drawRect(                                                        665, 310, 265, 15);
        gr.drawString("Controm Rods: " + IGuiItems.getControlRod(),                    665, 340);
        gr.drawRect(                                                        665, 345, 265, 15);
        gr.drawString("Titanium plates: " + IGuiItems.getReinforcedTiPlate(),              665, 375);
        gr.drawRect(                                                        665, 380, 265, 15);
        gr.drawString("Fuel rods: " + IGuiItems.getFuelRod(),                          665, 410);
        gr.drawRect(                                                        665, 415, 265, 15);
        gr.drawString("Advanced fuel rods: " + IGuiItems.getAdvancedFuelRod(),         665, 445);
        gr.drawRect(                                                        665, 450, 265, 15);
        gr.drawString("Electronic parts: " + IGuiItems.getElectronicParts(),           665, 480);
        gr.drawRect(                                                        665, 485, 265, 15);
        gr.drawString("Power transmiters: " + IGuiItems.getPowerTransmiter(),          665, 515);
        gr.drawRect(                                                        665, 520, 265, 15);
        gr.drawString("Pure crystals: " + IGuiItems.getPureCrystal(),                  665, 550);
        gr.drawRect(                                                        665, 555, 265, 15);
        gr.drawString("Reinforced ti. plates: " + IGuiItems.getReinforcedTiPlate(),    665, 585);
        gr.drawRect(                                                        665, 590, 265, 15);
        gr.drawString("Electronic circutes: " + IGuiItems.getElectronicCircute(),      665, 620);
        gr.drawRect(                                                        665, 625, 265, 15);
        gr.setColor(Color.red);
        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr.drawRect(847, 65, 81, 35);
        gr.drawString("Store", 862, 90);

    }

}
