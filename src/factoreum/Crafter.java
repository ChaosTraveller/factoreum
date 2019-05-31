package factoreum;

import java.awt.*;

public class Crafter extends Machine {
    public Crafter(int x, int y, int temperature, int lvl, TYPE type, int id, boolean state) {
        super(x, y, temperature, lvl, type, id, state);
    }

    protected int powerU = 0;
    protected IBoardCoord gui = Board.getInstance();

    public void tick() {

    }

    private Color sol = new Color(208, 143, 72);
    public void render(Graphics gr) {

        gr.setColor(sol);
        gr.fillRect(x, y, 80, 80);
        gr.setColor(Color.black);
        gr.setFont(new Font("arial", Font.PLAIN, 10));
        gr.drawString("Crafter", x +3, y +10);
        gr.setFont(new Font("arial", Font.PLAIN, 13));
        gr.drawString("lvl: " + lvl, x +3, y +25);
     //   gr.drawString(oreName, x+3, y+40);
        gr.drawString("Power: -" + powerU, x+3, y+53);
        gr.drawString("Temp: " + temperature, x+3, y+68);

    }
}
