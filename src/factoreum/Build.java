package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Build extends MouseAdapter {

    private static Build ourInstance = new Build();

    private static Build single_instance = null;

    public static Build getInstance()
    {
        if (single_instance == null)
            single_instance = new Build();

        return single_instance;
    }

    private IHandler handler = Handler.getInstance();
    private IBoard gui = Board.getInstance();
    private IStorageRaw raw = Storage.getInstance();
    private int n = 0;

    private static final int[] x = {20,125, 230, 335, 440, 545}, y = {60, 165, 270, 375, 480, 585};

    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (gui.getBoardField()[gui.getFx()][gui.getFy()] == -1 && gui.getOverlap() == OVERLAP.FieldEmpty){
            if (mousePos(mx, my, 665, 130, 265, 35) && raw.getUnits() >= 50) {
                handler.addMachine(new Solar(x[gui.getFx()], y[gui.getFy()], 20, 1, TYPE.Solar, n, true));
                raw.setUnits(raw.getUnits() - 50);
                gui.getBoardField()[gui.getFx()][gui.getFy()] = n;
                n++;
            } else if (mousePos(mx, my, 665, 180, 265, 35) && raw.getUnits() >= 500) {
                handler.addMachine(new FuelGen(x[gui.getFx()], y[gui.getFy()], 20, 1, TYPE.Fuel, n, true));
                raw.setUnits(raw.getUnits() - 500);
                gui.getBoardField()[gui.getFx()][gui.getFy()] = n;
                n++;
            } else if (mousePos(mx, my, 665, 230, 265, 35) && raw.getUnits() >= 2000) {
                handler.addMachine(new NuclearGen(x[gui.getFx()], y[gui.getFy()], 20, 1, TYPE.Nuclear, n, true));
                raw.setUnits(raw.getUnits() - 2000);
                gui.getBoardField()[gui.getFx()][gui.getFy()] = n;
                n++;
            } else if (mousePos(mx, my, 665, 280, 265, 35) && raw.getUnits() >= 200) {
                handler.addMachine(new Miner(x[gui.getFx()], y[gui.getFy()], 20, 1, TYPE.Miner, n, true));
                raw.setUnits(raw.getUnits() - 200);
                gui.getBoardField()[gui.getFx()][gui.getFy()] = n;
                n++;
            } else if (mousePos(mx, my, 665, 330, 265, 35) && raw.getUnits() >= 5000) {
                handler.addMachine(new AdvancedMiner(x[gui.getFx()], y[gui.getFy()], 20, 1, TYPE.AdvancedMiner, n, true));
                raw.setUnits(raw.getUnits() - 5000);
                gui.getBoardField()[gui.getFx()][gui.getFy()] = n;
                n++;
            } else if (mousePos(mx, my, 665, 380, 265, 35) && raw.getUnits() >= 200) {
                handler.addMachine(new Crafter(x[gui.getFx()], y[gui.getFy()], 20, 1, TYPE.Crafter, n, true));
                raw.setUnits(raw.getUnits() - 200);
                gui.getBoardField()[gui.getFx()][gui.getFy()] = n;
                n++;
//            } else if (mousePos(mx, my, 665, 430, 265, 35) && raw.getUnits() >= 300) {
//                handler.addMachine(new CoolingSystem(x[gui.getFx()], y[gui.getFy()], 20, 1, TYPE.Cooler, n, true));
//                raw.setUnits(raw.getUnits() - 300);
//                gui.getBoardField()[gui.getFx()][gui.getFy()] = n;
//                n++;
            }
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

    public void tick() {

    }

    public void render(Graphics gr) {

        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr.setColor(Color.white);
        gr.drawString("Solar generator 50$",                                   670, 155);
        gr.drawRect(                                                           665, 130, 265, 35);
        gr.drawString("Fuel generator 500$",                                    670, 205);
        gr.drawRect(                                                           665, 180, 265, 35);
        gr.drawString("Nuclear reactor 2000$",                                   670, 255);
        gr.drawRect(                                                           665, 230, 265, 35);
        gr.drawString("Miner 200$",                                              670, 305);
        gr.drawRect(                                                           665, 280, 265, 35);
        gr.drawString("Advanced miner 5000$",                                    670, 355);
        gr.drawRect(                                                           665, 330, 265, 35);
        gr.drawString("Crafter 200$",                                   670, 405);
        gr.drawRect(                                                           665, 380, 265, 35);
//        gr.drawString("Cooling system 300$",                                            670, 455);
//        gr.drawRect(                                                           665, 430, 265, 35);

    }

}
