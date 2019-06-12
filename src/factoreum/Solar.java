package factoreum;

import java.awt.*;



public class Solar extends Machine{

    public Solar(int x, int y, int temperature, int lvl, TYPE type, int id, boolean state){
        super(x, y, temperature, lvl, type, id, state);
    }
    private int lastLvl = lvl;
    private  boolean p = false;
    private int power = 0;

    private IBoard board = Board.getInstance();

    private int to (int i) {
        if (i <= 0) {
            return 0;
        } else {
            return i;
        }
    }


    public void tick() {

        if(p != true) {
            power = Math.round((float)lvl*lvl/2);
            IGuiRaw.setMaxPower(IGuiRaw.getMaxPower() + power);
            p = true;
        } else if(p == true && lastLvl != lvl) {
            IGuiRaw.setMaxPower(IGuiRaw.getMaxPower() - Math.round((float)lastLvl*lastLvl/2));
            p = false;
            lastLvl = lvl;
        }
    }

    private Color sol = new Color(255, 242, 159);
    public void render(Graphics gr) {


        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Solar gen.", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x +3, y +25);
        gr.drawString("Power: " +power, x+3, y+40);
        gr.drawString("Temp: " + temperature, x+3, y+55);

    }

}
