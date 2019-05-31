package factoreum;

import java.awt.*;

public class NuclearGen extends Machine{

    public NuclearGen(int x, int y, int temperature, int lvl, TYPE type, int id, boolean state) {
        super(x, y, temperature, lvl, type,  id, state);
    }
    private int lastLvl = lvl;
    private boolean p = false;
    private int fuelReq = 10*lvl;
    private int fuelTime = 0;
    private int power = 0;

    public void tick() {
        if (IGuiRaw.getUranium()>= fuelReq && p == true){
            if(fuelTime == 0) {
                IGuiRaw.setUranium(IGuiRaw.getUranium()-fuelReq);
                fuelTime = 500;
            } else fuelTime--;
        } else if (IGuiRaw.getUranium() < fuelReq && p == true){
            if (fuelTime == 0){
                IGuiRaw.setMaxPower(IGuiRaw.getMaxPower() - (lastLvl*lastLvl*lastLvl));
                p = false;
            }
            fuelTime--;
        }
        if(p != true && IGuiRaw.getUranium()>= fuelReq) {
            power = (lvl*lvl*lvl);
            IGuiRaw.setMaxPower(IGuiRaw.getMaxPower() + power);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            IGuiRaw.setMaxPower(IGuiRaw.getMaxPower() - (lastLvl*lastLvl*lastLvl));
            p = false;
            lastLvl = lvl;
        }
    }

    private Color sol = new Color(66, 101, 89);

    public void render(Graphics gr) {

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Nuclear gen.", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x +3, y +25);
        gr.drawString("Power: " +power, x+3, y+40);
        gr.drawString("Temp: " + temperature, x+3, y+55);
    }

}
