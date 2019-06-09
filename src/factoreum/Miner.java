package factoreum;

import java.awt.*;

public class Miner extends Machine {

    protected int ore = 0;
    protected boolean p = false;
    protected int lastLvl = lvl;
    protected int time = 0;
    protected String oreName = "";
    protected int powerU = 0;
    protected IBoard gui = Board.getInstance();


    public Miner(int x, int y, int temperature, int lvl, TYPE type, int id, boolean state) {
        super(x, y, temperature, lvl, type, id, state);
    }




    public void tick() {

        if (ore == 0){
            ore = gui.getBoardFieldOre()[gui.getFx()][gui.getFy()];
            if (ore == 1) {
                oreName = "Coal";
            } else if (ore == 2) {
                oreName = "Titanium";
            } else if (ore == 3) {
                oreName = "Crystals";
            } else {
                oreName = "Uranium";
            }
        }

        powerU = 2*lvl /*Math.round((float)(Math.pow(2, lvl/2)))*/;

        if(p != true) {
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() + powerU);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() - 2*lastLvl);
            p = false;
            lastLvl = lvl;
        }

        if (IGuiRaw.getMaxPower() >= IGuiRaw.getPowerUsage() && time == 0) {
            switch (ore) {
                case 1: {
                    IGuiRaw.setCoal(IGuiRaw.getCoal() + lvl);
                    time = 20;
                    break;
                }
                case 2: {
                    IGuiRaw.setTitanium(IGuiRaw.getTitanium() + lvl);
                    time = 30;
                    break;
                }
                case 3: {
                    IGuiRaw.setCrystals(IGuiRaw.getCrystals() + lvl);
                    time = 40;
                    break;
                }
                case 4: {
                    IGuiRaw.setUranium(IGuiRaw.getUranium() + lvl);
                    time = 50;
                    break;
                }
            }
        } else if (IGuiRaw.getMaxPower() >= IGuiRaw.getPowerUsage() && time != 0) {
            time--;
        }

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

}
