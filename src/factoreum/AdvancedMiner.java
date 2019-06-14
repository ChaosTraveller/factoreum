package factoreum;

import java.awt.*;

public class AdvancedMiner extends Miner {
    public AdvancedMiner(int x, int y, int temperature, int lvl, TYPE type, int id, boolean state) {
        super(x, y, temperature, lvl, type, id, state);
    }

    private int[] ore;
    private IStorageRaw raw = Storage.getInstance();

    public void tick() {
            ore = board.getOre();
            if (ore[id] == 1) {
                oreName = "Coal";
            } else if (ore[id] == 2) {
                oreName = "Titanium";
            } else if (ore[id] == 3) {
                oreName = "Crystals";
            } else if(ore[id] == 4){
                oreName = "Uranium";
            }


        if(p != true) {
            powerU = 4*lvl;
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() + powerU);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() - 4*lastLvl);
            p = false;
            lastLvl = lvl;
        }

        if (state == false && powerU!= 0) {
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() - powerU);
            powerU = 0;
        } else if (state == true && powerU == 0) {
            powerU = 4*lastLvl;
            IGuiRaw.setPowerUsage(IGuiRaw.getPowerUsage() + powerU);

        }

        if (IGuiRaw.getMaxPower() >= IGuiRaw.getPowerUsage() && time == 0 && state == true) {
            switch (ore[id]) {
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

    private Color sol = new Color(157, 98, 155);
    public void render(Graphics gr) {

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Advanced miner", x + 3, y + 10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x + 3, y + 25);
        gr.drawString(oreName, x + 3, y + 40);
        gr.drawString("Power: -" + powerU, x + 3, y + 53);
        gr.drawString("Temp: " + temperature, x + 3, y + 68);

        if (board.getOverlap() == OVERLAP.Field  && board.getFieldtype() == Board.FIELDTYPE.FieldAdvancedMiner) {
            gr.setFont(new Font("arial", Font.PLAIN, 20));
            if (board.getOre()[id] == 1) {
                gr.setColor(Color.red);
                gr.drawString("Coal: " + raw.getCoal(), 670, 245);
            } else if (board.getOre()[id] == 2) {
                gr.setColor(Color.red);
                gr.drawString("Titanium: " + raw.getTitanium(), 670, 285);
            } else if (board.getOre()[id] == 3) {
                gr.setColor(Color.red);
                gr.drawString("Crystals: " + raw.getCrystals(), 670, 325);
            } else if (board.getOre()[id] == 4) {
                gr.setColor(Color.red);
                gr.drawString("Uranium: " + raw.getUranium(), 670, 365);
            }
        }

    }


}
