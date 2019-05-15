package factoreum;

import java.awt.*;

public class FuelGen extends Machine{

    public FuelGen(int x, int y, int temperature, int lvl, ID id) {
        super(x, y, temperature, lvl, id);
    }
    private int lastLvl = lvl;
    private boolean p = false;
    private int fuelReq = lvl;
    private int time = 0;
    private int power = 0;


    public void tick() {
        if (IGuiRaw.getCoal()>= fuelReq && p == true && time == 0){
            IGuiRaw.setCoal(IGuiRaw.getCoal()-fuelReq);
            time = 50;
        } else if (IGuiRaw.getCoal() < fuelReq && p == true){
            IGuiRaw.setMaxPower(IGuiRaw.getMaxPower() - (lastLvl*lastLvl));
            p = false;
        } else if(p == true)time--;
        if(p != true && IGuiRaw.getCoal()>= fuelReq) {
            power = (lvl*lvl);
            IGuiRaw.setMaxPower(IGuiRaw.getMaxPower() + power);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            IGuiRaw.setMaxPower(IGuiRaw.getMaxPower() - (lastLvl*lastLvl));
            p = false;
            lastLvl = lvl;
        }
    }

    private Color sol = new Color(66, 78, 98);

    public void render(Graphics gr) {

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Fuel gen.", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x +3, y +25);
        gr.drawString("Power: " +power, x+3, y+40);
        gr.drawString("Temp: " + temperature, x+3, y+55);

    }
}
