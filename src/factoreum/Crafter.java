package factoreum;

import java.awt.*;

public class Crafter extends Machine {
    public Crafter(int x, int y, int temperature, int lvl, TYPE type, int id, boolean state) {
        super(x, y, temperature, lvl, type, id, state);
    }

    protected int powerU = 0;
    protected IBoardCoord gui = Board.getInstance();



    ITEM it = ITEM.none;


    public void tick() {



    }

    private Color c1 = new Color(208, 143, 72);
    public void render(Graphics gr) {

        gr.setColor(c1);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Crafter", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x +3, y +25);
        gr.drawString("Power: -" + powerU, x+3, y+53);
        gr.drawString("Temp: " + temperature, x+3, y+68);

    }

}
