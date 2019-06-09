package factoreum;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {

    private static Menu ourInstance = new Menu();

    private static Menu single_instance = null;

    public static Menu getInstance()
    {
        if (single_instance == null)
            single_instance = new Menu();

        return single_instance;
    }

    private IBoard gui = Board.getInstance();

    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mousePos(mx, my, 665, 230, 265, 35) && gui.getOverlap() == OVERLAP.Menu) {
            System.exit(1);
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

        gr.setColor(Color.white);
        gr.drawString("Save game",                                      670, 155);
        gr.drawRect(                                                        665, 130, 265, 35);
        gr.drawString("Load game",                                      670, 205);
        gr.drawRect(                                                        665, 180, 265, 35);
        gr.drawString("Exit" ,                                          670, 255);
        gr.drawRect(                                                        665, 230, 265, 35);
        gr.setColor(Color.red);
        gr. drawRect(880, 0, 70, 35);
        gr.setFont(new Font("arial", Font.PLAIN, 20));
        gr. drawString("Menu", 890, 25);

    }

}
